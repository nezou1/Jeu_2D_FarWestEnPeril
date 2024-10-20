package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Classe Acteur:
 *      Cette classe s'occupe de la gestion des acteurs de notre jeu
 *      Elle possède:
 *          - des coordonnées x et y
 *          - des directions dx et dy (1,0,-1)
 *          - une vitesse
 *          -des points de vie
 *      Elle peut se déplacer
 *      Elle peut agir
 */

public abstract class Acteur {

    private final IntegerProperty x;
    private final IntegerProperty y;
    private int dx;
    private int dy;
    private int vitesse;
    private int pv;

    public Acteur(int x, int y, int dx, int dy, int vitesse, int pv) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.dx = dx;
        this.dy = dy;
        this.vitesse = vitesse;
        this.pv = pv;
    }

    public int getX() {
        return this.x.getValue();
    }
    public void setX(int x) {
        this.x.setValue(x);
    }
    public IntegerProperty xProperty() {
        return this.x;
    }

    public int getY() {
        return this.y.getValue();
    }
    public void setY(int y) {
        this.y.setValue(y);
    }
    public IntegerProperty yProperty() {
        return this.y;
    }

    public int getDx() {
        return this.dx;
    }
    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return this.dy;
    }
    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getVitesse() {
        return this.vitesse;
    }
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int getPv() {
        return this.pv;
    }
    public void setPv(int pv) {
        this.pv = pv;
    }

    public boolean estEnVie(){
        return this.pv != 0;
    }
    public void meurt(){
        this.pv = 0;
    }

    public void seDeplace(){
        int newX = this.getX() + vitesse * dx ;// soit + vitesse, soit - vitesse, soit + 0 (1,-1,0)
        int newY = this.getY() + vitesse * dy ;// idem
        this.setX(newX);
        this.setY(newY);
    }
    // méthode permettant aux sous-classes de définir leur façon d'agir dans le jeu
    public abstract void agit();

}
