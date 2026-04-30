package thread.start.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static thread.start.ThreadUtils.*;
import static thread.start.executor.ExecutorUtils.*;

public class ExecutorBasicMain {

    public static void main(String[] args) {
        ExecutorService es =
                new ThreadPoolExecutor(
                        2,
                        2,
                        0 ,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<>());
        log("init state");
        printState(es);
        es.execute(new RunnableTask("taskA"));
        es.execute(new RunnableTask("taskB"));
        es.execute(new RunnableTask("taskC"));
        es.execute(new RunnableTask("taskD"));
        log("==working==");
        printState(es);

        sleep(3000);
        log("work end");
        printState(es);

        es.close();
        log("showdown");
        printState(es);
    }
}
