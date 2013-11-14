package log121.lab4.api;

public class AttributEvenement {

	/**
	 * Référence vers le sujet (immuable)
	 */
	private final ISujet<AttributEvenement> sujet;
	
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
	 * @param sujet
	 * @param attribut
	 * @param ancienneValeur
	 * @param nouvelleValeur
	 */
	public AttributEvenement(ISujet<AttributEvenement> sujet, String attribut, Object ancienneValeur, Object nouvelleValeur)
	{
		this.sujet = sujet;
		this.attribut = attribut;
		this.ancienneValeur = ancienneValeur;
		this.nouvelleValeur = nouvelleValeur;
	}

	/**
	 * @return the sujet
	 */
	public ISujet<AttributEvenement> getSujet() {
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
