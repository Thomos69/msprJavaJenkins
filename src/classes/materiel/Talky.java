package classes.materiel;

import classes.Materiel;

public class Talky extends Materiel {

    private static int nombreEmprunte = 0;
    private static int nombreTotal;

    public Talky(String nom, String nomComplet, int nombreTotal) {
        super(nom, nomComplet);
        Talky.nombreTotal = nombreTotal;
        Talky.nombreEmprunte++;
    }

    @Override
    public int getNombreRestant() {
        return Talky.nombreTotal - Talky.nombreEmprunte;
    }

    @Override
    public int getNombreEmprunte() {
        return nombreEmprunte;
    }

    @Override
    public int getNombreTotal() {
        return nombreTotal;
    }
}
