package thread.start;

public class ThreadUtils {

    public static void sleep(long ms) {
        try {
            Thread.currentThread().sleep(ms);
        } catch (InterruptedException e) {
            log("인터럽트 발생, " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void log(String message) {
        System.out.println(message);
    }
}
