package Problema1;

import java.util.Random;

public class Consumidor extends Thread {
    private final Buffer buffer;
    private final Random rand = new Random();

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int objeto = buffer.consumir();
                System.out.println("Consumido: " + objeto);
                sleep(rand.nextInt(2000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
