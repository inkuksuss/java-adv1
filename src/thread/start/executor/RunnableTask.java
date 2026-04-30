package thread.start.executor;

import thread.start.ThreadUtils;

import static thread.start.ThreadUtils.*;

public class RunnableTask implements Runnable {

    private final String name;
    private int sleepMs = 1000;

    public RunnableTask(String name) {
        this.name = name;
    }

    public RunnableTask(String name, int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }

    @Override
    public void run() {
        log(name + " start");
        sleep(sleepMs);
        log(name + " end");
    }
}
