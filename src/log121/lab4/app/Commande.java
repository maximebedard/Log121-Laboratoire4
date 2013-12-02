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
