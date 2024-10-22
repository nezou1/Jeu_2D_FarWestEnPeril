package universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles.Fleche;
import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.ArmesVue.FlecheVue;

public class ListObsFleche implements ListChangeListener<Fleche> {

    private final Pane panneauDeJeu;
    private final FlecheVue flecheVue;


    public ListObsFleche(Pane PanneauJeu) {
        this.panneauDeJeu = PanneauJeu;
        this.flecheVue = new FlecheVue(panneauDeJeu);
    }

    /**
     * Méthode appelée lorsqu'il y a des changements dans la liste de barres de vie.
     *
     * @param change un objet Change décrivant les changements survenus
     */
    @Override
    public void onChanged(Change<? extends Fleche> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                for (Fleche f : change.getAddedSubList()) {
                    System.out.println("add");
                    flecheVue.creerFleche(f);
                }
            }
            if (change.wasRemoved()) {
                for (Fleche f : change.getRemoved()) {
                    System.out.println("supp");
                    flecheVue.supprimerFleche(f);
                }
            }
        }
    }
}