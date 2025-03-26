package Problema4;

import java.util.concurrent.Semaphore;

public class BarberShop {
    private final Semaphore barber = new Semaphore(1);
    private final Semaphore customers = new Semaphore(0);
    private final Semaphore accessSeats = new Semaphore(1);
    private final int numberOfSeats;
    private int freeSeats;

    public BarberShop(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
        this.freeSeats = numberOfSeats;
    }

    public void customerWalksIn() throws InterruptedException {
        accessSeats.acquire();
        if (freeSeats > 0) {
            freeSeats--;
            customers.release();
            accessSeats.release();
            barber.acquire();
            getHaircut();
        } else {
            accessSeats.release();
            System.out.println("Customer leaves, no free seats.");
        }
    }

    public void barberWorks() throws InterruptedException {
        while (true) {
            customers.acquire();
            accessSeats.acquire();
            freeSeats++;
            accessSeats.release();
            barber.release();
            cutHair();
        }
    }

    private void getHaircut() throws InterruptedException {
        System.out.println("Customer is getting a haircut.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void cutHair() throws InterruptedException {
        System.out.println("Barber is cutting hair.");
        Thread.sleep((long) (Math.random() * 1000));
    }
}
