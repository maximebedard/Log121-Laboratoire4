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


    public static void serialiser(Modele m, String chemin) throws IOException {

        FileOutputStream fileOut = new FileOutputStream(chemin);

        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(m);
        out.close();

        fileOut.close();

    }

    public static Modele deserialiser(String chemin) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(chemin);

        ObjectInputStream ois = new ObjectInputStream(fis);

        return (Modele)ois.readObject();

    }

}
