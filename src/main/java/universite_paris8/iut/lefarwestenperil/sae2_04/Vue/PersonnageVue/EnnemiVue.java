package universite_paris8.iut.lefarwestenperil.sae2_04.Vue.PersonnageVue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import universite_paris8.iut.lefarwestenperil.sae2_04.Main;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Dragon;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Ennemi;

import java.net.URL;

public class EnnemiVue extends PersonnageVue {

    private final Image imageDra;
    private final Image imageCb;
    private ImageView iv2;


    public EnnemiVue(Pane panneauDeJeu) {
        super(panneauDeJeu);
        URL urlImageDra = Main.class.getResource("dragon.png");
        imageDra = new Image(String.valueOf(urlImageDra));
        URL urlImageCb = Main.class.getResource("CowBoyLasso.png");
        imageCb = new Image(String.valueOf(urlImageCb));
    }

    public void creerEnnemi(Ennemi ennemi) {
        if (ennemi instanceof Dragon) {
            iv2 = new ImageView(imageDra);
            iv2.setId(ennemi.getId());

        } else {
            iv2 = new ImageView(imageCb);
            iv2.setId(ennemi.getId());
        }

        iv2.translateXProperty().bind(ennemi.xProperty());
        iv2.translateYProperty().bind(ennemi.yProperty());

        getPanneauDeJeu().getChildren().add(iv2);
    }

    public void supprimerEnnemi(Ennemi ennemi) {
        System.out.println(ennemi.getId());
        getPanneauDeJeu().getChildren().remove(getPanneauDeJeu().lookup("#" + ennemi.getId()));
        getPanneauDeJeu().getChildren().remove(getPanneauDeJeu().lookup("#" + ennemi.getBarreDeVie().getId()));
    }


}