package log121.lab4.app;


import log121.lab4.api.Gardien;
import log121.lab4.api.Modele;
import log121.lab4.api.Vue;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CommandeOuvrir extends CommandeAbstraite {

    private final Gardien gardien;
    private final ModeleImage modele;
    private final ArrayList<Vue> vues;
    private String chemin;

    public CommandeOuvrir(ModeleImage modele, ArrayList<Vue> vues) {
        this(modele, vues, null);
    }

    public CommandeOuvrir(ModeleImage modele, ArrayList<Vue> vues, String chemin) {
        super("app.frame.menus.file.load");
        this.gardien = new Gardien(modele);
        this.modele = modele;
        this.vues = vues;
        this.chemin = chemin;
    }

    @Override
    public void executer() {
        String formatImages = getSupportedImageFormats();
        String formatEtats = getSupportedStateFormats();

        try {
            if (chemin.matches(createRegex(formatImages)))
                loadImage();
            else if (chemin.matches(createRegex(formatEtats)))
                loadEtat();
            else
                JOptionPane.showMessageDialog(this, String.format("Le format de fichier est invalide. Formats valides : %s,%s",
                        formatImages, formatEtats));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage());
            ex.printStackTrace();
        }
    }

    private void loadImage() throws Exception {
        modele.setChemin(chemin);
        modele.setImage(ImageIO.read(new File(chemin)));
    }

    private void loadEtat() throws Exception {
        ModeleImage copie = (ModeleImage)Modele.deserialiser(chemin);
        modele.restaurerMemento(copie.creerMemento());
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
