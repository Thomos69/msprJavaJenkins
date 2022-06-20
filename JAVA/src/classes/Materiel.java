package classes;

public abstract class Materiel {
    private String nom;
    private String nomComplet;

    public Materiel(String nom, String nomComplet) {
        this.nom = nom;
        this.nomComplet = nomComplet;
    }

    public abstract int getNombreRestant();

    public abstract int getNombreEmprunte();

    public abstract int getNombreTotal();

    public String getNom() {
        return nom;
    }

    public String getNomComplet() {
        return nomComplet;
    }

}

