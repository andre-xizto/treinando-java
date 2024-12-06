package dev.buskopan.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class FilaConsumidor {
    private Queue<Integer> fila = new LinkedList<>();
    private final int capacidade = 5;

    public synchronized void produzir(int item) throws InterruptedException {
        while (fila.size() >= capacidade) {
            System.out.println("Fila cheia. Aguarde liberar espaço");
            wait();
        }
        fila.add(item);
        System.out.println("Produzido: "+ item);
        notify();
    }

    public synchronized int consumir() throws InterruptedException {
        while (fila.isEmpty()) {
            System.out.println("Fila vazia. Aguarde o produtor");
            wait();
        }
        int item = fila.poll();
        System.out.println("Consumido: "+ item);
        notify();
        return item;
    }
}
