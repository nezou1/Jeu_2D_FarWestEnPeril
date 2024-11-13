package universite_paris8.iut.lefarwestenperil.sae2_04.Vue.ProjectilesVue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Projectiles.Projectile;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.net.URL;

/**
 * Classe ProjectileVue:
 * <p>
 * Cette classe s'occupe de l'affichage des projectiles dans un pane
 * </p>
 * Elle a:
 * <ul>
 *  <li>un panneau</li>
 *  <li>un projectile</li>
 *  <li>des liens pour les images et le effets sonores</li>
 *  <li>un clip audio</li>
 * </ul>
 * Elle gère :
 * <ul>
 *     <li>la création des sprite</li>
 *     <li>les effets sonores</li>
 *     <li>la suppression des sprites</li>
 *</ul>
 */

public abstract class ProjectileVue {

    private final URL urlImage;
    private final URL urlSon;

    private Clip clip;

    private final Pane pane;
    private final Projectile projectile;

    public ProjectileVue(Pane pane, Projectile projectile, URL urlImage, URL urlSon) {
        this.pane = pane;
        this.projectile = projectile;
        this.urlImage = urlImage;
        this.urlSon = urlSon;
    }

    public Pane getPane() {
        return pane;
    }
    public Projectile getProjectile() {
        return projectile;
    }
    public URL getURLImage() {
        return urlImage;
    }
    public Clip getClip(){
        return clip;
    }

    public void creerSprite(){
        ImageView imageVue = new ImageView(new Image(String.valueOf(urlImage)));
        initSprite(imageVue);
    }

    public void lancerSon(){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(urlSon);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initSprite(ImageView imageVue) {
        imageVue.setId(projectile.getId());
        imageVue.translateXProperty().bind(projectile.xProperty());
        imageVue.translateYProperty().bind(projectile.yProperty());
        getPane().getChildren().add(imageVue);
    }

    public void supprimerSprite(Projectile projectile) {
        pane.getChildren().remove(pane.lookup("#" + projectile.getId()));
    }
}