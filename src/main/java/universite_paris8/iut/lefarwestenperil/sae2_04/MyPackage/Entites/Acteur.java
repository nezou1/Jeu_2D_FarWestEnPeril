package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;

public abstract class Acteur extends Entite{

/**
 * Classe Acteur:
 *      <p>Cette classe s'occupe de la gestion des acteurs.</p>
 *      Elle gère l'{@code identification}
 *      Elle agit dans l'environnement
*/

    private final Environnement2 environnement;

    public Acteur(String id, Environnement2 environnement) {
        super(id);
        this.environnement = environnement;
    }

    public Environnement2 getEnv() {
        return environnement;
    }

    public abstract void agit();

    public String toString() {
        return "Acteur [id=" + getId() + "]";
    }
}
