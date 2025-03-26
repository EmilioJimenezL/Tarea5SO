package Problema5;

import java.util.LinkedList;
import java.util.Queue;

public class ConveyorBelt {
    private final int maxSize;
    private final Queue<Integer> queue = new LinkedList<>();

    public ConveyorBelt(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == maxSize) {
            wait();
        }
        queue.add(value);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int value = queue.poll();
        notifyAll();
        return value;
    }
}
