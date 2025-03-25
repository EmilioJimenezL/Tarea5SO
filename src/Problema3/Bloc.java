package Problema3;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Bloc {
    private final ReadWriteLock RWlock = new ReentrantReadWriteLock();
    private int numGuardado = 0;

    public void escribir(int num) {
        RWlock.writeLock().lock();
        try {
            numGuardado = num;
            System.out.println("Se guardo en el bloc el numero: " + num);
        } finally {
            RWlock.writeLock().unlock();
        }
    }

    public void leer() {
        RWlock.readLock().lock();
        try {
            System.out.println("Un lector leyo el numero: " + numGuardado);
        } finally {
            RWlock.readLock().unlock();
        }
    }
}
