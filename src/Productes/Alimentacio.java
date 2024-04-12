package Productes;

import java.time.LocalDate;

public class Alimentacio extends Productes {
    protected String dataCaducitatAlimentacio;

    public Alimentacio(float preuProducte, String nomProducte, int codiBarresProducte, String dataCaducitatAlimentacio) {
        super(preuProducte, nomProducte, codiBarresProducte);
        this.dataCaducitatAlimentacio = dataCaducitatAlimentacio;
    }

    @Override
    public String toString() {
        return "Nom Producte= " + nomProducte +
                ", Preu= " + preuProducte +
                ", Data Caducitat= " + dataCaducitatAlimentacio +
                ", CodiBarres= " + codiBarresProducte + "\n";
    }

    /*
    public String getDataCaducitatAlimentacio() {
        int diesDiferencia;

        String edat;
        String dataActual;

        dataActual = LocalDate.now().toString().substring(0, 4);

        anyNaix = dataCaducitatAlimentacio.substring(6);

        int edat1 = Integer.parseInt(dataActual) - Integer.parseInt(anyNaix);

        return edat;
    }
    */
}
