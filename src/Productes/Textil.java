package Productes;

public class Textil extends Productes {
    protected String composicioTextil;

    public Textil(String nomProducte, float preuProducte, int codiBarresProducte, String composicioTextil) {
        super(nomProducte, preuProducte, codiBarresProducte);
        this.composicioTextil = composicioTextil;
    }

    @Override
    public void preu() {

    }

    @Override
    public String toString() {
        return "Nom Producte= " + nomProducte +
                ", Preu= " + preuProducte +
                ", Composició= " + composicioTextil +
                ", CodiBarres= " + codiBarresProducte;
    }
}
