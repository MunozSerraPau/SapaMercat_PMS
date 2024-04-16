import Productes.*;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int opcioMneuIni,opcioMenuProd;

        Productes[] llistaCompra = new Productes[100];
        llistaCompra[0] = new Alimentacio("Oli", 5.50F, 1234, "04-10-2004");
        llistaCompra[1] = new Alimentacio("Tomaquet", 7.45F, 2345, "04-10-2004");

        System.out.println(llistaCompra[0]);
        System.out.println(llistaCompra[1]);

        do {
            menuInici();
            opcioMneuIni = scan.nextInt();
            scan.nextLine();
            switch (opcioMneuIni) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Escriu un numero que estigui entre el 0 i el 3, gracies!");
            }

        } while (opcioMneuIni != 0);

    }
    protected static void comprarProductes () {

        menuProducte();
    }
    public static void menuInici () {
        System.out.println("\nBENVINGUT AL SAPAMERCAT");
        System.out.println("------------");
        System.out.println("-- INICI ---");
        System.out.println("------------");
        System.out.println("1) Introduir producte");
        System.out.println("2) Passar per caixa");
        System.out.println("3) Mostrar carret de compra");
        System.out.println("0) Acabar");
    }
    public static void menuProducte () {
        System.out.println("---------------");
        System.out.println("-- PRODUCTE ---");
        System.out.println("---------------");
        System.out.println("1) Alimentació");
        System.out.println("2) Tèxtil");
        System.out.println("3) Electrònica");
        System.out.println("0) Tornar");
    }
}