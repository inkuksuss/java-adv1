package thread.start.executor.reject;

import thread.start.executor.RunnableTask;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static thread.start.ThreadUtils.log;

public class RejectMainV4 {

    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(
                1,
                1,
                0,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new MyRejectedExecutionHandler());

        es.submit(new RunnableTask("task1"));
        es.submit(new RunnableTask("task2"));
        es.submit(new RunnableTask("task3"));

        es.close();
    }

    static class MyRejectedExecutionHandler implements RejectedExecutionHandler {

        static AtomicInteger cnt = new AtomicInteger(0);

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            int i = cnt.incrementAndGet();
            log("거절된 누적 갯수 = " + i);
        }
    }
}
