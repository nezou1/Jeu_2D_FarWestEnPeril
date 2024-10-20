package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Link;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;

/**
 * Classe BouleDeFeu:
 *      Cette classe est une sous-classe de Projectiles qui s'occupe de la gestion des boules de feux
 *      Son objectif est de poursuivre Link pour lui infliger des brûlures.
 *      Elle a:
 *          - 4 points de vitesses
 *          - 50 points de vie
 *          - 7 points de dégats
 *      Elle doit connaître Link
 *      Elle peut :
 *          - brûler Link en le touchant (modification de la méthode infligerDegats())
 */

public class BouleDeFeu extends Projectile {

    private final Link link;

    public BouleDeFeu(int x, int y, int dx, int dy, Environnement env) {
        super(x, y, dx, dy, 4, 50,7,env);
        link = getEnv().getLink();
    }

    @Override
    public void agit() {
        this.updatePos();
        seDeplace();
        if (aToucheLink()) {
            infligerDegats(link);
            meurt();
        }
        decrementerPv();
    }

    @Override
    public void infligerDegats(Personnage cible) {
        super.infligerDegats(cible);
        getEnv().ajouterBrulure();
    }

    // met à jour la direction de la boule de feu
    private void updatePos(){
        int newDx = Integer.compare(link.getX(), getX()); // compare les coordonnées de la cible et de la boule de feu => val possibles : 1, 0, -1
        int newDy = Integer.compare(link.getY(), getY());// idem
        setDx(newDx);
        setDy(newDy);
    }

    // vérifie si elle a touché Link
    public boolean aToucheLink() {
        int cibleY = link.getY();
        int cibleX = link.getX();
        return Math.abs(getX() - cibleX) < getVitesse() && Math.abs(getY() - cibleY) < getVitesse(); // retourne vrai si Link se trouve dans un rayon égale à la vitesse de la boule de feu
    }
}
