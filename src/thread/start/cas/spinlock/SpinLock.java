package thread.start.cas.spinlock;

import java.util.concurrent.atomic.AtomicBoolean;

import static thread.start.ThreadUtils.log;
import static thread.start.ThreadUtils.sleep;

public class SpinLock {

    private final AtomicBoolean lock = new AtomicBoolean(false);

    public void lock() {
        log("try lock");
        while (!lock.compareAndSet(false, true)) {
            log("lock failed - waiting...");
        }
        log("lock success");
    }

    public void unlock() {
        lock.set(false);
        log("return lock");
    }
}
