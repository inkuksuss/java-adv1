package thread.start.bounded;


import java.util.ArrayDeque;
import java.util.Queue;

import static thread.start.ThreadUtils.log;
import static thread.start.ThreadUtils.sleep;

public class BoundedQueueV3 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV3(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        while (queue.size() == max) {
            log("queue size is max, waiting...");
            try {
                wait(); // RUNNABLE -> WAITING
                log("[put] producer wake up");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.offer(data);
        log("[put] save data, call notify()");
        notify(); // WAIT -> BLOCKED
    }

    @Override
    public synchronized String take() {
        while (queue.isEmpty()) {
            log("queue has no data, waiting...");
            try {
                wait();
                log("[take] consumer wake up");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        String result = queue.poll();
        log("[take] get data, call notify()");
        notify(); // WAIT -> BLOCKED
        return result;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
