package thread.start.cas.spinlock;

import thread.start.ThreadUtils;

import static thread.start.ThreadUtils.*;

public class SpinLockMain {

    public static void main(String[] args) {

//        SpinLockBad spinLock = new SpinLockBad();
        SpinLock spinLock = new SpinLock();

        Runnable runnable = () -> {
            spinLock.lock();
            try {
                log("service execute");
                sleep(1);
            } finally {
                spinLock.unlock();
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
    }
}
