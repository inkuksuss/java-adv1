package thread.start.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static thread.start.executor.ExecutorUtils.*;

public class PrestartPoolMain {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1000);
        printState(es);
        ThreadPoolExecutor pEs = (ThreadPoolExecutor) es;
        pEs.prestartAllCoreThreads();
        printState(es);
    }
}
