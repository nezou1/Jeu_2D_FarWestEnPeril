package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites;

/**
 * Classe Entite:
 *      <p>Cette classe s'occupe de la gestion des acteurs.</p>
 *      Elle gère l'{@code identification}
 *      Elle agit dans l'environnement
 */

public class Entite {

    private static int increment = 0;
    private final String id;

    public Entite(String id) {
        this.id = id+"-"+increment++;
    }

    public String getId() {
        return id;
    }

}
