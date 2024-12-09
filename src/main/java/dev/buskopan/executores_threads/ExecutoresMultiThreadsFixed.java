package dev.buskopan.executores_threads;

import java.util.concurrent.*;

public class ExecutoresMultiThreadsFixed {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Callable<String> callable = () -> Thread.currentThread().getName() + " rodando";

        // cria apenas 4 threads
        for (int i = 0; i<100; i++) {
            Future<String> future = executor.submit(callable);
            System.out.println(future.get());
        }
        // sem close() ou shutdown() o programa roda indefinidamente
        executor.close();
    }
}
