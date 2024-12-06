package dev.buskopan.download_thread;

public class DownloadThread {
    public static void main(String[] args) {
        Thread downloadThread = new Thread(() -> {
            System.out.println("Baixando arquivo...");
            try {
                Thread.sleep(3000);
                System.out.println("Download concluído");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"downloadthread");

        Thread processingThread = new Thread(() ->{
            System.out.println("Processando arquivo...");
            try {
                Thread.sleep(2000);
                System.out.println("Arquivo processado");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"processingthread");

        Thread openThread = new Thread(() -> {
            System.out.println("Abrindo arquivo...");
            try {
                Thread.sleep(1000);
                System.out.println("Arquivo aberto na Thread: "+ Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "openthread");

        downloadThread.start();

        try {
            downloadThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        processingThread.start();

        try {
            processingThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        openThread.start();

    }
}
