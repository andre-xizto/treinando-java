package dev.buskopan.pilha;

import java.util.Arrays;

public class Pilha {
    private int capacidade;
    private int[] elementos;
    private int topo;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        elementos = new int[capacidade];
        topo = -1;
    }

    public void push(int elemento) {
        if (topo == capacidade - 1) {
            System.out.println("Pilha cheia. Não pode adicionar item");
            return;
        }
        elementos[++topo] = elemento;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Pilha vazia. Impossível remover");
            return -1;
        }
        return elementos[topo--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Lista vazia. -1 por padrão");
            return -1;
        }
        return  elementos[topo];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha(10);
        pilha.push(2);
        System.out.println("Removendo: "+ pilha.pop());
        pilha.push(10);
        pilha.push(34);
        pilha.push(64);
        System.out.println("Topo: "+ pilha.peek());
        System.out.println("Removendo: "+ pilha.pop());
    }

}
