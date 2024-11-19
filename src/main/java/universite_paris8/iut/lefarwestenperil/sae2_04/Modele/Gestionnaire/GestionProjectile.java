package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Gestionnaire;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.Projectile;

/**
 * Classe GestionProjectiles:
 * <p>
 * Cette classe s'occupe de la gestion des actions des projectiles
 * </p>
 * Tout cela se trouvait dans la class Environnement
 */

public class GestionProjectile {

    private final ObservableList<Projectile> projectiles = FXCollections.observableArrayList();

    public GestionProjectile() {
    }

    public ObservableList<Projectile> getProjectiles() {
        return projectiles;
    }

    public void ajouterProjectile(Projectile fleche) {
        projectiles.add(fleche);
    }

    public void mettreAJourProjectiles() {
        for (int i = 0; i < projectiles.size(); i++) {
            Projectile p = projectiles.get(i);
            if (p.isActive()) {
                p.agit();
            } else {
                p.desactivation();
                projectiles.remove(p);
            }
        }
    }
}
