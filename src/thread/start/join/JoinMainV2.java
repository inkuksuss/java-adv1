package thread.start.join;

import static thread.start.ThreadUtils.log;
import static thread.start.ThreadUtils.sleep;

public class JoinMainV2 {

    public static void main(String[] args) throws InterruptedException {
        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(51, 100);

        Thread thread1 = new Thread(sumTask1);
        Thread thread2 = new Thread(sumTask2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        log("task1 = " + sumTask1.result);
        log("task2 = " + sumTask2.result);

        int sumResult = sumTask1.result + sumTask2.result;
        log("sum result = " + sumResult);

    }

    static class SumTask implements Runnable {

        private int startValue;
        private int endValue;
        private int result = 0;

        public SumTask(int i1, int i2) {
            this.startValue = i1;
            this.endValue = i2;
        }

        @Override
        public void run() {
            log("start");
            sleep(2000);
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            this.result = sum;
            log("result = " + this.result);
        }
    }
}
