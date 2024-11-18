package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;

/**
 * Classe Entite:
 *      <p>Cette classe s'occupe de la gestion des acteurs.</p>
 *      Elle gère l'{@code identification}
 *      Elle agit dans l'environnement
 */

public class Entite {

    private static int increment = 0;
    private final String id;
    private Environnement environnement;

    public Entite(String id, Environnement env) {
        this.id = id+"-"+increment++;
        this.environnement = env;
    }

    public String getId() {
        return id;
    }

    public Environnement getEnv() {
        return environnement;
    }

}
