package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

public class Link extends Personnage {

    public Link(Terrain terrain) {
        super(1600, 1500, 16, 2, 1, terrain, 4, 0); // Initialisation de vitesse et direction
    }

    public void deplacer(int dx, int dy) {
        int newX = getX() + dx;
        int newY = getY() + dy;

        if (estCorrect(newX, newY)) {
            setX(newX);
            setY(newY);

            // Mise à jour de la direction
            if (dx > 0) setDirection(0);       // Droite
            else if (dx < 0) setDirection(2);  // Gauche
            if (dy > 0) setDirection(1);       // Bas
            else if (dy < 0) setDirection(3);  // Haut
        } else if (dx != 0 && getX() % tailleTuile < 4) {
            newX = getX() / tailleTuile * tailleTuile + 1;
            setX(newX);
        }
    }

    private boolean estCorrect(int newX, int newY) {
        int tileXRight = newX + 25;
        int tileYBottom = newY + 21;

        // Vérification de la marchabilité des quatre coins autour de la position
        return getTerrain().estMarchable(newY, newX) &&
                getTerrain().estMarchable(newY, tileXRight) &&
                getTerrain().estMarchable(tileYBottom, newX) &&
                getTerrain().estMarchable(tileYBottom, tileXRight);
    }

    // Méthodes de déplacement dans les quatre directions en utilisant `deplacer`
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

    @Override
    public String toString() {
        return "Link : " + super.toString();
    }

}
