package Productes;

public class Electronica extends Productes {
    protected int diesGarantiaElectronica;

    public Electronica(String nomProducte, float preuProducte, String codiBarresProducte, int diesGarantiaElectronica) {
        super(nomProducte, preuProducte, codiBarresProducte);
        this.diesGarantiaElectronica = diesGarantiaElectronica;
        preu();
    }



    @Override
    public void preu() {
        // preu + preu*(diesGarantia/365)*0.1
        super.preuProducte = (float) (preuProducte + preuProducte*(diesGarantiaElectronica/365)*0.1);
    }


    @Override
    public String toString() {
        return "Nom Producte: " + nomProducte +
                "\nPreu: " + preuProducte +
                "\nGarantia (dies): " + diesGarantiaElectronica +
                "\nCodi de Barres: " + codiBarresProducte;
    }
}