package log121.lab4.api;

public interface IOriginateur<T extends ICloneable> {
	
	Memento<T> creerMemento();
	
	void restaurerMemento(Memento<T> m);

}