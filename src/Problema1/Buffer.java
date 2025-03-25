package Problema1;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private final int bufferSize;
    private final Queue<Integer> cola = new LinkedList<>();

    public Buffer(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public synchronized void producir(int value) throws InterruptedException {
        while (cola.size() == bufferSize) {
            wait();
        }
        cola.add(value);
        notifyAll();
    }

    public synchronized int consumir() throws InterruptedException {
        while (cola.isEmpty()) {
            wait();
        }
        int value = cola.poll();
        notifyAll();
        return value;
    }
}
