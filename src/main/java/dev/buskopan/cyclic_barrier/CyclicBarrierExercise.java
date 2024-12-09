package dev.buskopan.cyclic_barrier;

import java.util.concurrent.*;

public class CyclicBarrierExercise {

    private static BlockingDeque<Double> lista = new LinkedBlockingDeque<>();
    private static ExecutorService executor;
    private static CyclicBarrier barrier;
    private static Runnable r1;
    private static Runnable r2;
    private static Runnable r3;
    // Fazer a operação em 3 threads diferentes e juntar os resultados no final
    //(412*3) + (34^4) + (45*322/12) = ?
    public static void main(String[] args) {

        Runnable sumarizacao = () -> {
            double result = 0;
            System.out.println("Iniciando sumarizacao");
            result += lista.poll();
            result += lista.poll();
            result += lista.poll();
            System.out.println("Resultado final: "+ result);
            System.out.println("Fim da sumarizacao");
        };

        //3 é o número de threads que eu quero que a barreira espere atingir para liberar a execução delas
        barrier = new CyclicBarrier(3, sumarizacao);

        executor = Executors.newFixedThreadPool(3);

        r1 = () -> {
            System.out.println(Thread.currentThread().getName() + " inicou");
            lista.add(412d*3d);
            // vai ficar esperando aqui até a barreira ficar com 3 threads esperando, depois serão liberadas a executar
            await(barrier);
            System.out.println(Thread.currentThread().getName() + " Terminei");
            restart();
        };
        r2 = () -> {
            System.out.println(Thread.currentThread().getName() + " inicou");
            lista.add(Math.pow(34d,4d));
            await(barrier);
            System.out.println(Thread.currentThread().getName() + " Terminei");
            restart();
        };
        r3 = () -> {
            System.out.println(Thread.currentThread().getName() + " inicou");
            lista.add((45d*322d)/12d);
            await(barrier);
            System.out.println(Thread.currentThread().getName() + " Terminei");
            restart();
        };

        executor.submit(r1);
        executor.submit(r2);
        executor.submit(r3);
    }

    private static void await(CyclicBarrier barrier) {
        try {
            barrier.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    private static void restart() {
        sleep();
        executor.submit(r1);
        executor.submit(r2);
        executor.submit(r3);
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
