package log121.lab4.app;

import log121.lab4.api.Memento;
import log121.lab4.api.Modele;

public class Perspective extends Modele<Perspective> {

	private static final long serialVersionUID = 2693092317130168995L;

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
		int oldZoom = this.zoom;
		this.zoom = zoom;
		lanceAttributEvenement("ZOOM", oldZoom, zoom);		
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
		int oldY = this.y;
		this.y = y;
		lanceAttributEvenement("Y", oldY, y);
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
		int oldX = this.x;
		this.x = x;
		lanceAttributEvenement("X", oldX, x);
	}

	@Override
	public Memento<Perspective> creerMemento() {
		return new Memento<Perspective>(this);
	}

	@Override
	public void restaurerMemento(Memento<Perspective> m) {
		Perspective p = m.getEtat();
		setX(p.getX());
		setY(p.getY());
		setZoom(p.getZoom());
	}

}
