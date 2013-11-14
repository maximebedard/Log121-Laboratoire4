package log121.lab4;

public class Memento<T> {

	/**
	 * Etat immuable du memento
	 */
	private final T etat;

	/**
	 * Constructeur d'un memento immuable
	 * @param etat
	 */
	public Memento(T etat) {
		this.etat = etat;
	}
	
	/**
	 * Retourne l'état du memento
	 * @return
	 */
	public T getEtat() {
		return etat;
	}
	
}
