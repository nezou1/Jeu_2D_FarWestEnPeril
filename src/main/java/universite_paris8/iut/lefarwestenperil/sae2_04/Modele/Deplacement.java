package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Direction;

/**
 * La classe Deplacement gère uniquement les coordonnées et les déplacements basiques des objets dans le jeu
 * en utilisant IntegerProperty pour une intégration facile avec JavaFX.
 */
public class Deplacement {
    private IntegerProperty x;
    private IntegerProperty y;
    private int vitesse;     // La vitesse de déplacement de l'objet
    private Direction direction;

    // Constructeur initialisant les propriétés de position
    public Deplacement(int x, int y, int vitesse, Direction direction) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.vitesse = vitesse;
        this.direction = direction;
    }

    // Accesseurs pour les propriétés x et y (nécessaire pour JavaFX)
    public IntegerProperty xProperty() {
        return x;
    }

    public IntegerProperty yProperty() {
        return y;
    }

    // Méthode pour mettre à jour la position directement
    public void setPosition(int x, int y) {
        this.x.set(x);
        this.y.set(y);
    }

    // Méthode pour déplacer en fonction d'un delta
    public void deplacerVers(int deltaX, int deltaY) {
        this.x.set(this.x.get() + deltaX);
        this.y.set(this.y.get() + deltaY);
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    // Gestion de la direction
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
