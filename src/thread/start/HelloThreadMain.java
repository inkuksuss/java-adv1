package thread.start;

public class HelloThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " start");

        HelloThread helloThread = new HelloThread();
        System.out.println("hello start");
        helloThread.start();
        System.out.println("hello end");


        System.out.println(Thread.currentThread().getName() + " end");
    }
}
