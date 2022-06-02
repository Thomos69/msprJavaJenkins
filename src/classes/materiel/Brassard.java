package classes.materiel;

import classes.Materiel;

public class Brassard extends Materiel {

    private static int nombreEmprunte = 0;
    private static int nombreTotal;

    public Brassard(String nom, String nomComplet, int nombreTotal) {
        super(nom, nomComplet);
        Brassard.nombreTotal = nombreTotal;
        Brassard.nombreEmprunte++;
    }

    @Override
    public int getNombreRestant() {
        return Brassard.nombreTotal - Brassard.nombreEmprunte;
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
