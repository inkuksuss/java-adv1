package thread.start.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static thread.start.ThreadUtils.*;

public class CallableMainV1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);

        log("submit call");
        Future<Integer> ft = es.submit(new MyCallable());
        log("future = " + ft);

        log("ft.get() main waiting");
        Integer rs = ft.get();
        log("ft.get() main runnable");

        log("rs = " + rs);
        es.close();
        log("future = " + ft);
    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() {
            log("callable start");
            sleep(2000);
            int v = new Random().nextInt(20);

            log("callable end");
            return v;
        }
    }
}
