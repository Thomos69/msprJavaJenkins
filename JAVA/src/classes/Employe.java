package classes;

import classes.Materiel;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Employe {

    private String prenom;
    private String nom;
    private String pseudo;
    private String fonction;
    private String motDePasse;
    private List<Materiel> materiels;

    public Employe(String prenom, String nom, String pseudo, String fonction, String motDePasse, List<Materiel> materiels) {
        this.prenom = prenom.substring(0, 1).toUpperCase() + prenom.toLowerCase().substring(1);
        this.nom = nom.toUpperCase();
        this.pseudo = pseudo;
        this.fonction = fonction;
        this.motDePasse = motDePasse;
        this.materiels = materiels;
    }



    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom.toUpperCase();
    }

    public String getFonction() {
        return fonction;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

//    public String getHashedMotDePasse() throws NoSuchAlgorithmException {
//
//        MessageDigest md = MessageDigest.getInstance("SHA-1");
//        byte[] messageDigest = md.digest(this.motDePasse.getBytes());
//
//
//        BigInteger no = new BigInteger(1, messageDigest);
//
//        String hashtext = no.toString(16);
//        while (hashtext.length() < 32) {
//            hashtext = "0" + hashtext;
//        }
//        return hashtext;
//    }

    public String getPseudo() {
        return pseudo;
    }

    public List<Materiel> getMateriels() {
        return materiels;
    }

    public String getNomComplet() {
        return String.format("%s %s", this.prenom, this.nom);
    }
}
