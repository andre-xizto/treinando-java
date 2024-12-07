package dev.buskopan.threads_na_lista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadsNaLista {

    public static List<String> lista = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        // Ao atribuir a lista sincronizada resolve o problema de alguma thread não inserir o item na lista
        lista = Collections.synchronizedList(lista);
        Runnable runnable = () -> {
            lista.add("TEXT NA LISTA");
            String name = Thread.currentThread().getName();
            System.out.println(name + " inseriu na lista!");
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(300);
        System.out.println(lista.toString());
    }
}
