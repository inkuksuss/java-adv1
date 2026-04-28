package thread.start.bounded;

public interface BoundedQueue {

    void put(String data);

    String take();
}
