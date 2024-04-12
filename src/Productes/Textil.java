package Productes;

public class Textil extends Productes {
    protected String composicioTextil;

    public Textil(float preuProducte, String nomProducte, int codiBarresProducte, String composicioTextil) {
        super(preuProducte, nomProducte, codiBarresProducte);
        this.composicioTextil = composicioTextil;
    }
}
