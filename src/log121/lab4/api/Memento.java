package log121.lab4.api;

public class Memento<T extends ICloneable>{

	/**
	 * Etat immuable du memento
	 */
	private final T etat;

	/**
	 * Constructeur d'un memento immuable
	 * @param etat
	 */
	@SuppressWarnings("unchecked")
	public Memento(T etat) {
		this.etat = (T) etat.cloneObject();
	}
	
	/**
	 * Retourne l'état du memento
	 * @return
	 */
	public T getEtat() {
		return etat;
	}
	
}
