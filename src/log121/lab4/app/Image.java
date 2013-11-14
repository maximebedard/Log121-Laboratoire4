package log121.lab4.app;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import log121.lab4.api.ICloneable;
import log121.lab4.api.Memento;
import log121.lab4.api.Modele;

public class Image extends Modele<Image> implements ICloneable {

	@Override
	public Memento<Image> creerMemento() {
		return new Memento<Image>(this);
	}

	@Override
	public void restaurerMemento(Memento<Image> m) {
		throw new NotImplementedException();
	}

	@Override
	public Object cloneObject() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

}
