package Productes;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;


public class Alimentacio extends Productes {
    protected String dataCaducitatAlimentacio;
    protected int diesCaducitat;

    public Alimentacio(String nomProducte, float preuProducte, int codiBarresProducte, String dataCaducitatAlimentacio) {
        super(nomProducte, preuProducte, codiBarresProducte);
        this.dataCaducitatAlimentacio = dataCaducitatAlimentacio;
    }


    @Override
    public String toString() {
        return "Nom Producte= " + nomProducte +
                ", Preu= " + preuProducte +
                ", Data Caducitat= " + dataCaducitatAlimentacio +
                ", CodiBarres= " + codiBarresProducte + "\n";
    }

    private static long calcularDiferenciaDies (int dia, int mes, int any) {
        LocalDate fecha1 = LocalDate.now();
        LocalDate fecha2 = LocalDate.of(any, mes, dia);

        return ChronoUnit.DAYS.between(fecha1, fecha2);

        /*  ######## OPCIÓ 2 ########
        int diesDif = 0;

        LocalDate fecha1 = LocalDate.of(any, mes, dia);
        LocalDate fecha2 = LocalDate.now();

        Period diferenciaDeDies = Period.between(fecha2, fecha1);
        if (diferenciaDeDies.getYears() >= 1) {
            for (int i = 0; i < diferenciaDeDies.getYears(); i++){
                diesDif += 365;
            }
        }
        diesDif += diferenciaDeDies.getDays() + (diferenciaDeDies.getMonths() * 30);

        return diesDif;
         */

    }

}
