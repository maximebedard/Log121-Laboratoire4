package log121.lab4.app;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CommandeAide extends CommandeAbstraite
{
    public CommandeAide() {
        super("app.frame.menus.help.about");
    }

    @Override
    public void executer() {
        System.out.println("asDASDAS");
        // TODO
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
