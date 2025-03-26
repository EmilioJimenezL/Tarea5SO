package Problema4;

public class Barber extends Thread {
    private final BarberShop shop;

    public Barber(BarberShop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            shop.barberWorks();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
