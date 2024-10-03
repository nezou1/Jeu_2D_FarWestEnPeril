package universite_paris8.iut.lefarwestenperil.sae2_04.Vue.ArmesVue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import universite_paris8.iut.lefarwestenperil.sae2_04.Main;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes.Bombe;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class BombeVue {
    private Pane panneauDeJeu;
    private Image imageBombe;
    private Image imageExplosion;
    private ImageView ivBombe;
    private Clip clipExplosion;

    public BombeVue(Pane panneauDeJeu) {
        this.panneauDeJeu = panneauDeJeu;
        URL urlImageBombe = Main.class.getResource("bombe.png");
        imageBombe = new Image(String.valueOf(urlImageBombe));
        URL urlImageExplosion = Main.class.getResource("explosion.gif");
        imageExplosion = new Image(String.valueOf(urlImageExplosion));

        // Charger le son de l'explosion
        try {
            URL urlSonExplosion = Main.class.getResource("bombeExp.wav");
            AudioInputStream audioInputStreamExplosion = AudioSystem.getAudioInputStream(urlSonExplosion);
            clipExplosion = AudioSystem.getClip();
            clipExplosion.open(audioInputStreamExplosion);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void creerBombe(Bombe bombe) {
        ivBombe = new ImageView(imageBombe);
        ivBombe.setX(bombe.getX());
        ivBombe.setY(bombe.getY());
        ivBombe.setId(bombe.getId());
        panneauDeJeu.getChildren().add(ivBombe);

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(50), event -> {
                    double newX = ivBombe.getX() + (bombe.getImpactX() - ivBombe.getX()) / 10;
                    double newY = ivBombe.getY() + (bombe.getImpactY() - ivBombe.getY()) / 10;
                    Platform.runLater(() -> {
                        ivBombe.setX(newX);
                        ivBombe.setY(newY);
                    });
                })
        );
        animation.setCycleCount(10);
        animation.play();

        animation.setOnFinished(event -> {
            Platform.runLater(() -> {
                panneauDeJeu.getChildren().remove(ivBombe);
                ivBombe = new ImageView(imageExplosion);
                ivBombe.setX(bombe.getImpactX() - imageExplosion.getWidth() / 2);
                ivBombe.setY(bombe.getImpactY() - imageExplosion.getHeight() / 2);
                panneauDeJeu.getChildren().add(ivBombe);
            });

            // Jouer le son de l'explosion
            if (clipExplosion != null) {
                clipExplosion.setFramePosition(0); // Rewind to the beginning
                clipExplosion.start();
            }

            Timeline delay = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
                Platform.runLater(() -> panneauDeJeu.getChildren().remove(ivBombe));
            }));
            delay.play();
        });
    }
}
