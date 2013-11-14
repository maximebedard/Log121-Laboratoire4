package log121.lab4.api;

public interface ISujet<T> {

	/**
	 * Attache un observeur au sujet pour écouter les événements produits
	 * @param o
	 */
	void attacher(IObserveur<T> o);

	/**
	 * Détache un observeur du sujet
	 * @param o
	 */
	void detacher(IObserveur<T> o);
	
	/**
	 * Notifie tous les observeurs présentement attachés au sujet
	 * @param event
	 */
	void notifier(T event);

}
