package log121.lab4.api;

public abstract class Vue implements IObserveur<AttrModifieEvenement> {

	public Vue(Controleur<?, ?> controleur)
	{
		initComponents();
        setControleur(controleur);
	}

	protected abstract void initComponents();

    protected abstract void setControleur(Controleur<?, ?> controleur);

}
