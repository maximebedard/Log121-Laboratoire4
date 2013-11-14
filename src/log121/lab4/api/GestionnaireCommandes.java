package log121.lab4.api;

import java.util.NoSuchElementException;
import java.util.Stack;

public final class GestionnaireCommandes{

	/**
	 * Pile qui contient toutes les opérations pouvant être annulés
	 */
	private final Stack<ICommande> undoStack = new Stack<ICommande>();
	 
	/**
	 * Pile qui contient toutes les opérations pouvant être refaites
	 */
	private final Stack<ICommande> redoStack = new Stack<ICommande>();
	
	/**
	 * Instance de la classe actuelle (Singleton)
	 */
	private static GestionnaireCommandes instance = new GestionnaireCommandes();

	/**
	 * Retourne l'instance unique du gestionnaire de commandes
	 * @return
	 */
	public static GestionnaireCommandes getInstance(){
		return instance;
	}
	
	/**
	 * Execute la commande désiré et la conserve dans l'historique
	 * @param commande
	 */
	public void executer(ICommande commande)
	{
		if(commande == null)
			throw new IllegalArgumentException();
		
		undoStack.push(commande);
		commande.executer();
	}
	
	/**
	 * Annule la commande précédente
	 * @throws NoSuchElementException
	 */
	public void annuler()
	{
		if(undoStack.empty())
			throw new NoSuchElementException();
		
		ICommande commande = undoStack.pop();
		commande.defaire();
		redoStack.push(commande);
	}
	
	/**
	 * Exécute la commande précemment annulé
	 * @throws NoSuchElementException
	 */
	public void refaire()
	{
		if(redoStack.empty())
			throw new NoSuchElementException();
		
		ICommande commande = redoStack.pop();
		commande.executer();
		undoStack.push(commande);
	}
	
}
