package thread.start.cas.increment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static thread.start.ThreadUtils.log;
import static thread.start.ThreadUtils.sleep;

public class CasManinV3 {

    private static final int THREAD_COUNT = 2;

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(() -> incrementAndGet(atomicInteger));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int rs = atomicInteger.get();
        System.out.println(atomicInteger.getClass().getSimpleName() + " rs = " + rs);
    }

    private static int incrementAndGet(AtomicInteger atomicInteger) {
        int getValue;
        boolean result;

        do {
            getValue = atomicInteger.get();
            sleep(100);
            log("[" + Thread.currentThread().getName() + "] " + "getValue: " + getValue);
            result = atomicInteger.compareAndSet(getValue, getValue + 1);
            log("[" + Thread.currentThread().getName() + "] " + "rs: " + result);
        } while (!result);

        return getValue + 1;
    }
}
