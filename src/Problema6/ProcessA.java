package Problema6;

public class ProcessA extends Thread {
    private final Printer printer;

    public ProcessA(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                printer.printMessage("Message from Process A", true);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
