package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;

/**
 * Classe Fleche:
 *      Cette classe est une sous-classe de Munitions qui s'occupe de la gestion des flèches du Tir à l'arc
 *      Elle doit :
 *          - pouvoir faire les mêmes choses que sa classe parente + redéfinir ses methodes abstraites
 *          - avoir une vitesse de 10
 *          - infliger 6 points de dégats
 */

public class Fleche extends Munition {

    private final int direction;

    public Fleche(int x, int y, int direction, Environnement env) {
        super(x, y + 10, 6, 10, env);
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    @Override
    public void deplacer() {
        super.deplacer();
        if (hasTouched()) {
            getEnv().removeFleche(this);
            disparait();
        }
//        System.out.println("Flèche se déplace à (" + getX() + ", " + getY() + ")");
    }

    @Override
    public void updatePos() {
        switch (direction) {
            case 0: setX(getX() + getVitesse());break;
            case 1: setY(getY() + getVitesse());break;
            case 2: setX(getX() - getVitesse());break;
            case 3: setY(getY() - getVitesse());break;
        }
    }

    @Override
    public boolean hasTouched() {
        for (Ennemi ennemi : getEnv().getEnnemis()) {
            double centreCibleX = ennemi.getX() + (double) ennemi.getLargeurImage() / 2;
            double centreCibleY = ennemi.getY() + (double) ennemi.getHauteurImage() / 2;
            double distance = Math.sqrt(Math.pow(centreCibleX - getX(), 2) + Math.pow(centreCibleY - getY(), 2));
            if (distance <= 10 || (getX() == centreCibleX && getY() == centreCibleY)){
                ennemi.recevoirDegats(this.getDegats());
                return true;
            }
        }
        return false;
    }
}
