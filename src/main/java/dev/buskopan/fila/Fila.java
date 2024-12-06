package dev.buskopan.fila;

public class Fila {
    private int[] elementos;
    private int frente;
    private int tamanho = 0;
    private int capacidade;

    public Fila(int capacidade) {
        this.elementos = new int[capacidade];
        this.frente = 0;
        this.tamanho = 0;
        this.capacidade = capacidade;
    }

    public void enqeue(int elemento) {
        if (isFull()) {
            System.out.println("Fila cheia");
            return;
        }
        elementos[frente++] = elemento;
        tamanho++;
    }

    public int deqeue() {
        if (isEmpty()) {
            System.out.println("Fila vazia");
            return -1;
        }
        int elemento = elementos[frente--];
        tamanho--;
        return elemento;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Fila vazia");
            return -1;
        }
        return elementos[frente-1];
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == capacidade;
    }

    public static void main(String[] args) {
        Fila fila = new Fila(10);

        fila.enqeue(5); fila.enqeue(10);
        System.out.println("Frente: "+fila.peek());
        fila.deqeue();
        System.out.println("Frente: "+fila.peek());
    }
}
