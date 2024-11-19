package universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.BarreDeVie;
import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.VieVue.BarreDeVieVue;

/**
 * La classe ListObsBarreDeVie écoute les changements dans une liste d'objets BarreDeVie.
 * Lorsqu'un objet BarreDeVie est ajouté à la liste, il est affiché sur le panneau de jeu.
 */
public class ListObsBarreDeVie implements ListChangeListener<BarreDeVie> {

    // Vue utilisée pour afficher les barres de vie
    private final BarreDeVieVue barreDeVieVue;
    // Panneau sur lequel les barres de vie seront affichées
    private final Pane panneauDeJeu;

    /**
     * Constructeur pour initialiser ListObsBarreDeVie avec le panneau de jeu donné.
     *
     * @param PanneauJeu le panneau de jeu où les barres de vie seront affichées
     */
    public ListObsBarreDeVie(Pane PanneauJeu) {
        this.panneauDeJeu = PanneauJeu;
        this.barreDeVieVue = new BarreDeVieVue(PanneauJeu);
    }

    /**
     * Méthode appelée lorsqu'il y a des changements dans la liste de barres de vie.
     *
     * @param change un objet Change décrivant les changements survenus
     */
    @Override
    public void onChanged(Change<? extends BarreDeVie> change) {
        // Parcourt toutes les modifications survenues dans la liste
        while (change.next()) {
            // Si des éléments ont été ajoutés
            // Pour chaque élément ajouté, afficher la barre de vie correspondante
            for (BarreDeVie b : change.getAddedSubList()) {
//                System.out.println("add");
                barreDeVieVue.afficherBarreVie(b);
            }
        }
    }
}
