import Productes.*;

public class Main {
    public static void main(String[] args) {
        Productes[] llistaCompra = new Productes[100];
        llistaCompra[0] = new Alimentacio(5.50F, "Oli", 1234, "04-10-2004");


        System.out.println(llistaCompra[0]);
    }
}