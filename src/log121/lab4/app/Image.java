package log121.lab4.app;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import log121.lab4.api.Memento;
import log121.lab4.api.Modele;

public class Image extends Modele<Image> {

	private static final long serialVersionUID = -679409394432923243L;

	@Override
	public Memento<Image> creerMemento() {
		return new Memento<Image>(this);
	}

	@Override
	public void restaurerMemento(Memento<Image> m) {
		throw new NotImplementedException();
	}


}
