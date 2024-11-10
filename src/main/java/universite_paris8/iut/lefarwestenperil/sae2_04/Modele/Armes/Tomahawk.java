
package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;

import java.util.List;

public class Tomahawk extends Arme {

    public Tomahawk() {
        super(7, 50);
    }


    @Override
    public void attaquer(Personnage attaquant) {
        danslaDirectionEnnemis(attaquant.getEnv().getEnnemis(), attaquant);
    }

    public void danslaDirectionEnnemis(List<Ennemi> cibles, Personnage p) {
        for (Personnage cible : cibles) {
            int cibleX = cible.getX();
            int cibleY = cible.getY();
            boolean dansLaDirection;

            dansLaDirection = recevoirDirection(p.getDirection(), cibleX, cibleY, cible);

            if (dansLaDirection) {
                cible.recevoirDegats(getPointAttaque());
                System.out.println("Tomahawk directionnel inflige " + getPointAttaque() + " dégâts à " + cible);
            }
        }
    }

    public boolean recevoirDirection(Direction direction, int cibleX, int cibleY, Personnage p) {
        boolean dansLaDirection = true;
        switch (direction) {
            case DROIT:
                dansLaDirection = (cibleX > p.getX()) && (Math.abs(cibleY - p.getY()) < 32);
                break;
            case BAS:
                dansLaDirection = (cibleY > p.getX()) && (Math.abs(cibleX - p.getY()) < 32);
                break;
            case GAUCHE:
                dansLaDirection = (cibleX < p.getX()) && (Math.abs(cibleY - p.getY()) < 32);
                break;
            case HAUT:
                dansLaDirection = (cibleY < p.getX()) && (Math.abs(cibleX - p.getY()) < 32);
                break;
        }
        return dansLaDirection;
    }


    public String toString() {
        return "Tomahawk : " + super.toString();
    }
}