package log121.lab4.app;

import log121.lab4.api.Modele;

public class ModeleFactory {

    public static Modele creerModele(ModeleType type)
    {
        switch (type) {
            case IMAGE:
                return new ModeleImage();
            case PERSPECTIVE:
                return new ModelePerspective();
        }
        return null;
    }

}
