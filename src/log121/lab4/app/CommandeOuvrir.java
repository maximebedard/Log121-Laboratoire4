package log121.lab4.app;


import log121.lab4.api.Gardien;
import log121.lab4.api.Modele;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class CommandeOuvrir extends CommandeAbstraite {

    private final Gardien gardien;
    private final ModeleImage modeleImage;
    private final ModelePerspective modelePerspective;
    private String chemin;

    public CommandeOuvrir(ModeleImage modeleImage, ModelePerspective modelePerspective) {
        this(modeleImage, modelePerspective, null);
    }

    public CommandeOuvrir(ModeleImage modeleImage, ModelePerspective modelePerspective, String chemin) {
        super("app.frame.menus.file.load");
        this.modelePerspective = modelePerspective;
        this.gardien = new Gardien(modeleImage);
        this.modeleImage = modeleImage;
        this.chemin = chemin;
    }

    @Override
    public void executer() {
        String formatImages = getSupportedImageFormats();
        String formatEtats = getSupportedStateFormats();

        try {

            if (chemin.matches(createRegex(formatImages)))
            {
                loadImage();
                gardien.sauvegarder();
                return;
            }

            if (chemin.matches(createRegex(formatEtats)))
            {
                loadEtat();
                gardien.sauvegarder();
                return;
            }

            JOptionPane.showMessageDialog(this, String.format("Le format de fichier est invalide. Formats valides : %s,%s",
                formatImages, formatEtats));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage());
            ex.printStackTrace();
        }
    }

    private void loadImage() throws Exception {
        modeleImage.setChemin(chemin);
        modeleImage.setImage(ImageIO.read(new File(chemin)));
    }

    private void loadEtat() throws Exception {

        FileInputStream fis = new FileInputStream(chemin);

        ObjectInputStream ois = new ObjectInputStream(fis);

        ModeleImage copieImage = (ModeleImage)ois.readObject();
        ModelePerspective copiePerspective = (ModelePerspective)ois.readObject();

        ois.close();
        fis.close();

        modeleImage.restaurerMemento(copieImage.creerMemento());
        modelePerspective.restaurerMemento(copiePerspective.creerMemento());

    }

    private static String getSupportedImageFormats() {
        String regex = "";
        for (String f : ImageIO.getReaderFormatNames())
            regex += f + ",";

        return regex.substring(0, regex.length() - 1);
    }

    private static String getSupportedStateFormats() {
        return "lab4";
    }

    private String createRegex(String formats) {
        return ".*\\.(" + formats.replace(',', '|') + ")$";
    }

    @Override
    public void annuler() {
        if(gardien.possedeAnnuler())
            gardien.annuler();
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
