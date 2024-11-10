package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Link;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.BouleDeFeu;

public class Feu extends Arme {
    private final Environnement env;

    public Feu(Environnement env) {
        super(7, 0);
        this.env = env;
    }

    @Override
    public void attaquer(Personnage attaquant) {
        // la on prend link on crée une boule de feu et on la fait deplacer jusqua link mdrrr weee
        Link link = env.getLink();
//        BouleDeFeu bouleDeFeu = new BouleDeFeu(attaquant.getX(), attaquant.getY(), link.getDirection(), env);
//        env.ajouterProjectile(bouleDeFeu);
//        bouleDeFeu.seDeplace();
        System.out.println("Feu brûle et inflige " + getPointAttaque() + " dégâts.");
    }

    @Override
    public String toString() {
        return "Feu : " + super.toString();
    }
}