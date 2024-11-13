package universite_paris8.iut.lefarwestenperil.sae2_04.Vue.VieVue;

import javafx.scene.layout.HBox;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Personnage.Link2;

import java.util.ArrayList;
import java.util.List;

public class ListCoeurVue {
    private final List<CoeurVue> coeurs;
    private final HBox vieBox;

    public ListCoeurVue(Link2 link, HBox vieBox) {
        this.vieBox = vieBox;
        coeurs = new ArrayList<>();

        int nbCoeurs = (int) Math.ceil(link.getPointVie() / 4.0);
        for (int i = 0; i < nbCoeurs; i++) {
            CoeurVue coeur = new CoeurVue();
            coeurs.add(coeur);
            vieBox.getChildren().add(coeur.getImageView());
        }
        mettreAJourCoeurs(link.getPointVie());
    }

    public void mettreAJourCoeurs(int vie) {
        int coeursPleins = vie / 4;
        int reste = vie % 4;

        for (int i = 0; i < coeurs.size(); i++) {
            if (i < coeursPleins) {
                coeurs.get(i).setVie(4);
            } else if (i == coeursPleins) {
                coeurs.get(i).setVie(reste);
            } else {
                coeurs.get(i).setVie(0);
            }
        }

        int nbCoeursNecessaires = (int) Math.ceil(vie / 4.0);
        while (coeurs.size() < nbCoeursNecessaires) {
            CoeurVue coeur = new CoeurVue();
            coeurs.add(coeur);
            vieBox.getChildren().add(coeur.getImageView());
        }
    }
}
