package dev.buskopan.race_condition;

public class Sincronizacao {
    public static void main(String[] args) {
        Contador contador = new Contador();

        ThreadIncremento thread1 = new ThreadIncremento(contador);
        ThreadIncremento thread2 = new ThreadIncremento(contador);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Valor do contador: "+contador.getContador());
    }
}
