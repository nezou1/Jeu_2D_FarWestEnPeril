package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Link;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;

public class Lasso extends Arme {

    private final Environnement env;
    private final int range;

    public Lasso(Environnement env) {
        super(4, 0);
        this.env = env;
        this.range = 50;
    }


    @Override
    public void attaquer(Personnage attaquant) {
        Link link = env.getLink();
        double distance = Math.sqrt(Math.pow(link.getX() - attaquant.getX(), 2) + Math.pow(link.getY() - attaquant.getY(), 2));
        if (distance <= range) {
            link.recevoirDegats(getPointAttaque());
            System.out.println("Lasso attrape Link et inflige " + getPointAttaque() + " dégâts.");
        }
    }

    @Override
    public String toString() {
        return "Lasso : " + super.toString();
    }
}