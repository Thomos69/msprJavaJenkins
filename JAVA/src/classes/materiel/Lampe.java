package classes.materiel;

import classes.Materiel;

public class Lampe extends Materiel {

    private static int nombreEmprunte = 0;
    private static int nombreTotal;


    public Lampe(String nom, String nomComplet, int nombreTotal) {
        super(nom, nomComplet);
        Lampe.nombreTotal = nombreTotal;
        Lampe.nombreEmprunte++;
    }

    @Override
    public int getNombreRestant() {
        return Lampe.nombreTotal - Lampe.nombreEmprunte;
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
