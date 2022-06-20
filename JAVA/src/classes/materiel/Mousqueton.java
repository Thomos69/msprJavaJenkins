package classes.materiel;

import classes.Materiel;

public class Mousqueton extends Materiel {

    private static int nombreEmprunte = 0;
    private static int nombreTotal;

    public Mousqueton(String nom, String nomComplet, int nombreTotal) {
        super(nom, nomComplet);
        Mousqueton.nombreTotal = nombreTotal;
        Mousqueton.nombreEmprunte++;
    }

    @Override
    public int getNombreRestant() {
        return Mousqueton.nombreTotal - Mousqueton.nombreEmprunte;
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
