package log121.lab4.app;


import log121.lab4.api.GestionnaireCommandes;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CommandeRedo extends CommandeAbstraite {

    public CommandeRedo() {
        super("app.frame.menus.edition.redo");
    }

    @Override
    public void executer() {
        GestionnaireCommandes.getInstance().refaire();
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
