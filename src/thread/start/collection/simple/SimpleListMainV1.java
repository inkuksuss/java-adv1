package thread.start.collection.simple;

import thread.start.collection.simple.list.BasicList;
import thread.start.collection.simple.list.SimpleList;

public class SimpleListMainV1 {

    public static void main(String[] args) {

        SimpleList basicList = new BasicList();
        basicList.add("A");
        basicList.add("B");
        System.out.println("list = " + basicList);

    }
}
