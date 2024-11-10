package universite_paris8.iut.lefarwestenperil.sae2_04.Vue.PersonnageVue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.lefarwestenperil.sae2_04.Main;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes.Arme;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes.Marteau;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;
import javafx.embed.swing.SwingFXUtils;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes.TireALArc;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants.EtreVivant;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Weapons.Weapon;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class LinkVue extends PersonnageVue {
    private Image imageLinkDroite;
    private Image imageLinkGauche;
    private Image imageLinkHaut;
    private Image imageLinkDroiteA;
    private Image imageLinkGaucheA;
    private Image imageLinkHautA;
    private Image imageLinkDroiteM;
    private Image imageLinkGaucheM;
    private Image imageLinkHautM;
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
        BufferedImage originalImage = null;
        BufferedImage gaucheImage = null;
        BufferedImage marteauDroitImage = null;
        try {
            originalImage = ImageIO.read(urlImageDroite);
            marteauDroitImage = ImageIO.read(urlImageDroiteM);
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

    public void creerLink(EtreVivant etreVivant) {
        iv3 = new ImageView(imageLinkDroite);
        iv3.translateXProperty().bind(etreVivant.xProperty());
        iv3.translateYProperty().bind(etreVivant.yProperty());
        super.getPanneauDeJeu().getChildren().add(iv3);
    }

    public void updateImage(String direction, Weapon arme) {
        switch (direction) {
            case "DROITE":
                if (arme instanceof TireALArc){
                    iv3.setImage(imageLinkDroiteA);
                } else {
                    if(arme instanceof Marteau) {
                        iv3.setImage(imageLinkDroiteM);
                    } else{
                        iv3.setImage(imageLinkDroite);
                    }
                }
                this.direction = "DROITE";
                break;
            case "GAUCHE":
                if (arme instanceof TireALArc){
                    iv3.setImage(imageLinkGaucheA);
                }else {
                    if (arme instanceof Marteau) {
                        iv3.setImage(imageLinkGaucheM);
                    } else {
                        iv3.setImage(imageLinkGauche);
                    }
                }
                this.direction = "GAUCHE";
                break;
            case "HAUT":
                if (arme instanceof TireALArc){
                    iv3.setImage(imageLinkHautA);
                }else {
                    if(arme instanceof Marteau){
                        iv3.setImage(imageLinkHautM);
                    } else {
                        iv3.setImage(imageLinkHaut);
                    }
                }
                break;
            case "BAS":
                if (arme instanceof TireALArc){
                    if (this.direction.equals("GAUCHE")) {
                        iv3.setImage(imageLinkGaucheA);
                    } else {
                        iv3.setImage(imageLinkDroiteA);
                        this.direction = "DROITE";
                    }
                } else {
                    if (arme instanceof Marteau) {
                        if (this.direction.equals("GAUCHE")) {
                            iv3.setImage(imageLinkGaucheM);
                        } else {
                            iv3.setImage(imageLinkDroiteM);
                            this.direction = "DROITE";
                        }
                    } else {
                        if (this.direction.equals("GAUCHE")) {
                            iv3.setImage(imageLinkGauche);
                        } else {
                            iv3.setImage(imageLinkDroite);
                            this.direction = "DROITE";
                        }
                    }
                }
                break;
        }
    }

    // essayetu rep a la qquestion tu attaque le cactus
//jfais comment pour lavoir okok
    //et comment je fais pour casser les cactus
    //
    public static Image createMirrorImage(BufferedImage image) {
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
