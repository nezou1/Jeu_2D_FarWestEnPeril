package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

public class Link extends Personnage {

    public Link(Terrain terrain) {
        super(1600, 1500,16,2,1, terrain);
    }

    public void deplacer(int dx, int dy) {
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

    }

    private boolean estCorrect(int newX, int newY) {
        int tileX = newX / tailleTuile;
        int tileY = newY / tailleTuile;
        int tileXRight = (newX + 25);
        int tileYBottom = (newY + 21);

        return getTerrain().estMarchable(tileX,tileY) &&
                getTerrain().estMarchable(tileXRight,tileY) &&
                getTerrain().estMarchable(tileX,tileYBottom) &&
                getTerrain().estMarchable(tileXRight,tileYBottom);
    }

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
