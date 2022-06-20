package classes.materiel;

import classes.Materiel;

public class Kit extends Materiel {

    private static int nombreEmprunte = 0;
    private static int nombreTotal;

    public Kit(String nom, String nomComplet, int nombreTotal) {
        super(nom, nomComplet);
        Kit.nombreTotal = nombreTotal;
        Kit.nombreEmprunte++;
    }

    @Override
    public int getNombreRestant() {
        return Kit.nombreTotal - Kit.nombreEmprunte;
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
