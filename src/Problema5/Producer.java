package Problema5;

public class Producer extends Thread {
    private final ConveyorBelt belt;

    public Producer(ConveyorBelt belt) {
        this.belt = belt;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                belt.produce(i);
                System.out.println("Produced: " + i);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
