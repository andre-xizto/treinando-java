package dev.buskopan.executores_threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutoresExecute {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Runnable runnable = () -> {
//            Causo um erro, pois a thread demora 5 segundos para executar, mas o timeout é de 2 segundos
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            String name = Thread.currentThread().getName();
            System.out.println(name + " rodando...");
        };
        executor.execute(runnable);
        try {
            executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdownNow();
            executor.close();
        }
    }
}
