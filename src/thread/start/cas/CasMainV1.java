package thread.start.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasMainV1 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("start value = " + atomicInteger.get());

        boolean rs = atomicInteger.compareAndSet(0, 1);
        System.out.println("rs = " + rs + ", value = " + atomicInteger.get());

        boolean rs2 = atomicInteger.compareAndSet(0, 1);
        System.out.println("rs = " + rs2 + ", value = " + atomicInteger.get());
    }
}
