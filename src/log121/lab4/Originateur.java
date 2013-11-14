package log121.lab4;

public class Originateur<T> implements IOriginateur<T> {

	/**
	 * État de l'originateur
	 */
	private T etat;
	
	/**
	 * Créé un nouveau memento de l'état actuel
	 * @return
	 */
	public Memento<T> sauvegarder() {
		return new Memento<T>(etat);
	}
	
	/**
	 * Restore l'état du mémento actuel
	 * @param m
	 */
	public void restorer(Memento<T> m){
		etat = m.getEtat();
	}
	
}
