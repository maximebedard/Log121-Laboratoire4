package log121.lab4;

import java.util.Stack;

public class GestionnaireCommandes{

	
	private Stack<ICommande> historique = new Stack<ICommande>();
	
	private static GestionnaireCommandes instance = new GestionnaireCommandes();

	public GestionnaireCommandes getInstance(){
		return instance;
	}
	
	public void executer(ICommande commande)
	{
		if(commande == null)
			throw new IllegalArgumentException();
		
		historique.push(commande);
		commande.executer();
	}
	
	public void defaire()
	{
		if(historique.size() == 0)
			return ;
		
		historique.pop().defaire();;
	}
	
}
