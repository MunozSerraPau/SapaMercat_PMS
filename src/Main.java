import Productes.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    protected static ArrayList<Productes> llista = new ArrayList<>(100);
    protected static HashMap<Integer, Productes> llistaCompra = new HashMap<Integer, Productes>();
    static int contadorA = 0, contadorT = 0, contadorE = 0;


    public static void main(String[] args) {
        int opcioMenuIni;

        /*
        Productes[] llistaCompra = new Productes[100];
        llistaCompra[0] = new Alimentacio("Poma", 1F, 1234, "22/06/2024");
        llistaCompra[1] = new Alimentacio("Tomaquet", 7.45F, 2345, "27/07/2024");
        llistaCompra[2] = new Textil("Samarreta", 22F, 3456, "cotó");
        llistaCompra[3] = new Textil("Pantalo", 35.7F, 4567, "Plastic");
        llistaCompra[4] = new Electronica("TV", 333F, 5678, 5434);
        llistaCompra[5] = new Electronica("PC", 56.7F, 6789, 57);

        System.out.println(llistaCompra[0]);
        System.out.println(llistaCompra[1]);
        System.out.println(llistaCompra[2]);
        System.out.println(llistaCompra[3]);
        System.out.println(llistaCompra[4]);
        System.out.println(llistaCompra[5]);
         */

        do {
            menuInici();
            opcioMenuIni = scan.nextInt();
            scan.nextLine();
            switch (opcioMenuIni) {
                case 1:
                    comprarProductes();
                    break;
                case 2:
                    passarPerCaixa();
                    break;
                case 3:
                    mostrarCarroDeCompra();
                    break;
                case 0:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Escriu un numero que estigui entre el 0 i el 3, gràcies!");
            }

        } while (opcioMenuIni != 0);
    }

    protected static void comprarProductes() {
        String nom,dataCadu,compoTextil;
        int opcioMenuProd,codi,diesGaran;
        float preu;


        do {
            menuProducte();
            opcioMenuProd = scan.nextInt();
            scan.nextLine();

            switch (opcioMenuProd) {
                case 1:
                    System.out.println("Afegir aliment");
                    System.out.print("Nom producte: ");
                    nom = scan.nextLine();
                    System.out.print("preu: ");
                    preu = scan.nextFloat();
                    scan.nextLine();
                    System.out.print("Codi de barres: ");
                    codi = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Data de caducitat (dd/mm/aaaa): ");
                    dataCadu = scan.nextLine();


                    llistaCompra.put(codi, new Alimentacio(nom, preu, codi, dataCadu));

                    break;
                case 2:
                    System.out.println("Afegir tèxtil");
                    System.out.print("Nom producte: ");
                    nom = scan.nextLine();
                    System.out.print("preu: ");
                    preu = scan.nextFloat();
                    scan.nextLine();
                    System.out.print("Composició: ");
                    compoTextil = scan.nextLine();
                    System.out.print("Codi de barres: ");
                    codi = scan.nextInt();
                    scan.nextLine();


                    break;
                case 3:
                    System.out.println("Afegir electrònica");
                    System.out.print("Nom producte: ");
                    nom = scan.nextLine();
                    System.out.print("preu: ");
                    preu = scan.nextFloat();
                    scan.nextLine();
                    System.out.print("Garantia (dies): ");
                    diesGaran = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Codi de barres: ");
                    codi = scan.nextInt();
                    scan.nextLine();


                    break;
                default:
                    System.out.println("Escriu un numero entre el 1 i el 3, gràcies!");
            }
        } while (opcioMenuProd != 0);
    }
    protected static void passarPerCaixa() {
        float preuTotal = 0;




        LocalDate actual = LocalDate.now();
        System.out.println("------------------------------");
        System.out.println("SAPAMERCAT");
        System.out.println("------------------------------");
        System.out.println(actual);
        System.out.println("------------------------------");
        System.out.printf("%-10s %7s %11s %10s", "Nom:", "Unitats", "Preu Unitat", "Preu Total");   //%,11.2f
        for (int i = 1; i < 5; i++) {
            preuTotal += i;
            System.out.println("hola: " + llistaCompra.get(i));
            System.out.println(i);
        }
        System.out.println("------------------------------");
        System.out.println("Total: " + preuTotal);
    }
    protected static void mostrarCarroDeCompra() {
        System.out.println("CARRET");

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