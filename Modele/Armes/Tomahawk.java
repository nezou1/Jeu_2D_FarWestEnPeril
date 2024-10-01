package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;

import java.util.List;

public class Tomahawk extends Arme {

    public Tomahawk() {
        super(7, 50);
    }


    @Override
    public void attaquer(Personnage attaquant, List<Ennemi> cibles) {
        int direction = attaquant.getDirection();
        int attaquantX = attaquant.getX();
        int attaquantY = attaquant.getY();
        int rayon = 32;

        for (Personnage cible : cibles) {
            int cibleX = cible.getX();
            int cibleY = cible.getY();
            boolean dansLaDirection = false;

            switch (direction) {
                case 0:
                    dansLaDirection = (cibleX > attaquantX) && (Math.abs(cibleY - attaquantY) < rayon);
                    break;
                case 1:
                    dansLaDirection = (cibleY > attaquantY) && (Math.abs(cibleX - attaquantX) < rayon);
                    break;
                case 2:
                    dansLaDirection = (cibleX < attaquantX) && (Math.abs(cibleY - attaquantY) < rayon);
                    break;
                case 3:
                    dansLaDirection = (cibleY < attaquantY) && (Math.abs(cibleX - attaquantX) < rayon);
                    break;
            }

            if (dansLaDirection) {
                cible.recevoirDegats(getPointAttaque());
                System.out.println("Tomahawk directionnel inflige " + getPointAttaque() + " dégâts à " + cible);
            }
        }
    }

    public String toString() {
        return "Tomahawk : " + super.toString();
    }
}
