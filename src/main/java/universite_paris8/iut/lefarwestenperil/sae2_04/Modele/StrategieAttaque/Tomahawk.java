package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Personnage;

import static universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires.Portee.PORTEETOMAHAWK;


public class Tomahawk implements StrategieAttaque {
    @Override
    public void attaquer(Personnage proprietaite) {
        for (Personnage cible : proprietaite.getEnv().getEnnemis()) {
            int cibleX = cible.getX();
            int cibleY = cible.getY();
            boolean dansLaDirection;
            dansLaDirection = recevoirDirection(proprietaite.getDirection(), proprietaite.getX(), proprietaite.getY(), cibleX, cibleY);
            if (dansLaDirection) {
                cible.encaisseDegats(7);
                System.out.println("Tomahawk directionnel inflige 7 dégâts à " + cible);
            }
        }
    }

    private boolean recevoirDirection(Direction direction, int attaquantX, int attaquantY, int cibleX, int cibleY) {
        return switch (direction) {
            case DROIT -> (cibleX > attaquantX) && (Math.abs(cibleY - attaquantY) < PORTEETOMAHAWK);
            case GAUCHE -> (cibleY > attaquantX) && (Math.abs(cibleX - attaquantY) < PORTEETOMAHAWK);
            case BAS -> (cibleX < attaquantX) && (Math.abs(cibleY - attaquantY) < PORTEETOMAHAWK);
            case HAUT -> (cibleY < attaquantY) && (Math.abs(cibleX - attaquantX) < PORTEETOMAHAWK);
            default -> false;
        };
    }

    @Override
    public String toString() {
        return "Tomahawk : " + super.toString();
    }
}
