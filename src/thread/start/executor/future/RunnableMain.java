package thread.start.executor.future;

import java.util.Random;

import static thread.start.ThreadUtils.*;

public class RunnableMain {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        thread.join();
        int rs = myRunnable.value;
        log("rs = " + rs);
    }

    static class MyRunnable implements Runnable {
        int value;

        @Override
        public void run() {
            log("run start");
            sleep(2000);
            value = new Random().nextInt(10);
            log("create value = " + value);
            log("run end");
        }
    }
}
