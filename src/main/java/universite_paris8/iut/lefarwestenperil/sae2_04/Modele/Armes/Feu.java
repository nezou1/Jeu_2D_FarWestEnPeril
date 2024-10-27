package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Link;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles.BouleDeFeu;

import java.util.List;

public class Feu extends Arme {
    private Environnement env;

    public Feu(Environnement env) {
        super(7, 0);
        this.env = env;
    }

    @Override
    public void attaquer(Personnage attaquant, List<Ennemi> cibles) {
        Link link = env.getLink();
        BouleDeFeu bouleDeFeu = new BouleDeFeu(attaquant.getX(), attaquant.getY(), link.getX(), link.getY(), getPointAttaque(), env);
        env.ajouterBouleDeFeu(bouleDeFeu);
        bouleDeFeu.deplacer();
        System.out.println("Feu brûle et inflige " + getPointAttaque() + " dégâts.");
    }

    @Override
    public String toString() {
        return "Feu : " + super.toString();
    }
}
