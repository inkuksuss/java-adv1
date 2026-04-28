package thread.start.bounded;

import thread.start.ThreadUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static thread.start.ThreadUtils.*;

public class BoundedQueueV6_2 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV6_2(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        boolean offer = queue.offer(data);
        log("offer = " + offer);
    }

    @Override
    public String take() {
        String poll = queue.poll();
        log("poll = " + poll);
        return poll;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
