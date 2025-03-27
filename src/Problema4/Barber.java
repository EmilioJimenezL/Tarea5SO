package Problema4;

import java.util.Random;

public class Barber extends Thread {
    private final BarberShop shop;
    private final Random rand = new Random();

    public Barber(BarberShop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            sleep(rand.nextInt(5000));
            shop.barberWorks();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
