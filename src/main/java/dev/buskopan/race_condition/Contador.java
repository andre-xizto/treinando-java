package dev.buskopan.race_condition;

public class Contador {
    private int contador = 0;

    // Se tirar o synchronized o valor total do contador pode ser diferente de 2000
    public synchronized void incrementar() {
        contador++;
    }

    public synchronized int getContador() {
        return contador;
    }
}
