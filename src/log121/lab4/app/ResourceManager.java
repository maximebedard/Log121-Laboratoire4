/******************************************************
 Cours:  LOG121
 Projet: Laboratoire 4
 Nom du fichier: ResourceManager.java
 Date créé: 2013-12-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Maxime Bédard
2013-12-03 Version initiale
 *******************************************************/

package log121.lab4.app;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Utilitaire pour obtenir un mot dans la langue de l'application
 */
public class ResourceManager {

    private static final String PREFS_BUNDLE_BASENAME = "log121.lab4.app.prefs";
    private static final String BUNDLE_BASENAME = "log121.lab4.app.app", PREFERRED_LOCALE_KEY = "locale";
    private static ResourceBundle resources;
    private static Locale locale;

    static {
        try {
            ResourceBundle preferences = ResourceBundle.getBundle(PREFS_BUNDLE_BASENAME);
            locale = new Locale(preferences.getString(PREFERRED_LOCALE_KEY));
        } catch (java.util.MissingResourceException ex) {
            System.err.println("ERROR: cannot find preferences properties file " +
                    BUNDLE_BASENAME);
        }
        try {
            resources = ResourceBundle.getBundle(BUNDLE_BASENAME, locale);
        } catch (java.util.MissingResourceException ex) {
            System.err.println("ERROR: cannot find properties file for " + BUNDLE_BASENAME);
        }
    }

    /**
     * Retourne un mot (dans la langue de l'application) lié à un champs
     *
     * @param key champs
     * @return resource
     */
    public static String getResource(String key) {
        return (resources == null) ? null : resources.getString(key);
    }
}
