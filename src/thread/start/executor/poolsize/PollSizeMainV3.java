package thread.start.executor.poolsize;

import thread.start.executor.RunnableTask;

import java.util.concurrent.*;

import static thread.start.ThreadUtils.log;
import static thread.start.ThreadUtils.sleep;
import static thread.start.executor.ExecutorUtils.printState;

public class PollSizeMainV3 {

    public static void main(String[] args) {

//        ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es = new ThreadPoolExecutor(
                0,
                Integer.MAX_VALUE,
                3L,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        log("pool create");
        printState(es);

        for (int i = 1; i <= 4; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es);
        }

        sleep(3000);
        log("complete");
        printState(es);

        sleep(3000);
        log("max poolSize 대기시간 초과");
        printState(es);

        es.close();
        printState(es);
    }
}
