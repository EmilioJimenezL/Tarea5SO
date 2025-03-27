package Problema6;

import Problema5.ConveyorBelt;

import java.util.Random;

public class ProcessA extends Thread {
    private final Printer printer;
    private final Random rand = new Random();

    public ProcessA(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                printer.printMessage("Mensaje del proceso A", true);
                Thread.sleep(rand.nextInt(2000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
