package thread.start.cas;

import thread.start.ThreadUtils;

import java.util.concurrent.atomic.AtomicInteger;

import static thread.start.ThreadUtils.*;

public class CasMainV2 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("start value = " + atomicInteger.get());

        int rs1 = incrementAndGet(atomicInteger);
        System.out.println("rs1 = " + rs1);
    }

    private static int incrementAndGet(AtomicInteger atomicInteger) {
        int getValue;
        boolean result;

        do {
            getValue = atomicInteger.get();
            log("getValue: " + getValue);
            result = atomicInteger.compareAndSet(getValue, getValue + 1);
            log("rs: " + result);
        } while (!result);
        return getValue + 1;
    }
}
