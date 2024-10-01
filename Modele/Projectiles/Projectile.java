package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;

public abstract class Projectile {
    protected IntegerProperty x, y;
    protected int cibleX, cibleY;
    protected int degats;
    protected int vitesse;
    private Environnement env;
    private String id;
    private static int compteur =0;

    public Projectile(int x, int y, int cibleX, int cibleY, int degats, int vitesse, Environnement env) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.cibleX = cibleX;
        this.cibleY = cibleY;
        this.degats = degats;
        this.vitesse = vitesse;
        this.env = env;
        this.id = "P"+compteur;
        compteur++;
    }

    public String getId() {
        return id;
    }


    public IntegerProperty xProperty(){
        return x;

    }

    public IntegerProperty yProperty(){
        return y;
    }

    public int getX(){
        return x.get();
    }

    public int getY(){
        return y.get();
    }

    public void setX(int x) {
        this.x.set(x);
    }

    public void setY(int y) {
        this.y.set(y);
    }

    public Environnement getEnv() {
        return env;
    }

    public int getCibleX() {
        return cibleX;
    }

    public int getCibleY() {
        return cibleY;
    }

    public int getDegats() {
        return degats;
    }

    public int getVitesse() {
        return vitesse;
    }

    public abstract void deplacer();

    public void infligerDegats(Personnage cible) {
        cible.recevoirDegats(degats);
    }
}