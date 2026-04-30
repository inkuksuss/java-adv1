package thread.start.executor.future;

import thread.start.ThreadUtils;
import thread.start.executor.CallableTask;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAnyMain {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(10);

        CallableTask task1 = new CallableTask("task1", 1000);
        CallableTask task2 = new CallableTask("task2", 1000);
        CallableTask task3 = new CallableTask("task3", 1000);
        List<CallableTask> tasks = List.of(task1, task2, task3);

        Integer v = es.invokeAny(tasks);
        ThreadUtils.log("v = " + v);
        es.close();
    }
}
