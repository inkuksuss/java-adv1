package thread.start;

public class ThreadUtils {

    public static void sleep(long ms) {
        try {
            Thread.currentThread().sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void log(String message) {
        System.out.println(message);
    }
}
