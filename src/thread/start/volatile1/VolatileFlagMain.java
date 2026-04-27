package thread.start.volatile1;

import thread.start.ThreadUtils;

import static thread.start.ThreadUtils.*;

public class VolatileFlagMain {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask);
        log("" + myTask.runFlag);
        thread.start();

        sleep(1000);
        log("try runFlag -> false");
        myTask.runFlag = false;
        log("runFlag = " + myTask.runFlag);
        log("main exit");
    }

    static class MyTask implements Runnable {
        volatile boolean runFlag = true;

        @Override
        public void run() {
            log("task start");

            while (runFlag) {
                log("hello");
            }

            log("end");

        }
    }
}
