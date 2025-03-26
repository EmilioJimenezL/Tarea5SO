package Problema6;

public class Printer {
    private boolean turn = true;

    public synchronized void printMessage(String message, boolean myTurn) throws InterruptedException {
        while (turn != myTurn) {
            wait();
        }
        System.out.println(message);
        turn = !turn;
        notifyAll();
    }
}
