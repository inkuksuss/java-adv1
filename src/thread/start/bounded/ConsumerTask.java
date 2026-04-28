package thread.start.bounded;

import static thread.start.ThreadUtils.*;

public class ConsumerTask implements Runnable {

    private BoundedQueue queue;

    public ConsumerTask(BoundedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        log("[consumer try]   ? <- " + queue);
        String data = queue.take();
        log("[consumer complete] " + data + " <- " + queue);
    }
}
