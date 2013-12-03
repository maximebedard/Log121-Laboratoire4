/******************************************************
 Cours:  LOG121
 Projet: Laboratoire 4
 Nom du fichier: IOriginateur.java
 Date créé: 2013-12-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Maxime Bédard
2013-12-03 Version initiale
 *******************************************************/

package log121.lab4.api;

public interface IOriginateur {

    /**
     * Création d'un memento de l'etat
     *
     * @return un nouveau mémento qui contient une copie de l'état
     */
    Memento creerMemento();

    /**
     * Restore l'objet à l'état définit par le memento
     *
     * @param m memento qui contient l'état de l'objet
     * @throws IllegalArgumentException
     * @throws NullPointerException
     */
    void restaurerMemento(Memento m);

}