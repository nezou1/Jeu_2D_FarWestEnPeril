package universite_paris8.iut.lefarwestenperil.sae2_04.Vue.PersonnageVue;

import javafx.scene.layout.Pane;

public abstract class PersonnageVue {
    private Pane panneauDeJeu;


    public PersonnageVue(Pane panneauDeJeu) {
        this.panneauDeJeu = panneauDeJeu;
    }
    public Pane getPanneauDeJeu() {
        return this.panneauDeJeu;
    }

}
