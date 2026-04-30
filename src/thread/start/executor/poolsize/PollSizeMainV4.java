package thread.start.executor.poolsize;

import thread.start.executor.RunnableTask;

import java.util.concurrent.*;

import static thread.start.ThreadUtils.log;
import static thread.start.ThreadUtils.sleep;
import static thread.start.executor.ExecutorUtils.printState;

public class PollSizeMainV4 {

//    static final int TASK_SIZE = 1100; // 평시
    static final int TASK_SIZE = 1200; // 긴급
//    static final int TASK_SIZE = 1201; // 위기

    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(
                100,
                200,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000));
        printState(es);

        long start = System.currentTimeMillis();
        for (int i = 0; i < TASK_SIZE; i++) {
            String taskName = "task" + i;
            try {
                es.execute(new RunnableTask(taskName));
                printState(es, taskName);
            } catch (RejectedExecutionException e) {
                log(taskName + " -> " + e);
            }
        }
        es.close();
        long end = System.currentTimeMillis();
        log("time = " + (end - start));
    }
}
