package log121.lab4.app;

import log121.lab4.api.GestionnaireCommandes;
import log121.lab4.api.ICommande;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMenuItemCommande extends JMenuItem implements ICommande, ActionListener {

    private ICommande commande;

    public JMenuItemCommande(String resourceKey)
    {
        setText(ResourceManager.getResource(resourceKey));
    }

    public JMenuItemCommande(String resourceKey, ICommande commande)
    {
        this(resourceKey);
        this.commande = commande;
    }

    @Override
    public void executer() {
        commande.executer();
    }

    @Override
    public void annuler() {
        commande.annuler();
    }

    @Override
    public boolean annulable() {
        return commande.annulable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GestionnaireCommandes.getInstance().executer(this);
    }
}
