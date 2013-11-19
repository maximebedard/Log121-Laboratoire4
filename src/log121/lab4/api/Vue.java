package log121.lab4.api;

public abstract class Vue implements IObserveur<AttrModifieEvenement> {

	protected Vue()
	{
		initComponents();
	}

	protected abstract void initComponents();

}
