package Problema3;

import java.util.Random;

public class Escritor extends Thread {
    private final Bloc bloc;
    private final Random rand = new Random();

    public Escritor(Bloc bloc) {
        this.bloc = bloc;
    }

    @Override
    public void run() {
        try {
            while (true) {
                bloc.escribir(rand.nextInt(100));
                Thread.sleep(rand.nextInt(2000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
