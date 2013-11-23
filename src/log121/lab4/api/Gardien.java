package log121.lab4.api;

import java.util.NoSuchElementException;
import java.util.Stack;

public class Gardien{

	
	public Gardien(IOriginateur originateur){
		this.originateur = originateur;
	}
	
	private final IOriginateur originateur;
	
	private final Stack<Memento> undoStack = new Stack<Memento>();
	
	private final Stack<Memento> redoStack = new Stack<Memento>();
	
	public void sauvegarder()
	{
		undoStack.push(originateur.creerMemento());
	}
	
	public void annuler()
	{
		if(!possedeAnnuler())
			throw new NoSuchElementException();
		
		Memento memento = undoStack.pop();
		originateur.restaurerMemento(memento);
		redoStack.push(memento);
	}
	
	
	public void refaire()
	{
		if(!possedeRefaire())
			throw new NoSuchElementException();
		
		Memento memento = redoStack.pop();
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
