package thread.start.collection.simple.java;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ListMain {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> copyList = new CopyOnWriteArrayList<>();
        copyList.add(1);
        copyList.add(2);
        copyList.add(3);
        System.out.println("copyList = " + copyList);
    }
    
}
