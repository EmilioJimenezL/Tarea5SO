package Problema3;

public class Main {
    public static void main(String[] args) {
        Bloc resource = new Bloc();
        Escritor escritor = new Escritor(resource);
        Lector lector1 = new Lector(resource);
        Lector lector2 = new Lector(resource);
        escritor.start();
        lector1.start();
        lector2.start();
    }
}
