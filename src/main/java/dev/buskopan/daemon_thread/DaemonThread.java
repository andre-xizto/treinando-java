package dev.buskopan.daemon_thread;

public class DaemonThread {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Log do sistema feito em segundo plano na thread "+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "log-thread");

        //true quer dizer que ao chegar no fim desse código a thread será interrompida automaticamente
        daemonThread.setDaemon(true);
        daemonThread.start();

        System.out.println("Rodando sistema...");

        Thread download = new Thread(() -> {
            System.out.println("Baixando arquivo...");
            try {
                Thread.sleep(5000);
                System.out.println("Download feito!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"DOWNLOAD");

        download.start();

        try {
            download.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Fechando sistema...");
    }
}
