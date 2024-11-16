package universite_paris8.iut.lefarwestenperil.sae2_04.Vue.PersonnageVue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.lefarwestenperil.sae2_04.Main;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque.Marteau;
import javafx.embed.swing.SwingFXUtils;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque.AttaqueADistances.Arc;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque.StrategieAttaque;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class LinkVue extends PersonnageVue {
    private final Image imageLinkDroite;
    private final Image imageLinkGauche;
    private final Image imageLinkHaut;
    private final Image imageLinkDroiteA;
    private final Image imageLinkGaucheA;
    private final Image imageLinkHautA;
    private final Image imageLinkDroiteM;
    private final Image imageLinkGaucheM;
    private final Image imageLinkHautM;
    private ImageView iv3;

    private String direction;

    public LinkVue(Pane panneauDeJeu){
        super(panneauDeJeu);
        URL urlImageGaucheA = Main.class.getResource("linkArcGauche.png");
        URL urlImageHautA = Main.class.getResource("linkDos.png");
        URL urlImageDroite = Main.class.getResource("LinkDroiteTomaHawk.png");
        URL urlImageHaut = Main.class.getResource("LinkDosTomahawk.png");
        URL urlImageDroiteM = Main.class.getResource("linkMarteauDroite.png");
        URL urlImageHautM = Main.class.getResource("linkMarteauDroiteDos.png");

        imageLinkDroite = new Image(String.valueOf(urlImageDroite));
        imageLinkDroiteM = new Image(String.valueOf(urlImageDroiteM));
        imageLinkGaucheA = new Image(String.valueOf(urlImageGaucheA));

        BufferedImage originalImage;
        BufferedImage gaucheImage;
        BufferedImage marteauDroitImage;
        try {
            assert urlImageDroite != null;
            originalImage = ImageIO.read(urlImageDroite);
            assert urlImageDroiteM != null;
            marteauDroitImage = ImageIO.read(urlImageDroiteM);
            assert urlImageGaucheA != null;
            gaucheImage = ImageIO.read(urlImageGaucheA);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        imageLinkDroiteA = createMirrorImage(gaucheImage);
        imageLinkHautA = new Image(String.valueOf(urlImageHautA));
        imageLinkGauche = createMirrorImage(originalImage);
        imageLinkHaut = new Image(String.valueOf(urlImageHaut));
        imageLinkGaucheM = createMirrorImage(marteauDroitImage);
        imageLinkHautM = new Image(String.valueOf(urlImageHautM));
        direction = "DROITE";
    }

    public void creerLink(Personnage personnage) {
        iv3 = new ImageView(imageLinkDroite);
        iv3.translateXProperty().bind(personnage.xProperty());
        iv3.translateYProperty().bind(personnage.yProperty());
        getPanneauDeJeu().getChildren().add(iv3);
    }

    public void updateImage(Direction direction, StrategieAttaque arme) {
        Image image = null;
        boolean estUnArc = arme instanceof Arc;
        boolean estUnMarteau = arme instanceof Marteau;
        switch (direction) {
            case DROIT:
                image = estUnArc ? imageLinkDroiteA :(estUnMarteau ? imageLinkDroiteM :imageLinkDroite);
                this.direction = "DROITE";
                break;
            case GAUCHE:
                image = estUnArc ? imageLinkGaucheA :(estUnMarteau ? imageLinkGaucheM :imageLinkGauche);
                this.direction = "GAUCHE";
                break;
            case HAUT:
                image = estUnArc ? imageLinkHautA : (estUnMarteau ? imageLinkHautM :imageLinkHaut);
                break;
            case BAS:
                image = estUnArc ?
                            ((this.direction.equals("GAUCHE")) ? imageLinkGaucheA :imageLinkDroiteA)
                        : (this.direction.equals("GAUCHE")) ?
                                (estUnMarteau ? imageLinkGaucheM :imageLinkGauche)
                          : (estUnMarteau ? imageLinkDroiteM :imageLinkDroite);
                break;
        }
        iv3.setImage(image);
    }

    private static Image createMirrorImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage mirroredImage = new BufferedImage(width, height, image.getType());

        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-width, 0);

        Graphics2D g2d = mirroredImage.createGraphics();
        g2d.drawImage(image, tx, null);
        g2d.dispose();

        return SwingFXUtils.toFXImage(mirroredImage, null);
    }
}
