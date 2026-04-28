package thread.start.collection.simple.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyncListMain {

    public static void main(String[] args) {
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        syncList.add("data1");
        syncList.add("data2");
        syncList.add("data3");

    }
}
