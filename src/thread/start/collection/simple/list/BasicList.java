package thread.start.collection.simple.list;

import thread.start.ThreadUtils;

import java.util.Arrays;

import static thread.start.ThreadUtils.*;

public class BasicList implements SimpleList {

    private static final int DEFAULT_SIZE = 5;
    private Object[] elementData;
    private int size = 0;

    public BasicList() {
        this.elementData = new Object[DEFAULT_SIZE];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object e) {
        elementData[size] = e;
        sleep(100);
        size++;
    }

    @Override
    public Object get(int idx) {
        return elementData[idx];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) +
                ", size = " + size + ", capacity = " + elementData.length;
    }
}
