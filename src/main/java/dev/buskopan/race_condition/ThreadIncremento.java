package dev.buskopan.race_condition;

public class ThreadIncremento extends Thread{
    private Contador contador;

    public ThreadIncremento(Contador contador) {
        super();
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            contador.incrementar();
        }
    }
}
