package log121.lab4.api;

import javax.swing.JPanel;

public abstract class Vue<T> extends JPanel implements IObserveur<AttrModifieEvenement> {

	private static final long serialVersionUID = -8638094888905155861L;
	
	protected Controleur<T> controleur;
	
	public Vue(Controleur<T> controleur)
	{
		this.controleur = controleur;
	}
	
	public abstract void initComponents();

}
