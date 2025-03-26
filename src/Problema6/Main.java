package Problema6;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        ProcessA processA = new ProcessA(printer);
        ProcessB processB = new ProcessB(printer);
        processA.start();
        processB.start();
    }
}
