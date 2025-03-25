package Problema3;

import java.util.Random;

public class Lector extends Thread {
    private final Bloc resource;
    private final Random rand = new Random();

    public Lector(Bloc resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            while (true) {
                resource.leer();
                Thread.sleep(rand.nextInt(1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
