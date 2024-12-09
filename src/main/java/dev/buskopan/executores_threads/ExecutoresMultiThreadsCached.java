package dev.buskopan.executores_threads;

import java.util.concurrent.*;

public class ExecutoresMultiThreadsCached {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Callable<String> callable = () -> Thread.currentThread().getName() + " rodando";

        // cria threads dinamicamente, mas reutiliza aquelas que estão ociosas
        for (int i = 0; i<10000; i++) {
            Future<String> future = executor.submit(callable);
            System.out.println(future.get());
        }
        // sem close() ou shutdown() o programa roda indefinidamente
        executor.close();
    }
}
