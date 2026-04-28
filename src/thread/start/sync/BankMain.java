package thread.start.sync;

import thread.start.ThreadUtils;

import static thread.start.ThreadUtils.*;

public class BankMain {

    public static void main(String[] args) throws InterruptedException {
//        BankAccount account = new BankAccountV1(1000);
//        BankAccount account = new BankAccountV2(1000);
//        BankAccount account = new BankAccountV3(1000);
//        BankAccount account = new BankAccountV4(1000);
//        BankAccount account = new BankAccountV5(1000);
        BankAccount account = new BankAccountV6(1000);
        Thread thread1 = new Thread(new WithdrawTask(account, 800), "T1");
        Thread thread2 = new Thread(new WithdrawTask(account, 800), "T2");
        thread1.start();
        thread2.start();

        sleep(500);

        thread1.join();
        thread2.join();

        log("최종 잔액: " + account.getBalance());
    }
}
