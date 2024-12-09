package dev.buskopan.executores_threads;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutoresScheduled {
    public static void main(String[] args) {
        ScheduledExecutorService schedule = Executors.newScheduledThreadPool(3);

        System.out.println(System.currentTimeMillis());
        // Roda uma vez só depois de 2 segundos
        // schedule.schedule(new Tarefa(),2, TimeUnit.SECONDS);

        // Vai rodar a cada pelo menos 2 segundos (por causa que a thread demora 3 segundos), sem delay na primeira tarefa
        schedule.scheduleAtFixedRate(new Tarefa(),0, 2, TimeUnit.SECONDS);

        // Vai rodar a cada 5 segundos (por causa que a thread demora 3 segundos, então vai rodar 5 segundos depois), sem delay na primeira tarefa
        schedule.scheduleWithFixedDelay(new Tarefa(),0, 2, TimeUnit.SECONDS);

        // Com o shutdown ele vai impedir de novas tarefas chegarem para a thread
        //schedule.shutdown();
    }

//Callable retorna algo, Runnable não retorna nada
    public static class Tarefa implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int random = new Random().nextInt(1000);
            System.out.println(Thread.currentThread().getName() + " rodando "+random + " tempo: "+ LocalDateTime.now());
        }
    }
}
