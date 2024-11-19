package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Etats;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Personnage;

import java.util.ArrayList;


public class EtatComposite extends Etat {

    private final ArrayList<Etat> etats;

    public EtatComposite() {
        super(0); // Durée globale non applicable ici
        this.etats = new ArrayList<>();
    }

    public void ajouterEtat(Etat etat) {
        if (!etatExistant(etat)) {
            etats.add(etat);
        }
    }

    public void supprimerEtat(Etat etat) {
        etats.remove(etat);
    }

    @Override
    public void apply(Personnage personnage) {
        for (Etat etat : etats) {
            etat.apply(personnage);
            if (etat.isFinish()) {
                etat.deactivate();
                this.supprimerEtat(etat);
            }
        }
    }

    public boolean etatExistant(Etat etat) {
        for (Etat e : etats) {
            if (e.getClass().equals(etat.getClass())) {
                return true;
            }
        }
        return false;
    }

    public boolean isVide() {
        return etats.isEmpty();
    }
}
