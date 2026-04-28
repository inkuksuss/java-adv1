package thread.start.collection.simple;

import thread.start.collection.simple.list.BasicList;
import thread.start.collection.simple.list.SimpleList;
import thread.start.collection.simple.list.SyncList;

import static thread.start.ThreadUtils.*;

public class SimpleListMainV2 {

    public static void main(String[] args) throws InterruptedException {

        test(new SyncList());
    }

    private static void test(SimpleList basicList) throws InterruptedException {
        log(basicList.getClass().getSimpleName());

        Runnable runnableA = () -> {
            basicList.add("A");
            log("T1: list add A");
        };

        Runnable runnableB = () -> {
            basicList.add("B");
            log("T1: list add B");
        };

        Thread threadA = new Thread(runnableA);
        Thread threadB = new Thread(runnableB);

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        log(basicList.toString());
    }
}
