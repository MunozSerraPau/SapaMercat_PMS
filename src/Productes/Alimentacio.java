package Productes;

import java.time.*;
import java.time.temporal.ChronoUnit;


public class Alimentacio extends Productes {
    protected String dataCaducitatAlimentacio;
    protected long diesCaducitat;
    protected int dia;
    protected int mes;
    protected int any;

    public Alimentacio(String nomProducte, float preuProducte, int codiBarresProducte, String dataCaducitatAlimentacio) {
        super(nomProducte, preuProducte, codiBarresProducte);
        this.dataCaducitatAlimentacio = dataCaducitatAlimentacio;
        preu();
    }


    @Override
    public void preu() {
        comprovarDies(dataCaducitatAlimentacio);
        diesCaducitat = calcularDiferenciaDies(dia, mes, any);

        //preu - preu*(1/(dataCaducitat-dataActual+1)) + (preu * 0.1)
        super.preuProducte = (float) Math.abs(preuProducte - preuProducte*(1/(diesCaducitat+1)) - (preuProducte * 0.1));
    }

    private void comprovarDies(String dataCompleta) {
        if(!dataCompleta.matches("[0-3][0-9]/[0|1][0-9]/202[4-6]"))
            throw new Error ("Error amb la data");

        String[] dataArray = dataCompleta.split("/");
        assignarDiaMesAny(Integer.parseInt(dataArray[0]), Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]));
    }
    private void assignarDiaMesAny(int dia, int mes, int any) {
        if (!verificarDataDiaMesAny(dia, mes, any)) {
            throw new Error("El dia, mes o any no són correctes!");
        }
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }
    private boolean verificarDataDiaMesAny (int dia, int mes, int any) {
        //TODO: verificar dies segons el mes i l'any
        if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || any < 2024) {
            return false;
        } else {
            return true;
        }
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

    @Override
    public String toString() {
        return "Nom Producte= " + nomProducte +
                ", Preu= " + preuProducte +
                ", Data Caducitat= " + dataCaducitatAlimentacio +
                ", CodiBarres= " + codiBarresProducte;
    }

}
