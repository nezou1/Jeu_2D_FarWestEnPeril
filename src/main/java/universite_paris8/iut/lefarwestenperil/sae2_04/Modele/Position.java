package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Classe Position:
 *      Cette classe s'occupe de la gestion de l'emplacement de chaque entité de notre jeu
 *      Elle doit avoir:
 *          - des coordonnées x et y
 *          - une direction
 *          - une vitesse
 *          - un environnement ?
 */
public class Position {
    private final IntegerProperty x;
    private final IntegerProperty y;
    private int direction;
    private int vitesse;
//    private Environnement env;

    public Position(int x, int y, int direction, int vitesse/*, Environnement e*/) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.direction = direction;
        this.vitesse = vitesse;
//        thid.env = e;
    }
    public int getX() {
        return x.get();
    }
    public void setX(int x) {
        this.x.set(x);
    }
    public IntegerProperty xProperty() {
        return x;
    }

    public int getY() {
        return y.get();
    }
    public void setY(int y) {
        this.y.set(y);
    }
    public IntegerProperty yProperty() {
        return y;
    }

    public int getDirection() {
        return direction;
    }
    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getVitesse() {
        return vitesse;
    }
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

//    public Environnement getEnv(){
//        return env;
//    }

}
