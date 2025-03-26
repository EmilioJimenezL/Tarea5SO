package Problema6;

public class ProcessB extends Thread {
    private final Printer printer;

    public ProcessB(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                printer.printMessage("Message from Process B", false);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
