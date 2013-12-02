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
