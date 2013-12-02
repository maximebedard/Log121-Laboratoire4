package log121.lab4.app;

import log121.lab4.api.Gardien;
import log121.lab4.api.ICommande;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;

public final class GestionnaireCommandes {

    /**
     * Pile qui contient toutes les opérations pouvant être annulés
     */
    private final Stack<ICommande> undoStack = new Stack<ICommande>();

    /**
     * Pile qui contient toutes les opérations pouvant être refaites
     */
    private final Stack<ICommande> redoStack = new Stack<ICommande>();

    /**
     * Pile qui conserve l'état des originateurs
     */
    private final ArrayList<Gardien> gardiens = new ArrayList<Gardien>();

    /**
     * Instance de la classe actuelle (Singleton)
     */
    private static final GestionnaireCommandes instance = new GestionnaireCommandes();

    /**
     * Retourne l'instance unique du gestionnaire de commandes
     *
     * @return instance unique du gestionnaire
     */
    public static GestionnaireCommandes getInstance() {
        return instance;
    }

    /**
     * Execute la commande désiré et la conserve dans l'historique
     *
     * @param commande commande qui doit être éxecuté
     */
    public void executer(ICommande commande) {
        if (commande == null)
            throw new IllegalArgumentException();

        if (commande.annulable()) {
            undoStack.push(commande);
            for (Gardien g : gardiens)
                g.sauvegarder();
        }

        commande.executer();
    }

    /**
     * Annule la commande précédente
     *
     * @throws NoSuchElementException
     */
    public void annuler() {
        if (undoStack.empty())
            throw new NoSuchElementException();

        for (Gardien g : gardiens)
            g.annuler();

        ICommande commande = undoStack.pop();
        redoStack.push(commande);
    }

    /**
     * Exécute la commande précemment annulé
     *
     * @throws NoSuchElementException
     */
    public void refaire() {
        if (redoStack.empty())
            throw new NoSuchElementException();

        for (Gardien g : gardiens)
            g.sauvegarder();

        ICommande commande = redoStack.pop();
        commande.executer();
        undoStack.push(commande);
    }

    /**
     * Retourne vrai si le gestionnaire ne peut pas annuler de commandes
     *
     * @return
     */
    public boolean annulerVide() {
        return undoStack.empty();
    }

    /**
     * Retourne vrai si le gestionnaire ne peut pas annuler de commandes
     *
     * @return
     */
    public boolean refaireVide() {
        return redoStack.empty();
    }

    /**
     * Ajoute un gardien dans la liste
     *
     * @param gardien
     */
    public void ajouterGardien(Gardien gardien) {
        gardiens.add(gardien);
    }

    /**
     * Enleve un gardien de la liste
     *
     * @param gardien
     */
    public void enleverGardien(Gardien gardien) {
        gardiens.remove(gardien);
    }

}
