package universite_paris8.iut.lefarwestenperil.sae2_04.Vue.ArmesVue;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import universite_paris8.iut.lefarwestenperil.sae2_04.Main;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles.BouleDeFeu;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class BouleDeFeuVue {
    private final Pane panneauDeJeu;
    private final Image imageBouleDeFeu;
    private final Image imageExplosion;
    private Clip clipExplosion;


    public BouleDeFeuVue(Pane panneauDeJeu) {
        this.panneauDeJeu = panneauDeJeu;
        URL urlImageBouleDeFeu = Main.class.getResource("bouledefeu.png");
        imageBouleDeFeu = new Image(String.valueOf(urlImageBouleDeFeu));
        URL urlImageExplosion = Main.class.getResource("explosion_feu.gif");
        imageExplosion = new Image(String.valueOf(urlImageExplosion));
        try {
            URL urlSonExplosion = Main.class.getResource("explosion.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(urlSonExplosion);
            clipExplosion = AudioSystem.getClip();
            clipExplosion.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ImageView creerBouleDeFeu(BouleDeFeu bouleDeFeu) {
        ImageView bouleDeFeuImageView = new ImageView(imageBouleDeFeu);
        bouleDeFeuImageView.setId(bouleDeFeu.getId());
        bouleDeFeuImageView.translateXProperty().bind(bouleDeFeu.xProperty());
        bouleDeFeuImageView.translateYProperty().bind(bouleDeFeu.yProperty());

        panneauDeJeu.getChildren().add(bouleDeFeuImageView);
        return bouleDeFeuImageView;
    }

    public void exploserBouleDeFeu(BouleDeFeu bouleDeFeu) {
        ImageView explosionImageView = new ImageView(imageExplosion);
        double explosionWidth = imageExplosion.getWidth();
        double explosionHeight = imageExplosion.getHeight();
        double explosionX = bouleDeFeu.getX() - explosionWidth / 2;
        double explosionY = bouleDeFeu.getY() - explosionHeight / 2;
        explosionImageView.setX(explosionX);
        explosionImageView.setY(explosionY);
        panneauDeJeu.getChildren().add(explosionImageView);
        if (clipExplosion != null) {
            clipExplosion.setFramePosition(0); // Rewind to the beginning
            clipExplosion.start();
        }

        Timeline delay = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            panneauDeJeu.getChildren().remove(explosionImageView);
        }));
        delay.setCycleCount(1);
        delay.play();
    }

    public void supprimerBouleDeFeu(BouleDeFeu bouleDeFeu) {
        panneauDeJeu.getChildren().remove(panneauDeJeu.lookup("#" + bouleDeFeu.getId()));
    }
}


