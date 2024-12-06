package dev.buskopan.producer_consumer;

public class ProducerConsumer {
    public static void main(String[] args) {
        FilaConsumidor fila = new FilaConsumidor();

        Thread produtor = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    fila.produzir(i);
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "produtor");

        Thread consumidor = new Thread(() -> {
           for (int i = 0; i < 10; i++) {
               try {
                   Thread.sleep(7000);
                   fila.consumir();
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        }, "consumidor");

        produtor.start();
        consumidor.start();
    }
}
