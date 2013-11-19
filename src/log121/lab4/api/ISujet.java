package log121.lab4.api;

public interface ISujet<T> {

	/**
	 * Attache un observeur au sujet pour écouter les événements produits
	 * @param o observateur générique auquel celui-ci doit être attaché
	 */
	void attacher(IObserveur<T> o);

	/**
	 * Détache un observeur du sujet
	 * @param o observateur générique auquel celui-ci doit être détaché
	 */
	void detacher(IObserveur<T> o);
	
	/**
	 * Notifie tous les observeurs présentement attachés au sujet
	 * @param event événement envoyé à tous les observateurs du sujet
	 */
	void notifier(T event);

}
