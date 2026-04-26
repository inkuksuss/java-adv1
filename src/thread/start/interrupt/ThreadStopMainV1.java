package thread.start.interrupt;

import static thread.start.ThreadUtils.log;
import static thread.start.ThreadUtils.sleep;

public class ThreadStopMainV1 {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask);
        thread.start();

        sleep(4000);
        log("do interrupt");
        thread.interrupt();
        log("is interrupted?: " + thread.isInterrupted());
    }


    static class MyTask implements Runnable {

        volatile boolean runFlag = true;

        @Override
        public void run() {
            try {
                while (runFlag) {
                    log("working");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                log(e.getMessage());
                log("" + Thread.currentThread().isInterrupted());
                log(Thread.currentThread().getState().toString());
            }
        }
    }
}
