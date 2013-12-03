/******************************************************
 Cours:  LOG121
 Projet: Laboratoire 4
 Nom du fichier: Commande.java
 Date créé: 2013-12-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Maxime Bédard
2013-12-03 Version initiale
 *******************************************************/

package log121.lab4.app;

import log121.lab4.api.ICommande;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Commande extends JMenuItem implements ICommande, ActionListener {

    Commande(String resourceKey, int keyCode) {
        setText(ResourceManager.getResource(resourceKey));
        setAccelerator(KeyStroke.getKeyStroke(keyCode, ActionEvent.CTRL_MASK));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GestionnaireCommandes.getInstance().executer(this);
    }
}
