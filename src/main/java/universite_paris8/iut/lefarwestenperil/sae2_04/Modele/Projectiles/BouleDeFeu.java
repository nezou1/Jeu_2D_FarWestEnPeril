package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;

/**
 * Classe BouleDeFeu:
 *      Cette classe est une sous-classe de Munitions qui s'occupe de la gestion des boules de feux de l'arme Feu
 *      Son objectif est de poursuivre Link pour lui infliger des brûlures
 *      Elle doit :
 *          - pouvoir faire les mêmes choses que sa classe parente + redéfinir ses methodes abstraites
 *          - brûler Link en le touchant (modification de la méthode infligerDegats())
 *          - avoir une vitesse de 4
 *          - infliger 7 points de dégats (pour l'instant c'est mal fait)
 */

public class BouleDeFeu extends Munition {

    public BouleDeFeu(int x, int y, int degats, Environnement env) {
        super(x, y, degats, 4, env);
        setBouge(true);
    }

    @Override
    public void deplacer() {
        updatePos();
        if (hasTouched()) {
            infligerDegats(getEnv().getLink());
            disparait();
        }
    }

    @Override
    public void infligerDegats(Personnage cible) {
        super.infligerDegats(cible);
        getEnv().ajouterBrulure();
    }

    @Override
    public void updatePos(){
        int cibleX = getEnv().getLink().getX();
        int cibleY = getEnv().getLink().getY();
        int newX = (cibleX > getX()) ? getX() + getVitesse() : getX() - getVitesse();
        int newY = (cibleY > getY()) ? getY() + getVitesse() : getY() - getVitesse();
        setX(newX);
        setY(newY);
    }

    @Override
    public boolean hasTouched() {
        int cibleX = getEnv().getLink().getX();
        int cibleY = getEnv().getLink().getY();
        return Math.abs(getX() - cibleX) < getVitesse() && Math.abs(getY() - cibleY) < getVitesse();
    }
}
