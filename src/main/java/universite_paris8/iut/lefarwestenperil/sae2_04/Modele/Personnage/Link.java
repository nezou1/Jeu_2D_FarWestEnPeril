package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;
//La classe Link est une sous-classe de Personnage représentant le personnage principal du jeu. Elle initialise Link avec des attributs spécifiques.
//La classe implémente des méthodes de déplacement de Link dans les quatre directions, en tenant compte des collisions avec l'environnement.

public class Link extends Personnage {
    private static int hauteur;
    private static int largeur;

    public Link(Terrain terrain) {
        super(1600, 1500,16,2,1, terrain);
        this.hauteur =21;
        this.largeur =25;
    }

   /* public void deplacer(int dx, int dy) {
        int newX = getX() + dx;
        int newY = getY() + dy;

        if (estCorrect(newX, newY)) {
            setX(newX);
            setY(newY);
            if (dx > 0) direction = 0;
            else if (dx < 0) direction = 2;
            if (dy > 0) direction = 1;
            else if (dy < 0) direction = 3;
        } else if (dx != 0 && getX() % tailleTuile < 4) {
            newX = getX() / tailleTuile * tailleTuile + 1;
            setX(newX);
        }

    }*/
   public void deplacer(int dx, int dy) {
       int newX = getX() + dx;
       int newY = getY() + dy;

       if (estPositionValide(newX, newY)) {
           setX(newX);
           setY(newY);
           if (dx > 0) direction = 0;
           else if (dx < 0) direction = 2;
           if (dy > 0) direction = 1;
           else if (dy < 0) direction = 3;
       } else if (dx != 0 && getX() % getTerrain().getTailleTuile() < 4) {
           newX = getX()+ getVitesseDeplacement();
           setX(newX);
       }

   }

   /* private boolean estCorrect(int newX, int newY) {
        int tileX = newX / tailleTuile;
        int tileY = newY / tailleTuile;
        int tileXRight = (newX + 25); // /tailleTuile;
        int tileYBottom = (newY + 21); // /tailleTuile; dans terrain la division

        return getTerrain().estMarchable(tileY, tileX) &&
                getTerrain().estMarchable(tileY, tileXRight) &&
                getTerrain().estMarchable(tileYBottom, tileX) &&
                getTerrain().estMarchable(tileYBottom, tileXRight);
    }*/
   private boolean estPositionValide(int newX, int newY) {
       int tileXRight = (newX + this.largeur);
       int tileYBottom = (newY + this.hauteur);

       return getTerrain().estMarchable(newY, newX) &&
               getTerrain().estMarchable(newY, tileXRight) &&
               getTerrain().estMarchable(tileYBottom,newX) &&
               getTerrain().estMarchable(tileYBottom, tileXRight);
   }
   /* private boolean estCorrect(int newX, int newY) {
       int tileXRight = (newX + this.largeur);
       int tileYBottom = (newY + this.hauteur);'"

       return getTerrain().estMarchable(newY, newX) &&
               getTerrain().estMarchable(newY, tileXRight) &&
               getTerrain().estMarchable(tileYBottom,newX) &&
               getTerrain().estMarchable(tileYBottom, tileXRight);
   }*/
    public void deplacerHaut() {
        deplacer(0, -10);
    }

    public void deplacerBas() {
        deplacer(0, 10);
    }

    public void deplacerGauche() {
        deplacer(-10, 0);
    }

    public void deplacerDroite() {
        deplacer(10, 0);
    }

    public String toString() {
        return "Link : " + super.toString();
    }
}
