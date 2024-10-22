package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles.Fleche;

public class TireALArc extends Arme {
    private final Environnement env;

    public TireALArc(Environnement env) {
        super(6, 500);
        this.env = env;
    }

    @Override
    public void attaquer(Personnage attaquant) {
        Fleche fleche = new Fleche(attaquant.getX(), attaquant.getY(), attaquant.getDirection(), env);
        env.ajouterFleche(fleche);
        fleche.deplacer();
        System.out.println("Tire à l'arc touche et inflige " + getPointAttaque() + " dégâts.");
    }

    @Override
    public String toString() {
        return "Tire à l'arc : " + super.toString();
    }
}
