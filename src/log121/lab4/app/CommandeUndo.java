package log121.lab4.app;


import log121.lab4.api.GestionnaireCommandes;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CommandeUndo extends CommandeAbstraite {


    public CommandeUndo() {
        super("app.frame.menus.edition.undo");
    }

    @Override
    public void executer() {
        GestionnaireCommandes.getInstance().annuler();
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
