package thread.start.collection.simple.list;

import java.util.Arrays;

import static thread.start.ThreadUtils.sleep;

public class SyncList implements SimpleList {

    private static final int DEFAULT_SIZE = 5;
    private Object[] elementData;
    private int size = 0;

    public SyncList() {
        this.elementData = new Object[DEFAULT_SIZE];
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized void add(Object e) {
        elementData[size] = e;
        sleep(100);
        size++;
    }

    @Override
    public synchronized Object get(int idx) {
        return elementData[idx];
    }

    @Override
    public synchronized String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) +
                ", size = " + size + ", capacity = " + elementData.length;
    }
}
