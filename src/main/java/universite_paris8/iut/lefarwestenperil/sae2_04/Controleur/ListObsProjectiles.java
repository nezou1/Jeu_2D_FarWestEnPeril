package universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.Projectile;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.Bombe;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.BouleDeFeu;

import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.ProjectilesVue.ProjectileVue;
import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.ProjectilesVue.BombeVue;
import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.ProjectilesVue.BouleDeFeuVue;
import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.ProjectilesVue.FlecheVue;

/**
 * Classe ListObsProjectiles:
 *      <p>
 *          Cette classe s'occupe de mettre à jour l'affichage de tous les projectiles dans le jeu
 *      </p>
 *      Elle possède:
 *      <ul>
 *          <li>un panneau {@link Pane}</li>
 *          <li>une vue {@link ProjectileVue}</li>
 *      </ul>
 *      Elle peut ajouter et supprimer des images de projectiles {@link #onChanged(Change)}
 */

public class ListObsProjectiles implements ListChangeListener<Projectile> {

    private final Pane pane;
    private ProjectileVue projVue;

    public ListObsProjectiles(Pane pane) {
        this.pane = pane;
        projVue=null;
    }

    /**
     * Cette méthode met à jour l'affichage par rapport à une liste de projectiles:
     * <ul>
     *     <li>Soit elle ajoute une image au pane</li>
     *     <li>Soit elle l'enlève</li>
     * </ul>
     * @param change
     */
    @Override
    public void onChanged(ListChangeListener.Change<? extends Projectile> change) {
        while (change.next()) {
            for (Projectile p : change.getAddedSubList()) {
                projVue = initProjectileVue(p);
                projVue.creerSprite();
                projVue.lancerSon();
            }
            for (Projectile p : change.getRemoved()) {
                projVue = initProjectileVue(p);
                projVue.supprimerSprite(p);
            }
        }
    }

    /**
     * Cette méthode initialise l'instance de la vue en fonction de l'instance du projectiles
     * @param p
     * @return {@link ProjectileVue}
     */
    private ProjectileVue initProjectileVue(Projectile p) {
        if (p instanceof Bombe)
            return new BombeVue(pane,p);
        else if (p instanceof BouleDeFeu)
            return new  BouleDeFeuVue(pane, p);
        else
            return new  FlecheVue(pane, p);
    }
}
