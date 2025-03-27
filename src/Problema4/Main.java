package Problema4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        BarberShop shop = new BarberShop(1);
        System.out.println("La barberia esta abierta");
        Barber barber = new Barber(shop);
        barber.start();

        for (int i = 0; i < 10; i++) {
            new Customer(shop).start();
            try {
                Thread.sleep(rand.nextInt(5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
