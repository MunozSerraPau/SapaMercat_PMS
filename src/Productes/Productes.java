package Productes;

public class Productes{
    protected float preuProducte;
    protected String nomProducte;
    protected int codiBarresProducte;

    public Productes(String nomProducte, float preuProducte, int codiBarresProducte) {
        this.nomProducte = nomProducte;
        this.preuProducte = preuProducte;
        this.codiBarresProducte = codiBarresProducte;
    }
}
