package dev.buskopan.count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchEx {
    private static CountDownLatch countDownLatch = new CountDownLatch(3);
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(3);

        Runnable r1 = () -> {
            sleep();
            countDownLatch.countDown();
            await();
            System.out.println("R1 RODANDO");
        };
        Runnable r2 = () -> {
            sleep();
            countDownLatch.countDown();
            await();
            System.out.println("R2 RODANDO");
        };
        Runnable r3 = () -> {
            sleep();
            countDownLatch.countDown();
            await();
            System.out.println("R3 RODANDO");

        };

        float x = 5;

        executor.execute(r1);
        executor.execute(r2);
        executor.execute(r3);

        executor.shutdown();
    }

    private static void await() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
