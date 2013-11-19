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
	private static final GestionnaireCommandes instance = new GestionnaireCommandes();

	/**
	 * Retourne l'instance unique du gestionnaire de commandes
	 * @return instance unique du gestionnaire
	 */
	public static GestionnaireCommandes getInstance(){
		return instance;
	}
	
	/**
	 * Execute la commande désiré et la conserve dans l'historique
	 * @param commande commande qui doit être éxecuté
	 */
	public void executer(ICommande commande)
	{
		if(commande == null)
			throw new IllegalArgumentException();

        if(commande.annulable())
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
		commande.annuler();
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
