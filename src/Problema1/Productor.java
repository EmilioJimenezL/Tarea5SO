package Problema1;

import java.util.Random;

public class Productor extends Thread {
    private final Buffer buffer;
    private final Random rand = new Random();

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int producto = rand.nextInt(100);
                int sleep = rand.nextInt(500);
                buffer.producir(producto);
                System.out.println("Producido: " + producto);
                sleep(sleep);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
