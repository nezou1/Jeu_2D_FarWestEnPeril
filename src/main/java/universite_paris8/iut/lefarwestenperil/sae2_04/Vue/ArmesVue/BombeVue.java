package universite_paris8.iut.lefarwestenperil.sae2_04.Vue.ArmesVue;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import universite_paris8.iut.lefarwestenperil.sae2_04.Main;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes.Bombe;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class BombeVue {
    private final Pane panneauDeJeu;
    private final Image imageBombe;
    private final Image imageExplosion;
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

        ivBombe.setId(bombe.getId());
        panneauDeJeu.getChildren().add(ivBombe);

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    double newX = ivBombe.getX() + (bombe.getImpactX() - ivBombe.getX()) / 10;
                    double newY = ivBombe.getY() + (bombe.getImpactY() - ivBombe.getY()) / 10;
                    Platform.runLater(() -> {
                        ivBombe.setX(newX);
                        ivBombe.setY(newY);
                    });
                    Thread.sleep(50);
                }

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

                Thread.sleep(1000); // Delay for explosion display

                Platform.runLater(() -> panneauDeJeu.getChildren().remove(ivBombe));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
