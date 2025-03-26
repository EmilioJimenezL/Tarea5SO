package Problema5;

public class Main {
    public static void main(String[] args) {
        ConveyorBelt belt = new ConveyorBelt(5);
        Producer producer1 = new Producer(belt);
        Producer producer2 = new Producer(belt);
        Consumer consumer1 = new Consumer(belt);
        Consumer consumer2 = new Consumer(belt);
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
