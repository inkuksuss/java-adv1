package thread.start.executor.future;

import thread.start.ThreadUtils;

import java.util.concurrent.*;

import static thread.start.ThreadUtils.*;

public class FutureCancelMain {

    private static boolean mayInterruptIfRunning = true;
//    private static boolean mayInterruptIfRunning = false;

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<String> f = es.submit(new MyTask());
        log("f state = " + f.state());

        sleep(3000);

        log("future.cancel(" + mayInterruptIfRunning + ") call");

        boolean cancel = f.cancel(mayInterruptIfRunning);
        log("cancel(" + mayInterruptIfRunning + ") reuslt = " + cancel);

        try {
            log("F result = " + f.get());
        } catch (CancellationException e) {
            log("future is already cancel");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        es.close();
    }

    static class MyTask implements Callable<String> {

        @Override
        public String call() {
            try {
                for (int i = 0; i < 10; i++) {
                    log("working: " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                log("interrupt");
                return "interrupt";
            }
            return "comp";
        }
    }
}
