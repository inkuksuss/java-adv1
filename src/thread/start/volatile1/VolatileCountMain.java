package thread.start.volatile1;

import thread.start.ThreadUtils;

import static thread.start.ThreadUtils.*;

public class VolatileCountMain {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask);
        thread.start();

        sleep(1000);

        myTask.flag = false;
        log("flag = " + myTask.flag + ", count = " + myTask.cnt + "in main");
    }

    static class MyTask implements Runnable {

        volatile boolean flag = true;
        long cnt;

        @Override
        public void run() {
            while (flag) {
                cnt++;
                if (cnt % 100_000_000 == 0) {
                    log("flag = " + flag + ", count = " + cnt);
                }
            }
            log("flag = " + flag + ", count = " + cnt + "종료");
        }
    }
}
