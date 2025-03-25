package Problema2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock[] tenedores = new ReentrantLock[5];
        for (int i = 0; i < tenedores.length; i++) {
            tenedores[i] = new ReentrantLock();
        }

        Filosofo[] filosofos = new Filosofo[5];
        for (int i = 0; i < filosofos.length; i++) {
            Lock tenedorIzq = tenedores[i];
            Lock tenedorDer = tenedores[(i + 1) % tenedores.length];
            filosofos[i] = new Filosofo(tenedorIzq, tenedorDer);
            filosofos[i].start();
        }
    }
}
