package thread.start.executor.future;

import thread.start.ThreadUtils;

import java.util.concurrent.*;

import static thread.start.ThreadUtils.*;

public class FutureExceptionMain {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);

        Future<Integer> f = es.submit(new ExCallable());

        try {
            log("f.get() call, state = " + f.state());
            Integer i = f.get();
            log("result = " + i);
        } catch (ExecutionException e) {
            log("e = " + e);
            log("cause = " + e.getCause());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        es.close();
    }

    static class ExCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            log("start");
            throw new IllegalStateException("ex");
        }
    }
}
