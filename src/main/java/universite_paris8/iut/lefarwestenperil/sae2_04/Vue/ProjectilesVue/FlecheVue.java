package universite_paris8.iut.lefarwestenperil.sae2_04.Vue.ProjectilesVue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.lefarwestenperil.sae2_04.Main;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.Projectile;

import java.util.Objects;

/**
 * Classe FlecheVue:
 * <p>
 * Cette classe s'occupe de l'affichage des flèches dans un pane.
 * <p>Elle gère principalement les effets sonores et l'orientation de l'image de la flèche
 */

public class FlecheVue extends ProjectileVue {

    public FlecheVue(Pane pane, Projectile projectile) {
        super(
                pane,
                projectile,
                Main.class.getResource("fleche.png"),
                Objects.requireNonNull(Main.class.getResource("sonFleche.wav"))
        );
    }

    @Override
    public void creerSprite() {
        Direction dir = getProjectile().getDirection();
        ImageView flecheImageView = initializeImageView(dir);
        initSprite(flecheImageView);
        getClip().start();
    }

    /**
     * Cette méthode initialise l'image et oriente l'image par rapport à la direction de la flèche
     *
     * @param direction {@link Direction}
     * @return {@link ImageView}
     */
    private ImageView initializeImageView(Direction direction) {
        ImageView flecheImageView = new ImageView(new Image(String.valueOf(getURLImage())));
        switch (direction) {
            case DROIT:
                flecheImageView.setRotate(0);
                break;
            case HAUT:
                flecheImageView.setRotate(-90);
                break;
            case GAUCHE:
                flecheImageView.setRotate(180);
                break;
            case BAS:
                flecheImageView.setRotate(90);
                break;
        }
        return flecheImageView;
    }

    @Override
    public void supprimerSprite(Projectile projectile) {
        super.supprimerSprite(projectile);
        if (getClip() != null) {
            getClip().stop();
        }
    }
}
