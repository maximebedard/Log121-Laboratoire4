/******************************************************
 Cours:  LOG121
 Projet: Laboratoire 4
 Nom du fichier: Memento.java
 Date créé: 2013-12-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Maxime Bédard
2013-12-03 Version initiale
 *******************************************************/

package log121.lab4.api;

public class Memento {

    /**
     * Etat immuable du memento
     */
    private final ICloneable etat;

    /**
     * Constructeur d'un memento immuable
     *
     * @param etat objet clonable qui sera cloné
     */
    @SuppressWarnings("unchecked")
    public Memento(ICloneable etat) {
        this.etat = (ICloneable) etat.cloneObject();
    }

    /**
     * Retourne l'état du memento
     *
     * @return la copie immuable de l'objet
     */
    public ICloneable getEtat() {
        return etat;
    }

}
