package thread.start.executor.future;

import thread.start.ThreadUtils;

import java.util.concurrent.*;

import static thread.start.ThreadUtils.*;

public class SumTaskMainV1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SumTask t1 = new SumTask(1, 50);
        SumTask t2 = new SumTask(51, 100);

        ExecutorService es = Executors.newFixedThreadPool(2);

        Future<Integer> f1 = es.submit(t1);
        Future<Integer> f2 = es.submit(t2);

        Integer v1 = f1.get();
        Integer v2 = f2.get();

        log("v1 = " + v1);
        log("v2 = " + v2);

        log("sum = " + (v1 + v2));
    }

    static class SumTask implements Callable<Integer> {

        int startV;
        int endV;

        public SumTask(int startV, int endV) {
            this.startV = startV;
            this.endV = endV;
        }

        @Override
        public Integer call() throws Exception {
            log("start");
            Thread.sleep(2000);
            int sum = 0;
            for (int i = startV; i <= endV; i++) {
                sum += i;
            }
            log("end sum = " + sum);
            return sum;
        }
    }

}
