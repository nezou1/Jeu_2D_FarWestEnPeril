package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles.Fleche;

import java.util.List;

public class TireALArc extends Arme {
    private Environnement env;

    public TireALArc(Environnement env) {
        super(6, 500);
        this.env = env;
    }

    @Override
    public void attaquer(Personnage attaquant, List<Ennemi> cibles) {
//        Fleche fleche = new Fleche(attaquant.getX(), attaquant.getY()/*attaquant.getDx(), attaquant.getDy()*/, attaquant.getDirection(), env);
//        env.ajouterFleche(fleche);
//        fleche.agit();
        System.out.println("Tire à l'arc touche et inflige " + getPointAttaque() + " dégâts.");
    }

    @Override
    public String toString() {
        return "Tire à l'arc : " + super.toString();
    }
}
