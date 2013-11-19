package log121.lab4.api;

public class AttrModifieEvenement {

	/**
	 * Référence vers le sujet (immuable)
	 */
	private final ISujet<AttrModifieEvenement> sujet;
	
	/**
	 * Référence vers l'attribut (immuable)
	 */
	private final String attribut;
	
	/**
	 * Référence vers l'ancinne valeur (immuable)
	 */
	private final Object ancienneValeur;
	
	/**
	 * Référence vers la nouvelle valeur (immuable)
	 */
	private final Object nouvelleValeur;
	
	/**
	 * Constructueur de l'événement qui est lancé lors de la modification d'un attribut
	 * @param sujet Sujet qui lance les événements
	 * @param attribut attribut qui est modifié sur le sujet
	 * @param ancienneValeur valeur avant que celle-ci soit modifié
	 * @param nouvelleValeur nouvelle valeur
	 */
	public AttrModifieEvenement(ISujet<AttrModifieEvenement> sujet, String attribut, Object ancienneValeur, Object nouvelleValeur)
	{
		this.sujet = sujet;
		this.attribut = attribut;
		this.ancienneValeur = ancienneValeur;
		this.nouvelleValeur = nouvelleValeur;
	}

	/**
	 * @return the sujet
	 */
	public ISujet<AttrModifieEvenement> getSujet() {
		return sujet;
	}

	/**
	 * @return the attribut
	 */
	public String getAttribut() {
		return attribut;
	}

	/**
	 * @return the ancienneValeur
	 */
	public Object getAncienneValeur() {
		return ancienneValeur;
	}

	/**
	 * @return the nouvelleValeur
	 */
	public Object getNouvelleValeur() {
		return nouvelleValeur;
	}
	
}
