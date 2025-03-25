package Problema2;

import java.util.concurrent.locks.Lock;

public class Filosofo extends Thread {
    private final Lock tenedorIzq;
    private final Lock tenedorDer;

    public Filosofo(Lock tenedorIzq, Lock tenedorDer) {
        this.tenedorIzq = tenedorIzq;
        this.tenedorDer = tenedorDer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                comer();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " esta pensando.");
        Thread.sleep(1000);
    }

    private void comer() throws InterruptedException {
        tenedorIzq.lock();
        tenedorDer.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " esta comiendo.");
            Thread.sleep(2000);
        } finally {
            tenedorIzq.unlock();
            tenedorDer.unlock();
            System.out.println(Thread.currentThread().getName() + " dejo de comer.");
        }
    }
}
