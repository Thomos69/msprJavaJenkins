package classes.materiel;

import classes.Materiel;

public class Gants extends Materiel {

    private static int nombreEmprunte = 0;
    private static int nombreTotal;

    public Gants(String nom, String nomComplet, int nombreTotal) {
        super(nom, nomComplet);
        Gants.nombreTotal = nombreTotal;
        Gants.nombreEmprunte++;
    }

    @Override
    public int getNombreRestant() {
        return Gants.nombreTotal - Gants.nombreEmprunte;
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
