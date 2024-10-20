package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;

/**
 * Classe Fleche:
 *      Cette classe est une sous-clsse de Projectile qui s'occupe de la gestion des flèches
 *      Elle a :
 *          - 10 points de vitesses
 *          - 15 points de vie
 *          - 6 points de dégats
 */

public class Fleche extends Projectile {

    public Fleche(int x, int y, int dx, int dy, Environnement env) {
        super(x, y + 10, dx, dy, 10, 15,6,env);
    }

    @Override
    public void agit() {
        seDeplace();
        Ennemi e = chercheEnnemi();
        if (e != null) {
            infligerDegats(e);
            meurt();
        }
        System.out.println("Flèche se déplace à (" + getX() + ", " + getY() + ")");
        decrementerPv();
    }

    // retourne un ennemi si celui-ci se trouve à 10 pixels devant lui
    private Ennemi chercheEnnemi(){
        Ennemi ennemi = null;
        for (Ennemi e : getEnv().getEnnemis()) {
            assert false;
            double centreCibleX = e.getX() + (double) e.getLargeurImage() / 2;
            double centreCibleY = e.getY() + (double) e.getHauteurImage() / 2;
            if (distanceAvec(centreCibleX,centreCibleY) <= 10)// mettre la valeur 10 dans une constante
                ennemi = e;
        }
        return ennemi;
    }

    // retoune la distance (en double) entre la flèche et les coordonnées de l'ennemi
    private double distanceAvec(double x, double y){
        return Math.sqrt(Math.pow(x - getX(), 2) + Math.pow(y - getY(), 2));
    }
}
