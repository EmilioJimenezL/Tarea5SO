package Problema4;

public class Main {
    public static void main(String[] args) {
        BarberShop shop = new BarberShop(3);
        Barber barber = new Barber(shop);
        barber.start();

        for (int i = 0; i < 10; i++) {
            new Customer(shop).start();
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
