package classes;

import java.io.File;
import java.io.IOException;

import com.company.Main;
import org.apache.commons.io.FileUtils;

public class HTML {
    //
//    private static File indexTemplateFile = new File(Main.getAbosulutePath("HTMLTemplates", "template_index.html"));
//    private static File ficheTemplateFile = new File(Main.getAbosulutePath("HTMLTemplates", "template_fiche.html"));
//    private static String HTMLOutPath = Main.getAbosulutePath("HTMLOut", "");

//    private static File indexTemplateFile = new File("C:\\Users\\Thoma\\IdeaProjects\\MSPRR\\files\\HTMLTemplates\\template_index.html");
//    //    private static File indexTemplateFile = new File("C:\\Users\\Thoma\\IdeaProjects\\MSPRR\\files\\HTMLTemplates\\template_index.html");
//    private static File ficheTemplateFile = new File("C:\\Users\\Thoma\\IdeaProjects\\MSPRR\\files\\HTMLTemplates\\template_fiche.html");
//    private static String HTMLOutPath = "C:\\Users\\Thoma\\IdeaProjects\\MSPRR\\files\\HTMLOut\\";

    private static File indexTemplateFile = new File("/home/ubuntu-2004/GOSecuri/JAVA/files/HTMLTemplates/template_index.html");
    private static File ficheTemplateFile = new File("/home/ubuntu-2004/GOSecuri/JAVA/files/HTMLTemplates/template_fiche.html");
    private static String HTMLOutPath = "/var/www/html/";

    public static void GenerateHtpasswd() throws IOException {

        StringBuilder content = new StringBuilder();
        String htaccessContent = "AuthName \"Accès restreints - Veuillez vous authentifier\"\n" +
                "AuthType Basic\n" +
                "AuthUserFile " + HTMLOutPath + ".htpasswd\n" +
                "require valid-user";

        for (Employe employe : Main.getListeEmploye()) {
            content.append(String.format("%s:%s\n", employe.getPseudo(), employe.getHashedMotDePasse()));
        }

        writeHTMLFile(".htpasswd", content.toString());
        writeHTMLFile(".htaccess", htaccessContent);
    }

    public static void GenerateIndex() throws IOException {
        String htmlContent = FileUtils.readFileToString(HTML.indexTemplateFile, "UTF8");
        StringBuilder listeEmployeHtml = new StringBuilder();

        for (Employe employe : Main.getListeEmploye()) {
            listeEmployeHtml.append(String.format("<li><img class=\"preview\"src=\"img/%s.png\"><a href=\"%s.html\">%s</a></li>", employe.getPseudo(), employe.getPseudo(), employe.getNomComplet()));
        }

        htmlContent = htmlContent.replace("$liste_employes$", listeEmployeHtml.toString());

        HTML.writeHTMLFile("index.html", htmlContent);
    }


    public static void GenerateFiches() throws IOException {

        for (Employe employe : Main.getListeEmploye()) {
            String htmlContent = FileUtils.readFileToString(HTML.ficheTemplateFile, "UTF8");
            StringBuilder listeMaterielHtml = new StringBuilder();

            htmlContent = htmlContent.replace("$nom_complet$", employe.getNomComplet());
            htmlContent = htmlContent.replace("$prenom$", employe.getPrenom());
            htmlContent = htmlContent.replace("$nom$", employe.getNom());
            htmlContent = htmlContent.replace("$fonction$", employe.getFonction());
            htmlContent = htmlContent.replace("$image$", employe.getPseudo());

            for (Materiel materiel : employe.getMateriels()) {
                listeMaterielHtml.append(String.format("<li>%s <img class=\"chehckbox\" src=\"img/checkbox.png\" alt=\"carteidentite\" height=\"30px\"></li>", materiel.getNomComplet()));
            }
            htmlContent = htmlContent.replace("$liste_materiel$", listeMaterielHtml);
            String fileName = employe.getPseudo() + ".html";
            writeHTMLFile(fileName, htmlContent);
        }
    }

    private static void writeHTMLFile(String fileName, String content) throws IOException {
        File newHtmlFile = new File(HTML.HTMLOutPath + fileName);
        FileUtils.writeStringToFile(newHtmlFile, content, "UTF-8");
    }

    public static void GenerateAllFiles() throws IOException {
        HTML.GenerateHtpasswd();
        HTML.GenerateIndex();
        HTML.GenerateFiches();
    }
}
