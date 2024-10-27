package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;

import java.util.List;

public class Feu extends Arme {
    private Environnement env;

    public Feu(Environnement env) {
        super(7, 0);
        this.env = env;
    }

    @Override
    public void attaquer(Personnage attaquant, List<Ennemi> cibles) {
//        BouleDeFeu bouleDeFeu = new BouleDeFeu(attaquant.getX(), attaquant.getY(), /*attaquant.getDx(), attaquant.getDy*/,getPointAttaque(), env);
//        env.ajouterProjectile(bouleDeFeu);
//        bouleDeFeu.agit();
        System.out.println("Feu brûle et inflige " + getPointAttaque() + " dégâts.");
    }

    @Override
    public String toString() {
        return "Feu : " + super.toString();
    }
}
