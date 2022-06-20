package classes.materiel;

import classes.Materiel;

public class Cyno extends Materiel {

    private static int nombreEmprunte = 0;
    private static int nombreTotal;

    public Cyno(String nom, String nomComplet, int nombreTotal) {
        super(nom, nomComplet);
        Cyno.nombreTotal = nombreTotal;
        Cyno.nombreEmprunte++;
    }

    @Override
    public int getNombreRestant() {
        return Cyno.nombreTotal - Cyno.nombreEmprunte;
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
