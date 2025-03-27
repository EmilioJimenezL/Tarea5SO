package Problema4;

import java.util.concurrent.Semaphore;
import java.util.LinkedList;
import java.util.Queue;

public class BarberShop {
    private final Semaphore barber = new Semaphore(1);
    private final Semaphore customers = new Semaphore(0);
    private final Semaphore accessSeats = new Semaphore(1);
    private final int numberOfSeats;
    private int freeSeats;
    private final Queue<Customer> customerList  = new LinkedList<>();

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
            System.out.println("El cliente se va, no hay asientos.");
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
        System.out.println("El cliente esta recibiendo un corte de pelo");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void cutHair() throws InterruptedException {
        System.out.println("El barbero esta cortando el pelo");
        Thread.sleep((long) (Math.random() * 1000));
    }
}
