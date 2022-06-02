package classes.materiel;

import classes.Materiel;

public class Taser extends Materiel {

    private static int nombreEmprunte = 0;
    private static int nombreTotal;

    public Taser(String nom, String nomComplet, int nombreTotal) {
        super(nom, nomComplet);
        Taser.nombreTotal = nombreTotal;
        Taser.nombreEmprunte++;
    }

    @Override
    public int getNombreRestant() {
        return Taser.nombreTotal - Taser.nombreEmprunte;
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
