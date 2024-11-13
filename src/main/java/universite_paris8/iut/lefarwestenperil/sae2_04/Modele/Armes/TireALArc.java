
package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Projectiles.Fleche;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;

public class TireALArc extends Arme {
    private final Environnement2 env;

    public TireALArc(Environnement2 env) {
        super(6, 500);
        this.env = env;
    }

    @Override
    public void attaquer(Personnage attaquant) {
        Fleche fleche = new Fleche(attaquant.getX(), attaquant.getY(), attaquant.getDirection(), env);
        env.ajouterProjectile(fleche);
        fleche.seDeplace();
        System.out.println("Tire à l'arc touche et inflige " + getPointAttaque() + " dégâts.");
    }

    @Override
    public String toString() {
        return "Tire à l'arc : " + super.toString();
    }
}
