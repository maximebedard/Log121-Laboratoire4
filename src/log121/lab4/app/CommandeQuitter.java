/******************************************************
 Cours:  LOG121
 Projet: Laboratoire 4
 Nom du fichier: CommandeQuitter.java
 Date créé: 2013-12-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Maxime Bédard
2013-12-03 Version initiale
 *******************************************************/

package log121.lab4.app;


import java.awt.event.KeyEvent;

public class CommandeQuitter extends Commande {

    /**
     * Constructeur de la commande quitter
     */
    public CommandeQuitter() {
        super("app.frame.menus.file.exit", KeyEvent.VK_Q);
    }

    @Override
    public void executer() {
        System.exit(0);
    }

    @Override
    public boolean annulable() {
        return false;
    }
}
