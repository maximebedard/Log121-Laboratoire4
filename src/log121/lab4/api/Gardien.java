package log121.lab4.api;

import java.util.NoSuchElementException;
import java.util.Stack;

public class Gardien {


    public Gardien(IOriginateur originateur) {
        this.originateur = originateur;
    }

    private final IOriginateur originateur;

    private final Stack<Memento> undoStack = new Stack<Memento>();

    public void sauvegarder() {
        undoStack.push(originateur.creerMemento());
    }

    public void annuler() {
        if (undoStack.empty())
            throw new NoSuchElementException();

        Memento memento = undoStack.pop();
        originateur.restaurerMemento(memento);
    }


}
