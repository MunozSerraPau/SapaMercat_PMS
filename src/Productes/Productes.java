package Productes;

public abstract class Productes {
    protected float preuProducte;
    protected String nomProducte;
    protected String codiBarresProducte;

    public Productes(String nomProducte, float preuProducte, String codiBarresProducte) {
        this.nomProducte = nomProducte;
        this.preuProducte = preuProducte;
        this.codiBarresProducte = codiBarresProducte;
    }


    public float getPreuProducte() {
        return preuProducte;
    }
    public String getNomProducte() {
        return nomProducte;
    }
    public String getCodiBarresProducte() {
        return codiBarresProducte;
    }


    // Mètode sobreescrit en algunes subclasses (polimorfisme) pel Preu, ja que es calcula diferent en cada producte.
    public abstract void preu();
    public abstract void codiBarres();

}
