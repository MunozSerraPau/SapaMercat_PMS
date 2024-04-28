import Productes.*;

import java.io.*;
import java.time.*;
import java.util.*;


public class Main {
    public static Scanner scan = new Scanner(System.in);
    protected static ArrayList<Productes> llista = new ArrayList<>(100);
    protected static HashMap<String, String[]> llistaCompra = new HashMap<>();

    private static final int MAX_PRODUCT_CARRO = 100;
    private static final int MAX_NOM_LLARG = 15;

    //TOT BE

    public static void main(String[] args) {
        int opcioMenuIni;

        crearCarpetasFitxers();

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
                    break;
                default:
                    System.out.println("Escriu un numero que estigui entre el 0 i el 3, gràcies!");
            }

        } while (opcioMenuIni != 0);
        System.exit(1);
    }

    /**
     * Funció: Crear l'estructura de carpetas i fitxers
     */
    public static void crearCarpetasFitxers() {
        File c1 = new File("./updates");
        File c2 = new File("./logs");
        File f1 = new File("./updates/UpdateTextilPrices.dat");
        File f2 = new File("./logs/Exceptions.dat");

        try {
            if(c1.mkdirs() && c2.mkdirs())
                System.out.println("S'han creat les carpetas correctament.");
            else
                System.out.println("Les carpetas no s'han creat, perque ja existeixen.");
            if (f1.createNewFile() && f2.createNewFile())
                System.out.println("S'han creat els fitxers correctament.");
            else
                System.out.println("Les carpetas no s'han creat, perque ja existeixen.");

        } catch (Exception e) {
            System.out.println("Les carpetes o els fitxers no s'han creat correctametns");
        }

    }

    protected static void comprarProductes() {
        String nom,dataCadu,compoTextil,codi;
        int opcioMenuProd,diesGaran;
        float preu;


        do {
            menuProducte();
            opcioMenuProd = scan.nextInt();
            scan.nextLine();

            switch (opcioMenuProd) {
                case 1:

                    afegirAlimentCarro();


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
                    codi = scan.nextLine();

                    afegirTextilCarro(nom, preu, compoTextil, codi);
                    afegirProducte(nom, codi);

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
                    codi = scan.nextLine();

                    afegirElectronicaCarro(nom, preu, codi, diesGaran);
                    afegirProducte(nom, codi);

                    break;
                default:
                    System.out.println("Escriu un numero entre el 1 i el 3, gràcies!");
            }
        } while (opcioMenuProd != 0);
        ordenarLlista();
    }
  
    public static void ordenarLlista() {

    }

    public static void afegirAlimentCarro() {
        String nom;
        float preu;
        String dataCadu;
        String codi;

        try {
            if (llista.size() == MAX_PRODUCT_CARRO) {System.out.println("El carro esta ple, no pot superar els " + MAX_PRODUCT_CARRO + " productes.");
            } else {
                System.out.println("Afegir aliment");
                System.out.print("Nom producte: ");
                nom = scan.nextLine();
                if (nom.length() > MAX_NOM_LLARG)
                    throw new Exception("La llargada no pot ser superor a " + MAX_NOM_LLARG + ".");
                else if (nom.isEmpty())
                    throw new Exception("El nom producte no pot estar buit.");

                System.out.print("preu: ");
                preu = scan.nextFloat();
                scan.nextLine();
                if (preu <= 0)
                    throw new Exception("El preu no pot ser 0 o inferior.");

                System.out.print("Codi de barres (3 dígits): ");
                codi = scan.nextLine();
                if (!codi.matches("\\d{3}"))
                    throw new IllegalArgumentException("El codi ha de estar format per 3 digits.");

                System.out.print("Data de caducitat (dd/mm/aaaa): ");
                dataCadu = scan.nextLine();
                if (!dataCadu.matches("[0-3][0-9]/[0|1][0-9]/202[4-8]"))
                    throw new IllegalArgumentException("LA data de caducitat no esta ben formada.");


                afegirProducte(nom, codi);
                llista.add(new Alimentacio(nom, preu, codi, dataCadu));
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            afegirException(e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            afegirException(e);
        }
    }
    public static void afegirTextilCarro(String nom, float preu, String compoTextil, String codi) {


        llista.add(new Textil(nom, preu, codi, compoTextil));
    }
    public static void afegirElectronicaCarro(String nom, float preu, String codi, int diesGaran) {
        llista.add(new Electronica(nom, preu, codi, diesGaran));
    }



    /**
     * Funció: Afegeix a un HashMap el producte, comprovant si el codi del producte ja està registrat, pel cas que
     * estigui registrat se li sumarà al comptador 1, si no està guardat es guardarà i se li assignarà 1 en Unitats.
     * @param nom El nom del producte que volem "comprar".
     * @param codi El codi del producte.
     */
    protected static void afegirProducte(String nom, String codi) {
        String[] produc = new String[2];

        if (llistaCompra.containsKey(codi)){
            // En aquest cas assignem el nom del primer contacte, ja que si són noms diferents jo faig que es quedi el primer.
            String nomProc = llistaCompra.get(codi)[0];
            int num = Integer.parseInt(llistaCompra.get(codi)[1]) + 1;

            produc[0] = nomProc;
            produc[1] = "" + num;
            llistaCompra.replace(codi, produc);
        } else {
            produc[0] = nom;
            produc[1] = "1";
            llistaCompra.put(codi, produc);
        }
    }
    /**
     * Funció: En aquest cas imprimeix tota la llista del carro (en aquest cas està dins d'un HashMap i ho imprimim amb
     * ajuda de lambda expressions).
     */
    protected static void mostrarCarroDeCompra() {
        System.out.println("CARRET\n");
        llistaCompra.forEach((k, v) -> System.out.printf("%s --> %s\n", v[0], v[1]));
    }



    /**
     * Funció: En aquest cas imprimeix tot el carro per "pagar" i es mostra tant el nom, preu, unitats, preu total de
     * cada producte. A més de veure el total de la compra i buidar tot el carro.
     */
    protected static void passarPerCaixa() {
        float preuTotal = 0;

        LocalDate actual = LocalDate.now();
        System.out.println("------------------------------");
        System.out.println("SAPAMERCAT");
        System.out.println("------------------------------");
        System.out.println(actual);
        System.out.println("------------------------------");
        System.out.printf("%-10s %10s %15s %15s", "Nom:", "Unitats", "Preu Unitat", "Preu Total");   //%,11.2f
        for (int i = 0; i < llista.size(); i++) {
            preuTotal += i;
            System.out.printf("%-10s %10s %15s %15s", llista.get(i).getNomProducte(), llista.get(i).getNomProducte(), llista.get(i).getNomProducte(), llista.get(i).getNomProducte());
        }
        System.out.println("------------------------------");
        System.out.println("Total: " + preuTotal);

        llistaCompra.clear();
        llista.clear();
    }

    /**
     * Funció: per mostrar el menu del Inici
     */
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
    /**
     * Funció: per mostrar el menu a l'hora de afegir un producte
     */
    public static void menuProducte () {
        System.out.println("---------------");
        System.out.println("-- PRODUCTE ---");
        System.out.println("---------------");
        System.out.println("1) Alimentació");
        System.out.println("2) Tèxtil");
        System.out.println("3) Electrònica");
        System.out.println("0) Tornar");
    }

    public static void afegirException(Exception e) {
        try {
            File fitxer = new File("./logs/Exceptions.dat");
            if (fitxer.exists()) {
                PrintStream escriureArx = new PrintStream(new FileOutputStream(fitxer, true));

                escriureArx.println("Exception: " + e.getMessage() + " ( " + LocalTime.now() + " ).");
                escriureArx.close();
            } else {
                throw new FileNotFoundException();
            }

        } catch (FileNotFoundException exception) {
            System.out.println("No s'ha troba el fitxer.");
            afegirException(e);
        } catch (Exception exception){
            System.out.println("No s'ha pogut escriure en el fitxer");
            afegirException(e);
        }
    }
}