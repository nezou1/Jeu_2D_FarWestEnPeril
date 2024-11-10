package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Link;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles.BouleDeFeu;


public class Feu extends Arme {
    private static final int DEGATS_FEU = 7;
    private final Environnement env;

    public Feu(Environnement env) {
        super(DEGATS_FEU, 0);
        this.env = env;
    }

    @Override
    public void attaquer(Personnage attaquant) {
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
