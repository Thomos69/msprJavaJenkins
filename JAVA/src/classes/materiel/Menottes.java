package classes.materiel;

import classes.Materiel;

public class Menottes extends Materiel {

    private static int nombreEmprunte = 0;
    private static int nombreTotal;

    public Menottes(String nom, String nomComplet, int nombreTotal) {
        super(nom, nomComplet);
        Menottes.nombreTotal = nombreTotal;
        Menottes.nombreEmprunte++;
    }

    @Override
    public int getNombreRestant() {
        return Menottes.nombreTotal - Menottes.nombreEmprunte;
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
