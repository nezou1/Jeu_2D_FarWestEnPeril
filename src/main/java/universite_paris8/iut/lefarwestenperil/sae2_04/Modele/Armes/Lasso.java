package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Link;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;


public class Lasso extends Arme {
    private static final int DEGATS_LASSO = 4;
    private static final int PORTEE_LASSO = 50;
    private final Environnement env;

    public Lasso(Environnement env) {
        super(DEGATS_LASSO, 0);
        this.env = env;
    }

    @Override
    public void attaquer(Personnage attaquant) {
        Link link = env.getLink();
        double distance = calculerDistance(attaquant.getX(), attaquant.getY(), link.getX(), link.getY());
        if (distance <= PORTEE_LASSO) {
            link.recevoirDegats(getPointAttaque());
            System.out.println("Lasso attrape Link et inflige " + getPointAttaque() + " dégâts.");
        }
    }

    @Override
    public String toString() {
        return "Lasso : " + super.toString();
    }
}

