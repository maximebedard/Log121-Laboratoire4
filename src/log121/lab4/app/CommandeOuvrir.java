package log121.lab4.app;


import log121.lab4.api.ICommande;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CommandeOuvrir implements ICommande {

    @Override
    public void executer() {
        // TODO : ouvrir les modèles sérialisés
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
