package Productes;

public class Data {
    private int dia;
    private int mes;
    private int any;

    public Data(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }
    public Data(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    public Data(String dataCompleta) {
        if(!dataCompleta.matches("[0-9][0-9]-[0-9][0-9]-[0-9]{4}"))
            throw new Error ("Format Data Incorecte");
        String[] dataArray = dataCompleta.split("-");
        assignarDiaMesAny(Integer.parseInt(dataArray[0]), Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]));
    }

    public int getDia(String DataCompl) {
        return dia;
    }
    public int getMes(String DataCompl) {
        return mes;
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
        if (dia < 1 || dia > 31 || mes < 1 || mes > 31 || any < 1900 || any > 2023) {
            return false;
        } else {
            return true;
        }
    }
}
