package Problema5;

public class Consumer extends Thread {
    private final ConveyorBelt belt;

    public Consumer(ConveyorBelt belt) {
        this.belt = belt;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int value = belt.consume();
                System.out.println("Consumed: " + value);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
