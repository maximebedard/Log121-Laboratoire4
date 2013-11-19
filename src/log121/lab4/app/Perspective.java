package log121.lab4.app;

import log121.lab4.api.ICloneable;
import log121.lab4.api.Memento;
import log121.lab4.api.Modele;

public class Perspective extends Modele {

    public static final String X_ATTR = "X";

    public static final String Y_ATTR = "Y";

    public static final String ZOOM_ATTR = "Zoom";

    private static final long serialVersionUID = 2693092317130168995L;

    private int x;

    private int y;

    private int zoom;

    public void translater(int dx, int dy)
    {
        setX(x + dx);
        setY(y + dy);
    }

    /**
     * @return the zoom
     */
    public int getZoom() {
        return zoom;
    }

    /**
     * @param zoom the zoom to set
     */
    public void setZoom(int zoom) {
        int oldZoom = this.zoom;
        this.zoom = zoom;
        lanceAttributEvenement(ZOOM_ATTR, oldZoom, zoom);
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
        int oldY = this.y;
        this.y = y;
        lanceAttributEvenement(Y_ATTR, oldY, y);
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
        int oldX = this.x;
        this.x = x;
        lanceAttributEvenement(X_ATTR, oldX, x);
    }


    @Override
    public void restaurerMemento(Memento m) {
        if (m == null)
            throw new NullPointerException();

        if (!(m.getEtat() instanceof Perspective))
            throw new IllegalArgumentException();

        Perspective p = (Perspective) m.getEtat();
        setX(p.getX());
        setY(p.getY());
        setZoom(p.getZoom());
    }

}
