/******************************************************
 Cours:  LOG121
 Projet: Laboratoire 4
 Nom du fichier: CommandeAide.java
 Date créé: 2013-12-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Maxime Bédard
2013-12-03 Version initiale
 *******************************************************/

package log121.lab4.app;


import javax.swing.*;
import java.awt.event.KeyEvent;

public class CommandeAide extends Commande {
    /**
     * Constructeur de la commande qui affiche l'aide
     */
    public CommandeAide() {
        super("app.frame.menus.help.about", KeyEvent.VK_H);
    }

    @Override
    public void executer() {
        JOptionPane.showMessageDialog(null, ResourceManager.getResource("app.frame.dialog.about"));
    }

    @Override
    public boolean annulable() {
        return false;
    }
}
