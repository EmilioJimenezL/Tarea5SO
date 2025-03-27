package Problema4;

public class Customer extends Thread {
    private final BarberShop shop;

    public Customer(BarberShop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            System.out.println("Un cliente entra...");
            shop.customerWalksIn();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
