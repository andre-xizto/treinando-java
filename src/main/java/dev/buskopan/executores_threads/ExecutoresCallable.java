package dev.buskopan.executores_threads;

import java.util.concurrent.*;

public class ExecutoresCallable {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit(new Tarefa());

        System.out.println(future.isDone());
        try {
            //get() espera até a thread terminar de executar e retornar o seu valor
            System.out.println(future.get());
            System.out.println(future.isDone());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdownNow();
        }
    }

    public static class Tarefa implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(3000);
            return Thread.currentThread().getName() + " rodou...";
        }
    }
}
