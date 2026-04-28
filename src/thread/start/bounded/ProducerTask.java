package thread.start.bounded;

import thread.start.ThreadUtils;

import static thread.start.ThreadUtils.*;

public class ProducerTask implements Runnable {

    private BoundedQueue queue;
    private String request;

    public ProducerTask(BoundedQueue queue, String request) {
        this.queue = queue;
        this.request = request;
    }

    @Override
    public void run() {
        log("[producer try] " + request + " -> " + queue);
        queue.put(request);
        log("[producer complete] " + request + " -> " + queue);
    }
}
