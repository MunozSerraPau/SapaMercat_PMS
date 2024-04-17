package Productes;

public abstract class Productes {
    protected float preuProducte;
    protected String nomProducte;
    protected int codiBarresProducte;

    public Productes(String nomProducte, float preuProducte, int codiBarresProducte) {
        this.nomProducte = nomProducte;
        this.preuProducte = preuProducte;
        this.codiBarresProducte = codiBarresProducte;
    }

    // Mètode sobreescrit en algunes subclasses (polimorfisme) pel Preu, ja que es calcula diferent en cada producte.
    public abstract void preu();

}
