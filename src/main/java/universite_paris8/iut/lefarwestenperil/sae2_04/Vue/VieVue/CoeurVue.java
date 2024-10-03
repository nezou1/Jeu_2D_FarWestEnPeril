package universite_paris8.iut.lefarwestenperil.sae2_04.Vue.VieVue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import universite_paris8.iut.lefarwestenperil.sae2_04.Main;

public class CoeurVue {
    private ImageView imageView;
    private Image coeurVide;
    private Image coeurQuart;
    private Image coeurDemi;
    private Image coeurTroisQuarts;
    private Image coeurPlein;


    public CoeurVue() {
        coeurVide = new Image(String.valueOf(Main.class.getResource("coeur_vide.png")));
        coeurQuart = new Image(String.valueOf(Main.class.getResource("coeur1.png")));
        coeurDemi = new Image(String.valueOf(Main.class.getResource("coeur_demi.png")));
        coeurTroisQuarts = new Image(String.valueOf((Main.class.getResource("coeur3.png"))));
        coeurPlein = new Image(String.valueOf((Main.class.getResource("coeur.png"))));

        imageView = new ImageView(coeurVide);
        imageView.setFitWidth(60);
        imageView.setFitHeight(60);

    }

    public void setVie(int vie) {
        switch (vie) {
            case 0:
                imageView.setImage(coeurVide);
                break;
            case 1:
                imageView.setImage(coeurQuart);
                break;
            case 2:
                imageView.setImage(coeurDemi);
                break;
            case 3:
                imageView.setImage(coeurTroisQuarts);
                break;
            case 4:
                imageView.setImage(coeurPlein);
                break;
        }
    }

    public ImageView getImageView() {
        return imageView;
    }
}
