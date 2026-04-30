package thread.start.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static thread.start.ThreadUtils.*;

public abstract class ExecutorUtils {

    public static void printState(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            int poolSize = poolExecutor.getPoolSize();
            int activeCount = poolExecutor.getActiveCount();
            int queued = poolExecutor.getQueue().size();
            long completedTaskCount = poolExecutor.getCompletedTaskCount();
            log("[pool=" + poolSize + ", activeCnt = " + activeCount +
                    ", queued = " + queued + " , compCnt = " + completedTaskCount + "]");
        }
        else {
            log(executorService.toString());
        }
    }

    public static void printState(ExecutorService executorService, String taskName) {
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            int poolSize = poolExecutor.getPoolSize();
            int activeCount = poolExecutor.getActiveCount();
            int queued = poolExecutor.getQueue().size();
            long completedTaskCount = poolExecutor.getCompletedTaskCount();
            log(taskName + " -> [pool=" + poolSize + ", activeCnt = " + activeCount +
                    ", queued = " + queued + " , compCnt = " + completedTaskCount + "]");
        }
        else {
            log(executorService.toString());
        }
    }
}
