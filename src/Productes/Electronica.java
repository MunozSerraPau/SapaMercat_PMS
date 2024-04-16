package Productes;

public class Electronica extends Productes {
    protected int diesGarantiaElectronica;

    public Electronica(String nomProducte, float preuProducte, int codiBarresProducte, int diesGarantiaElectronica) {
        super(nomProducte, preuProducte, codiBarresProducte);
        this.diesGarantiaElectronica = diesGarantiaElectronica;
    }
}