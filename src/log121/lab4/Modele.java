package log121.lab4;

import java.util.Observable;

public abstract class Modele<T> extends Observable implements IOriginateur<T> {
	
	/**
	 * Instance d'un originateur
	 */
	private final IOriginateur<T> originateur = new Originateur<T>();

	/**
	 * Retourne l'originateur qui conserve les etats dans des mementos
	 * @return the originateur
	 */
	public IOriginateur<T> getOriginateur() {
		return originateur;
	}
	
	@Override
	public Memento<T> sauvegarder() {
		return originateur.sauvegarder();
	}
	
	@Override
	public void restorer(Memento<T> m) {
		originateur.restorer(m);
	}
}
