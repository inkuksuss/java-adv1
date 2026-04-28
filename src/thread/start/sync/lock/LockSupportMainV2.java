package thread.start.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static thread.start.ThreadUtils.log;
import static thread.start.ThreadUtils.sleep;

public class LockSupportMainV2 {

    public static void main(String[] args) {
        Thread thread = new Thread(new ParkTest());
        thread.start();

        sleep(100);
        log("thread state: " + thread.getState());
        log("main -> unpark");
    }

    static class ParkTest implements Runnable {
        @Override
        public void run() {
            log("park start");
            LockSupport.parkNanos(2000_000000);
            log("park end, state: " + Thread.currentThread().getState());
            log("interrupt state: " + Thread.currentThread().isInterrupted());
        }
    }
}
