package com.company;

import classes.Employe;
import classes.HTML;
import classes.Materiel;
import classes.materiel.*;


import java.io.*;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Main {

    private static List<Employe> listeEmploye = new ArrayList<Employe>();

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        getAllEmploye();
        HTML.GenerateAllFiles();
    }

    private static void getAllEmploye() throws IOException {
        String listeEmploye = readFile("staff"); //Lit le fichier staff
        String[] lignes = listeEmploye.split("\n\r"); //Sépare les lignes

        for (String ligne : lignes) {
            String employeInfos = readFile(ligne); //Pour chaque ligne on va chercher le fichier correspondant "nom".txt
            String[] infos = employeInfos.split("\n\r", 5); //On sépare les lignes
            String nom = infos[0].toUpperCase();
            String prenom = infos[1];
            String pseudo = ligne;
            String fonction = infos[2];
            String mdp = infos[3];
            String[] materielEmprunte = (infos[4].trim()).split("\n\r");
            List<Materiel> listeMaterielEmploye = new ArrayList<Materiel>();

            for (String materiel : materielEmprunte) { //Pour chaque materiel que possède un employe on va l'ajouter à sa liste de materiel
                listeMaterielEmploye.add(getMaterielByName(materiel)); // Permet d'ajouter le materiel a la liste en retrouvant l'objet correspondant grace a la fonction
            }

            Main.listeEmploye.add(new Employe(prenom, nom, pseudo, fonction, mdp, listeMaterielEmploye));
        }

    }

    private static Materiel getMaterielByName(String name) throws IOException {
        String materielInfos = readFile("liste"); //Recupère la liste de tout le materiel disponible
        String[] lignes = materielInfos.split("\n\r");// Sépare les lignes

        for (String ligne : lignes) {//On va verifier chaque materiel dans la liste pour trouvé le materiel recherché
            String[] nomsMateriel = ligne.split(" ", 2); //On sépare pour chaque ligne le nom court et le nom complet
            String nomCourt = nomsMateriel[0];
            String nomComplet = nomsMateriel[1];
            int nombreTotalMateriel = Integer.parseInt(readFile(nomCourt).trim());
            Materiel returnMateriel;

            if (nomCourt.equals(name)) { //Si le nom de l'objet correspond a l'objet recherché
                switch (nomCourt) {//On verifie quel type d'objet est voulu afin de lui attribuer la bonne classe
                    case "mousqueton":
                        returnMateriel = new Mousqueton(nomCourt, nomComplet, nombreTotalMateriel);
                        break;
                    case "gants":
                        returnMateriel = new Gants(nomCourt, nomComplet, nombreTotalMateriel);
                        break;
                    case "brassard":
                        returnMateriel = new Brassard(nomCourt, nomComplet, nombreTotalMateriel);
                        break;
                    case "menottes":
                        returnMateriel = new Menottes(nomCourt, nomComplet, nombreTotalMateriel);
                        break;
                    case "cyno":
                        returnMateriel = new Cyno(nomCourt, nomComplet, nombreTotalMateriel);
                        break;
                    case "talky":
                        returnMateriel = new Talky(nomCourt, nomComplet, nombreTotalMateriel);
                        break;
                    case "lampe":
                        returnMateriel = new Lampe(nomCourt, nomComplet, nombreTotalMateriel);
                        break;
                    case "kit":
                        returnMateriel = new Kit(nomCourt, nomComplet, nombreTotalMateriel);
                        break;
                    case "taser":
                        returnMateriel = new Taser(nomCourt, nomComplet, nombreTotalMateriel);
                        break;
                    case "lacrymo":
                        returnMateriel = new Lacrymo(nomCourt, nomComplet, nombreTotalMateriel);
                        break;
                    default:
                        returnMateriel = null;
                        break;
                }
                return returnMateriel;
            }
        }
        return null;
    }

    public static List<Employe> getListeEmploye() {
        return Main.listeEmploye;
    }


//=============================================== FONCTIONS UTILES =======================================

    public static String readFile(String fileName) throws IOException {

//        File currentDirFile = new File("");
//        String currentDirPath = currentDirFile.getAbsolutePath();
//        String filesLocation = currentDirPath + "\\files\\GOsecuri\\";

//        String filesLocation = "C:\\Users\\Thoma\\IdeaProjects\\MSPRR\\files\\GOsecuri\\";
//        String filesLocation = "/home/ubuntu-2004/GOsecuri/files/";
        String filesLocation = "/home/ubuntu-2004/GOSecuri/STATIC_FILES/";


        fileName = filesLocation + fileName + ".txt";

        Scanner scan = new Scanner(new File(fileName));
        String content = "";
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            content += line + "\n\r";
        }

        return content;
    }

    public static String getAbosulutePath(String folderName, String fileName) {
        File currentDirFile = new File("");
        String currentDirPath = currentDirFile.getAbsolutePath();
        return String.format("%s\\files\\%s\\%s", currentDirPath, folderName, fileName); //Filelocation
    }

    public static void print(String msg) {
        System.out.println(msg);
    }

}
