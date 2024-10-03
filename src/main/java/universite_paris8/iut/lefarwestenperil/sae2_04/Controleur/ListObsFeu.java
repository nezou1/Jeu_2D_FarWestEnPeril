package universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles.BouleDeFeu;
import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.ArmesVue.BouleDeFeuVue;

public class ListObsFeu implements ListChangeListener<BouleDeFeu> {

    private Pane panneauDeJeu;
    private BouleDeFeuVue bouleDeFeuVue;


    public ListObsFeu(Pane PanneauJeu) {
        this.panneauDeJeu = PanneauJeu;
        this.bouleDeFeuVue = new BouleDeFeuVue(panneauDeJeu);
    }

    /**
     * Méthode appelée lorsqu'il y a des changements dans la liste de barres de vie.
     * @param change un objet Change décrivant les changements survenus
     */
    @Override
    public void onChanged(Change<? extends BouleDeFeu> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                for (BouleDeFeu bouleDeFeu : change.getAddedSubList()) {
                    System.out.println("add");
                    bouleDeFeuVue.creerBouleDeFeu(bouleDeFeu);
                }
            }
            if (change.wasRemoved()) {
                for (BouleDeFeu bouleDeFeu : change.getRemoved()) {
                    System.out.println("supp");
                    bouleDeFeuVue.supprimerBouleDeFeu(bouleDeFeu);
                    bouleDeFeuVue.exploserBouleDeFeu(bouleDeFeu);
                }
            }
        }
    }
}