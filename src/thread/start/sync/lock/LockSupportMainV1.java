package thread.start.sync.lock;

import thread.start.ThreadUtils;

import java.util.concurrent.locks.LockSupport;

import static thread.start.ThreadUtils.*;

public class LockSupportMainV1 {

    public static void main(String[] args) {
        Thread thread = new Thread(new ParkTest());
        thread.start();

        sleep(100);
        log("thread state: " + thread.getState());
        log("main -> unpark");
//        LockSupport.unpark(thread);
        thread.interrupt();
    }

    static class ParkTest implements Runnable {
        @Override
        public void run() {
            log("park start");
            LockSupport.park();
            log("park end, state: " + Thread.currentThread().getState());
            log("interrupt state: " + Thread.currentThread().isInterrupted());
        }
    }
}
