package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

/**
 * La classe Deplacement gère les coordonnées et les déplacements des objets dans le jeu.
 */
public class Deplacement {
    private int x;
    private int y;
    private int tailleTuile;

    public Deplacement(int x, int y, int tailleTuile) {
        this.x = x;
        this.y = y;
        this.tailleTuile = tailleTuile;
    }

    public Deplacement(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void deplacerVers(int deltaX, int deltaY) {
        // Déplace la position selon un delta (déplacement relatif)

        this.x += deltaX;
        this.y += deltaY;
    }

    public int[] getPosition() {
        // Retourne la position actuelle sous forme de tableau [x, y]

        return new int[]{x, y};
    }

    public boolean dansLesLimites(int largeur, int hauteur) {
        // Vérifie si la position est dans les limites spécifiées

        return x >= 0 && x < largeur && y >= 0 && y < hauteur;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void deplacerEnTuiles(int deltaX, int deltaY) {
        // Déplacement de la position en unités de tuiles

        this.x += deltaX * tailleTuile;
        this.y += deltaY * tailleTuile;
    }
}
