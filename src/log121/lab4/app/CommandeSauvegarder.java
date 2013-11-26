package log121.lab4.app;

import log121.lab4.api.Modele;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class CommandeSauvegarder extends CommandeAbstraite {

    private final Modele modele;
    private String chemin;

    public CommandeSauvegarder(Modele modele)
    {
        this(modele, null);
    }

    public CommandeSauvegarder(Modele modele, String chemin) {
        super("app.frame.menus.file.save");
        this.modele = modele;
        this.chemin = chemin;
    }

    @Override
    public void executer() {
        try {
            Modele.serialiser(modele, chemin);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void promptChemin()
    {
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
        if(chemin == null)
            return;
        super.actionPerformed(e);
    }

    @Override
    public void annuler() {
        throw new NotImplementedException();
    }

    @Override
    public boolean annulable() {
        return false;
    }
}
