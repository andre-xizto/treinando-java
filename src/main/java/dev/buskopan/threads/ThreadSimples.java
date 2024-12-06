package dev.buskopan.threads;

public class ThreadSimples {
    public static void main(String[] args) {
        Thread thread1 = new MinhaThread("THREAD1");
        Thread thread2 = new MinhaThread("THREAD2");
        System.out.println("Thread atual "+ Thread.currentThread());
        thread1.start();
        thread2.start();
    }
}
