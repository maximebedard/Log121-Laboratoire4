package log121.lab4.api;

public class Perspective extends Modele<Perspective> implements ICloneable {

	private int x;

	private int y;

	private int zoom;

	/**
	 * @return the zoom
	 */
	public int getZoom() {
		return zoom;
	}

	/**
	 * @param zoom
	 *            the zoom to set
	 */
	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public Memento<Perspective> creerMemento() {
		return new Memento<Perspective>(this);
	}

	@Override
	public void restaurerMemento(Memento<Perspective> m) {
		setX(m.getEtat().getX());
		setY(m.getEtat().getY());
		setZoom(m.getEtat().getZoom());		
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
