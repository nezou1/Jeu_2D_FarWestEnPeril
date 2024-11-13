package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Etats;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Personnage;

public class EtatBrulure extends Etat {

    public EtatBrulure() {
        super(30);
    }

    @Override
    public void apply(Personnage personnage) {
        if (getDuree()%10 == 0) {
            personnage.seBlesse(1);
            if (isFinish())
                deactivate();
        }
        decreaseDuree();
    }
}
