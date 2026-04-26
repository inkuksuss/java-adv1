package thread.start.interrupt;

import static thread.start.ThreadUtils.log;
import static thread.start.ThreadUtils.sleep;

public class ThreadStopMainV3 {

    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask);
        thread.start();
        sleep(100);
        log("do interrupt");
        thread.interrupt();
        log("is interrupted?: " + thread.isInterrupted());
    }


    static class MyTask implements Runnable {

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                log("working");
            }
            log("my task is interrupt?: " + Thread.currentThread().isInterrupted());
            log("my task getState: " + Thread.currentThread().getState());
        }
    }
}
