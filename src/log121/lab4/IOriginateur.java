package log121.lab4;

public interface IOriginateur<T> {

	Memento<T> sauvegarder();
	
	void restorer(Memento<T> memento);
	
}
