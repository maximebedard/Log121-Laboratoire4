/******************************************************
 Cours:  LOG121
 Projet: Laboratoire 4
 Nom du fichier: CommandeOuvrir.java
 Date créé: 2013-12-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Maxime Bédard
2013-12-03 Version initiale
 *******************************************************/

package log121.lab4.app;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class CommandeOuvrir extends Commande {

    private final ModeleImage modeleImage;
    private final ModelePerspective modelePerspective;
    private String chemin;

    /**
     * Constructeur de la commande ouvrir à partir d'un chemin existant
     * @param modeleImage modele qui contient les informations sur l'image
     * @param modelePerspective modele qui contient les informations sur la perspective
     */
    public CommandeOuvrir(ModeleImage modeleImage, ModelePerspective modelePerspective) {
        super("app.frame.menus.file.load", KeyEvent.VK_O);
        this.modelePerspective = modelePerspective;

        this.modeleImage = modeleImage;
        this.chemin = null;
    }

    @Override
    public void executer() {
        String formatImages = getSupportedImageFormats();
        String formatEtats = getSupportedStateFormats();

        try {

            if (chemin.matches(createRegex(formatImages))) {
                loadImage();
                return;
            }

            if (chemin.matches(createRegex(formatEtats))) {
                loadEtat();
                return;
            }

            JOptionPane.showMessageDialog(this, String.format("Le format de fichier est invalide. Formats valides : %s,%s",
                    formatImages, formatEtats));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Restore les paramètres par defauts des modèles et assigne le nouveau chemin au modele image
     * @throws Exception
     */
    private void loadImage() throws Exception {
        modeleImage.initDefaults();
        modelePerspective.initDefaults();

        modeleImage.setChemin(chemin);
    }

    /**
     * Restore l'application à partir d'un état sauvegardé précedemment
     * @throws Exception
     */
    private void loadEtat() throws Exception {

        FileInputStream fis = new FileInputStream(chemin);

        ObjectInputStream ois = new ObjectInputStream(fis);

        ModeleImage copieImage = (ModeleImage) ois.readObject();
        ModelePerspective copiePerspective = (ModelePerspective) ois.readObject();

        ois.close();
        fis.close();

        modeleImage.restaurerMemento(copieImage.creerMemento());
        modelePerspective.restaurerMemento(copiePerspective.creerMemento());

    }

    /**
     * Retourne tous les formats de fichiers d'images supportés
     * @return formats d'images supportés
     */
    private static String getSupportedImageFormats() {
        String regex = "";
        for (String f : ImageIO.getReaderFormatNames())
            regex += f + ",";

        return regex.substring(0, regex.length() - 1);
    }

    /**
     * Retourne tous les formats de fichiers d'états
     * @return formats d'états supportés
     */
    private static String getSupportedStateFormats() {
        return "lab4";
    }

    /**
     * Retourne l'exression régulière qui match les extensions
     * @param formats formats d'images
     * @return l'expression régulière
     */
    private String createRegex(String formats) {
        return ".*\\.(" + formats.replace(',', '|') + ")$";
    }

    @Override
    public boolean annulable() {
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        promptChemin();
        if (chemin == null)
            return;

        super.actionPerformed(e);
    }

    /**
     * Affiche le file chooser pour selectionner un fichier
     */
    private void promptChemin() {
        JFileChooser fileChooser = new JFileChooser();

        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            chemin = fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            chemin = null;
        }
    }
}
