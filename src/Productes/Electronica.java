package Productes;

public class Electronica extends Productes {
    protected int diesGarantiaElectronica;

    public Electronica(float preuProducte, String nomProducte, int codiBarresProducte, int diesGarantiaElectronica) {
        super(preuProducte, nomProducte, codiBarresProducte);
        this.diesGarantiaElectronica = diesGarantiaElectronica;
    }
}