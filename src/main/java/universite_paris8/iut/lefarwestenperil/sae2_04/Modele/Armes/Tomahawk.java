package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;

import java.util.List;


public class Tomahawk extends Arme {
    private static final int DEGATS_TOMAHAWK = 7;
    private static final int RAYON_TOMAHAWK = 50;

    public Tomahawk() {
        super(DEGATS_TOMAHAWK, RAYON_TOMAHAWK);
    }

    @Override
    public void attaquer(Personnage attaquant) {
        dansLaDirectionEnnemis(attaquant.getEnv().getEnnemis(), attaquant);
    }

    private void dansLaDirectionEnnemis(List<Ennemi> cibles, Personnage p) {
        for (Personnage cible : cibles) {
            if (estDansLaDirection(p, cible)) {
                cible.recevoirDegats(getPointAttaque());
                System.out.println("Tomahawk directionnel inflige " + getPointAttaque() + " dégâts à " + cible);
            }
        }
    }

    private boolean estDansLaDirection(Personnage attaquant, Personnage cible) {
        int direction = attaquant.getDirection();
        int cibleX = cible.getX();
        int cibleY = cible.getY();
        int attaquantX = attaquant.getX();
        int attaquantY = attaquant.getY();

        return switch (direction) {
            case 0 -> (cibleX > attaquantX) && (Math.abs(cibleY - attaquantY) < 32);
            case 1 -> (cibleY > attaquantY) && (Math.abs(cibleX - attaquantX) < 32);
            case 2 -> (cibleX < attaquantX) && (Math.abs(cibleY - attaquantY) < 32);
            case 3 -> (cibleY < attaquantY) && (Math.abs(cibleX - attaquantX) < 32);
            default -> false;
        };
    }

    @Override
    public String toString() {
        return "Tomahawk : " + super.toString();
    }
}
