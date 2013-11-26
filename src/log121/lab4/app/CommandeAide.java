package log121.lab4.app;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;

public class CommandeAide extends CommandeAbstraite
{
    public CommandeAide() {
        super("app.frame.menus.help.about");
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
