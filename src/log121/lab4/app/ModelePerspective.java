package log121.lab4.app;

import log121.lab4.api.Memento;
import log121.lab4.api.Modele;

public class ModelePerspective extends Modele {

    private static final long serialVersionUID = 2693092317130168995L;

    private static final int DEFAULT_X = 0;

    private static final int DEFAULT_Y = 0;

    private static final int DEFAULT_ZOOM = 100;

    private int x;

    private int y;

    private int zoom;

    /**
     * Effectue la translation de la perspective
     *
     * @param dx deplacement en x
     * @param dy deplacement en y
     */
    public void translater(int dx, int dy) {
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
        this.zoom = zoom;
        setChanged();
        notifyObservers(zoom);
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
        setChanged();
        notifyObservers(y);
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
        setChanged();
        notifyObservers(x);
    }


    @Override
    public void restaurerMemento(Memento m) {
        if (m == null)
            throw new NullPointerException();

        if (!(m.getEtat() instanceof ModelePerspective))
            throw new IllegalArgumentException();

        ModelePerspective p = (ModelePerspective) m.getEtat();
        setX(p.getX());
        setY(p.getY());
        setZoom(p.getZoom());
    }

    public void incrementZoom(int zoomIncrement) {
        if(zoom + zoomIncrement < 0)
            setZoom(0);
        else
            setZoom(zoom + zoomIncrement);
    }

    @Override
    public void initDefaults() {
        setX(DEFAULT_X);
        setY(DEFAULT_Y);
        setZoom(DEFAULT_ZOOM);
    }
}
