/******************************************************
 Cours:  LOG121
 Projet: Laboratoire 4
 Nom du fichier: CommandeSauvegarder.java
 Date créé: 2013-12-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Maxime Bédard
2013-12-03 Version initiale
 *******************************************************/

package log121.lab4.app;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CommandeSauvegarder extends Commande {

    private final ModeleImage modeleImage;
    private final ModelePerspective modelePerspective;
    private String chemin;

    /**
     * Constructeur de la commande sauvegarder
     * @param modeleImage modele qui contient les informations sur l'image
     * @param modelePerspective modele qui contient les informations sur la perspective
     */
    public CommandeSauvegarder(ModeleImage modeleImage, ModelePerspective modelePerspective) {
        super("app.frame.menus.file.save", KeyEvent.VK_S);
        this.modeleImage = modeleImage;
        this.modelePerspective = modelePerspective;
        this.chemin = null;
    }

    @Override
    public void executer() {
        try {
            FileOutputStream fileOut = new FileOutputStream(chemin);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(modeleImage);
            out.writeObject(modelePerspective);

            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Affiche un file chooser pour choisir la destination
     */
    public void promptChemin() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileFilter filter = new FileNameExtensionFilter("Laboratoire 4", "lab4");
        fileChooser.setFileFilter(filter);

        int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            chemin = fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            chemin = null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        promptChemin();
        if (chemin == null)
            return;
        super.actionPerformed(e);
    }

    @Override
    public boolean annulable() {
        return false;
    }
}
