package thread.start.printer;

import thread.start.ThreadUtils;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static thread.start.ThreadUtils.*;

public class MyPrinterV1 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread thread = new Thread(printer);
        thread.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            log("입력하세요. 종료(q): ");
            String input = scanner.nextLine();
            if (input.equals("q")) {
                printer.work = false;
                break;
            }
            printer.addJob(input);
        }

    }

    static class Printer implements Runnable {

        volatile boolean work = true;
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
                while (work) {
                    if (jobQueue.isEmpty()) {
                        continue;
                    }

                    String job = jobQueue.poll();
                    log("출력 시작: " + job + ", 대기 문서: " + jobQueue);
                    sleep(3000);
                    log("출력 완료");
                }
                log("printer end");
        }


        public void addJob(String input) {
            jobQueue.offer(input);
        }
    }
}
