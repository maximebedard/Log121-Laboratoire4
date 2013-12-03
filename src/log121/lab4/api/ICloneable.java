/******************************************************
 Cours:  LOG121
 Projet: Laboratoire 4
 Nom du fichier: ICloneable.java
 Date créé: 2013-12-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Maxime Bédard
 2013-12-03 Version initiale
 *******************************************************/

package log121.lab4.api;

public interface ICloneable extends Cloneable {

    /**
     * Créé une copie de l'objet
     *
     * @return copie de l'objet
     */
    Object cloneObject();

}
