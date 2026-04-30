package thread.start.executor.poolsize;

import thread.start.executor.RunnableTask;

import java.util.concurrent.*;

import static thread.start.ThreadUtils.*;
import static thread.start.executor.ExecutorUtils.*;

public class PollSizeMainV1 {

    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> workQ = new ArrayBlockingQueue<>(2);

        ExecutorService es = new ThreadPoolExecutor(2, 4, 3000, TimeUnit.MILLISECONDS, workQ);
        printState(es);

        es.execute(new RunnableTask("task1"));
        printState(es, "task1");

        es.execute(new RunnableTask("task2"));
        printState(es, "task2");

        es.execute(new RunnableTask("task3"));
        printState(es, "task3");

        es.execute(new RunnableTask("task4"));
        printState(es, "task4");

        es.execute(new RunnableTask("task5"));
        printState(es, "task5");

        es.execute(new RunnableTask("task6"));
        printState(es, "task6");

        try {
            es.execute(new RunnableTask("task7"));
            printState(es, "task7");
        } catch (RejectedExecutionException e) {
            log("task7 거절 예외: " + e);
        }

        sleep(3000);
        log("==작업 수행 완료==");
        printState(es);

        sleep(3000);
        log("== maxPoolSize 대기 시간 초과 == ");
        printState(es);

        es.close();
        log("== shutdown ==");
        printState(es);
    }
}
