package log121.lab4.api;

import java.util.NoSuchElementException;
import java.util.Stack;

public class Gardien<T extends ICloneable> {

	
	public Gardien(IOriginateur<T> originateur){
		this.originateur = originateur;
	}
	
	private final IOriginateur<T> originateur;
	
	private final Stack<Memento<T>> undoStack = new Stack<Memento<T>>();
	
	private final Stack<Memento<T>> redoStack = new Stack<Memento<T>>();
	
	public void sauvegarder()
	{
		undoStack.push(originateur.creerMemento());
	}
	
	public void annuler()
	{
		if(!possedeAnnuler())
			throw new NoSuchElementException();
		
		Memento<T> memento = undoStack.pop();
		originateur.restaurerMemento(memento);
		redoStack.push(memento);
	}
	
	
	public void refaire()
	{
		if(!possedeRefaire())
			throw new NoSuchElementException();
		
		Memento<T> memento = redoStack.pop();
		originateur.restaurerMemento(memento);
		undoStack.push(memento);
	}
	
	public boolean possedeAnnuler(){
		return !undoStack.empty();
	}
	
	public boolean possedeRefaire(){
		return !redoStack.empty();
	}
	
	public int nbAnnuler()
	{
		return undoStack.size();
	}
	
	public int nbRefaire()
	{
		return redoStack.size();
	}
	
}
