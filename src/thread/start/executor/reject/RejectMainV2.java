package thread.start.executor.reject;

import thread.start.executor.RunnableTask;

import java.util.concurrent.*;

import static thread.start.ThreadUtils.log;

public class RejectMainV2 {

    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(
                1,
                1,
                0,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new ThreadPoolExecutor.DiscardPolicy());

        es.submit(new RunnableTask("task1"));
        es.submit(new RunnableTask("task2"));

        es.close();
    }
}
