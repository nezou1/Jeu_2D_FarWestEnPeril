package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;

/**
 * Classe Munition:
 *      Cette classe s'occupe de la gestion des munitions des armes à distances(Feu, TirALARc, etc...)
 *      Elle doit :
 *          - être identifiable
 *          - savoir sa position
 *          - savoir dans quel environnement elle se trouve
 *          - pouvoir infliger des dégats
 */

public abstract class Munition {
    private final String id;
    private static int compteur =0;

    private final IntegerProperty x, y;
    private final int degats;
    private final int vitesse;
    private final Environnement env;

    private boolean bouge;
    private final int tourDeCreation;

    public Munition(int x, int y, int degats, int vitesse, Environnement env) {
        this.id = "P"+compteur++;
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.degats = degats;
        this.vitesse = vitesse;
        this.env = env;
        this.bouge = true;
        this.tourDeCreation = env.getTours();
    }

    public String getId() {
        return id;
    }

    public int getX(){
        return x.get();
    }
    public void setX(int x) {
        this.x.setValue(x);
    }
    public IntegerProperty xProperty(){
        return x;
    }

    public int getY(){
        return y.get();
    }
    public void setY(int y) {
        this.y.setValue(y);
    }
    public IntegerProperty yProperty(){
        return y;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getDegats() {
        return degats;
    }

    public boolean enTrainDeBouger() {
        return bouge;
    }
    public void setBouge(boolean bouge) {
        this.bouge = bouge;
    }
    public void disparait(){
        bouge = false;
    }

    public Environnement getEnv() {
        return env;
    }

    public int getTourDeCreation() {
        return tourDeCreation;
    }

    public abstract void updatePos();

    public void deplacer() {
        this.updatePos();
    }

    public abstract boolean hasTouched();

    public void infligerDegats(Personnage cible) {
        cible.recevoirDegats(degats);
    }
}