/******************************************************
 Cours:  LOG121
 Projet: Laboratoire 4
 Nom du fichier: ICommande.java
 Date créé: 2013-12-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Maxime Bédard
 2013-12-03 Version initiale
 *******************************************************/


package log121.lab4.api;

public interface ICommande {

    /**
     * Execute la commande
     */
    void executer();

    /**
     * Définit si l'opération est annulable (peut-être annulé)
     *
     * @return vrai si l'opération peut être annulé
     */
    boolean annulable();

}
