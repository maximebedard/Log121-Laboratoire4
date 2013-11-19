package log121.lab4.api.tests;

import log121.lab4.api.ICloneable;
import log121.lab4.api.IOriginateur;
import log121.lab4.api.Memento;

public class OriginateurConcret implements IOriginateur, ICloneable{

	private int x;
	
	private int y;
	
	@Override
	public Object cloneObject() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
		return null;}
	}

	@Override
	public Memento creerMemento() {
		return new Memento(this);
	}

	@Override
	public void restaurerMemento(Memento m) {

        if (m == null)
            throw new NullPointerException();

        if (!(m.getEtat() instanceof OriginateurConcret))
            throw new IllegalArgumentException();

        OriginateurConcret oc = (OriginateurConcret) m.getEtat();
		this.setX(oc.getX());
		this.setY(oc.getY());
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}


	
}