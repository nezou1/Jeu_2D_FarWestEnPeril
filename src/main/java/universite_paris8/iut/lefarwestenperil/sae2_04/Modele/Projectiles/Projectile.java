package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;

public abstract class Projectile {
    private static int compteur = 0;
    private final Environnement env;
    private final String id;
    protected IntegerProperty x, y;
    protected int cibleX, cibleY;
    protected int degats;
    protected int vitesse;

    public Projectile(int x, int y, int cibleX, int cibleY, int degats, int vitesse, Environnement env) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.cibleX = cibleX;
        this.cibleY = cibleY;
        this.degats = degats;
        this.vitesse = vitesse;
        this.env = env;
        this.id = "P" + compteur;
        compteur++;
    }

    public String getId() {
        return id;
    }


    public IntegerProperty xProperty() {
        return x;

    }

    public IntegerProperty yProperty() {
        return y;
    }

    public int getX() {
        return x.get();
    }

    public void setX(int x) {
        this.x.set(x);
    }

    public int getY() {
        return y.get();
    }

    public void setY(int y) {
        this.y.set(y);
    }

    public Environnement getEnv() {
        return env;
    }

    public abstract void deplacer();

    public void infligerDegats(Personnage cible) {
        cible.recevoirDegats(degats);
    }
}