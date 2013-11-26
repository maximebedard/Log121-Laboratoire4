package log121.lab4.api;

import java.io.*;
import java.util.Observable;

public abstract class Modele extends Observable implements IOriginateur, ICloneable,
        Serializable {

    private static final long serialVersionUID = -8014118939667006520L;


    @Override
    public Memento creerMemento() {
        return new Memento(this);
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
