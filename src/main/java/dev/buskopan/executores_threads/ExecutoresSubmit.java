package dev.buskopan.executores_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutoresSubmit {
    public static void main(String[] args) {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Runnable runnable = () -> {
                String name = Thread.currentThread().getName();
                System.out.println(name + " rodando...");
            };
            Future<?> future = executor.submit(runnable);
            System.out.println(future.isDone());
            executor.shutdown();
            try {
                executor.awaitTermination(2, TimeUnit.SECONDS);
                System.out.println(future.isDone());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                executor.shutdownNow();
                executor.close();
            }
    }
}
