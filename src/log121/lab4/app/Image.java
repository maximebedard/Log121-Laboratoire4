package log121.lab4.app;

import log121.lab4.api.ICloneable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import log121.lab4.api.Memento;
import log121.lab4.api.Modele;

public class Image extends Modele {

	private static final long serialVersionUID = -679409394432923243L;

	@Override
	public void restaurerMemento(Memento<ICloneable> m) {
		throw new NotImplementedException();
	}


}
