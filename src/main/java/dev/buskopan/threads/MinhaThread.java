package dev.buskopan.threads;

public class MinhaThread extends Thread{
    private String msg;

    public MinhaThread(String msg) {
        super();
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(msg + " - iteração: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
