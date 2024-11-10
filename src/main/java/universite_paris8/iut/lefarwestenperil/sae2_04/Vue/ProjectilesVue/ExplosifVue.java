package universite_paris8.iut.lefarwestenperil.sae2_04.Vue.ProjectilesVue;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.Projectile;

import java.net.URL;

/**
 * Classe ExplosifVue:
 * <p>
 * Cette classe s'occupe de l'affichage des projectiles {@code explosifs} (Bombe et Boule de feu) dans un pane
 * </p>
 * Elle gère principalement l'{@code animation de fin de vie} des projectiles
 */

public abstract class ExplosifVue extends ProjectileVue{

    private final URL urlExplosion;

    public ExplosifVue(Pane pane, Projectile projectile, URL urlImage, URL urlSon, URL urlExplosion) {
        super(pane, projectile, urlImage, urlSon);
        this.urlExplosion = urlExplosion;
    }

    public URL getUrlExplosion() {
        return urlExplosion;
    }

    @Override
    public void supprimerSprite(Projectile projectile){
        super.supprimerSprite(projectile);
        animationFinale(projectile);
    }

    private void animationFinale(Projectile projectile){
        ImageView explosionImageView = initImageFinale(projectile);
        getPane().getChildren().add(explosionImageView);

        if (getClip() != null) {
            getClip().setFramePosition(0); // Rewind to the beginning
            getClip().start();
        }
        Timeline delay = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            getPane().getChildren().remove(explosionImageView);
        }));
        delay.setCycleCount(1);
        delay.play();
    }

    private ImageView initImageFinale(Projectile projectile){
        Image imageExplosion = new Image(String.valueOf(getUrlExplosion()));
        ImageView explosionImageView = new ImageView(imageExplosion);

        double explosionWidth = imageExplosion.getWidth();
        double explosionHeight = imageExplosion.getHeight();

        double explosionX = projectile.getX() - explosionWidth / 2;
        double explosionY = projectile.getY() - explosionHeight / 2;

        explosionImageView.setX(explosionX);
        explosionImageView.setY(explosionY);
        return explosionImageView;
    }

}
