package log121.lab4.api;

public interface IOriginateur<T extends ICloneable> {
	
	/**
	 * Création d'un memento de l'etat
	 * @return
	 */
	Memento<T> creerMemento();
	
	/**
	 * Restauration de l'etat à partir du memento
	 * @param m
	 */
	void restaurerMemento(Memento<T> m);

}