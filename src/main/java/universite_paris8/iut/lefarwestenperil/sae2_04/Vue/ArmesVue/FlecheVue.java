package universite_paris8.iut.lefarwestenperil.sae2_04.Vue.ArmesVue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.lefarwestenperil.sae2_04.Main;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles.Fleche;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class FlecheVue {
    private final Pane panneauDeJeu;
    private final Image imageFleche;
    private ImageView flecheImageView;
    private Clip clipFleche;

    public FlecheVue(Pane panneauDeJeu) {
        this.panneauDeJeu = panneauDeJeu;
        URL urlImageFleche = Main.class.getResource("fleche.png");
        imageFleche = new Image(String.valueOf(urlImageFleche));

        try {
            URL urlSonFleche = Main.class.getResource("fleche (2).wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(urlSonFleche);
            clipFleche = AudioSystem.getClip();
            clipFleche.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void creerFleche(Fleche fleche) {
        flecheImageView = new ImageView(imageFleche);
        flecheImageView.setId(fleche.getId());

        switch (fleche.getDirection()) {
            case 0:
                flecheImageView.setRotate(0);
                break;
            case 1:
                flecheImageView.setRotate(90);
                break;
            case 2:
                flecheImageView.setRotate(180);
                break;
            case 3:
                flecheImageView.setRotate(-90);
                break;
        }

        flecheImageView.translateXProperty().bind(fleche.xProperty());
        flecheImageView.translateYProperty().bind(fleche.yProperty());

        panneauDeJeu.getChildren().add(flecheImageView);
        if (clipFleche != null) {
            clipFleche.setFramePosition(0); // Rewind to the beginning
            clipFleche.loop(Clip.LOOP_CONTINUOUSLY); // Play in loop
        }
    }

    public void supprimerFleche(Fleche fleche) {
        panneauDeJeu.getChildren().remove(panneauDeJeu.lookup("#" + fleche.getId()));
        // Arrêter le son de la flèche
        if (clipFleche != null) {
            clipFleche.stop();
        }
    }
}
