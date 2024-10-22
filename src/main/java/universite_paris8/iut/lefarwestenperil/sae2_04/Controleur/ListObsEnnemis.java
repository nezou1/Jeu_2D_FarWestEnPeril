package universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;


import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.PersonnageVue.EnnemiVue;


public class ListObsEnnemis implements ListChangeListener<Ennemi> {


    private final EnnemiVue ennemisVue;

    public ListObsEnnemis(Pane PanneauJeu) {

        ennemisVue = new EnnemiVue(PanneauJeu);
    }

    @Override
    public void onChanged(Change<? extends Ennemi> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                for (Ennemi e : change.getAddedSubList()) {
                    System.out.println("add");
                    ennemisVue.creerEnnemi(e);
                }
            }
            if (change.wasRemoved()) {
                for (Ennemi e : change.getRemoved()) {
                    System.out.println("supp");
                    ennemisVue.supprimerEnnemi(e);
                }
            }
        }
    }
}