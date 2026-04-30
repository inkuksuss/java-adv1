package thread.start.executor.poolsize;

import thread.start.executor.RunnableTask;

import java.util.concurrent.*;

import static thread.start.ThreadUtils.log;
import static thread.start.ThreadUtils.sleep;
import static thread.start.executor.ExecutorUtils.printState;

public class PollSizeMainV2 {

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(2);

        log("pool create");
        printState(es);

        for (int i = 1; i <= 6; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es);
        }
        es.close();
    }
}
