package classes.materiel;

import classes.Materiel;

public class Lacrymo extends Materiel {

    private static int nombreEmprunte = 0;
    private static int nombreTotal;

    public Lacrymo(String nom, String nomComplet, int nombreTotal) {
        super(nom, nomComplet);
        Lacrymo.nombreTotal = nombreTotal;
        Lacrymo.nombreEmprunte++;
    }

    @Override
    public int getNombreRestant() {
        return Lacrymo.nombreTotal - Lacrymo.nombreEmprunte;
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
