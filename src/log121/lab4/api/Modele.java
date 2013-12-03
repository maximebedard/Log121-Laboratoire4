/******************************************************
 Cours:  LOG121
 Projet: Laboratoire 4
 Nom du fichier: Modele.java
 Date créé: 2013-12-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Maxime Bédard
2013-12-03 Version initiale
 *******************************************************/

package log121.lab4.api;

import java.io.Serializable;
import java.util.Observable;

public abstract class Modele extends Observable implements IOriginateur, ICloneable,
        Serializable {

    private static final long serialVersionUID = -8014118939667006520L;

    protected Modele(){
        initDefaults();
    }

    public abstract void initDefaults();


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
