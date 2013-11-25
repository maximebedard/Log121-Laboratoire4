package log121.lab4.app;

import log121.lab4.api.GestionnaireCommandes;
import log121.lab4.api.ICommande;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class CommandeAbstraite extends JMenuItem implements ICommande, ActionListener {

    CommandeAbstraite(String resourceKey)
    {
        setText(ResourceManager.getResource(resourceKey));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GestionnaireCommandes.getInstance().executer(this);
    }
}
