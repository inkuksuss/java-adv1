package thread.start.cas.spinlock;

import static thread.start.ThreadUtils.*;

public class SpinLockBad {

    private volatile boolean lock = false;

    public void lock() {
        log("try lock");
        while (true) {
            if (!lock) {
                sleep(100);
                lock = true;
                break;
            }
            else {
                log("lock failed - waiting...");
            }
        }
        log("lock success");
    }

    public void unlock() {
        lock = false;
        log("return lock");
    }
}
