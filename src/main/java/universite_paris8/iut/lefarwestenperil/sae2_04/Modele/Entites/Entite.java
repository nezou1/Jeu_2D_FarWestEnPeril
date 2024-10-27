package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites;

public abstract class Entite {

/**
 * Classe Entite:
 *      <p>Cette classe s'occupe de la gestion des entités.</p>
 *      Elle gère l'{@code identification}
*/

    private final String id;
    private static int increment = 0;

    public Entite(String id) {
        this.id = id+"-"+increment++;
    }

    public String getId() {
        return id;
    }
}
