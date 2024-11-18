package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;

public abstract class Acteur extends Entite{

/**
 * Classe Acteur:
 *      <p>Cette classe s'occupe de la gestion des acteurs.</p>
 *      Elle gère l'{@code identification}
 *      Elle agit dans l'environnement
*/

    public Acteur(String id, Environnement environnement) {
        super(id,environnement);
    }

    public abstract void agit();

    public String toString() {
        return "Acteur [id=" + getId() + "]";
    }
}
