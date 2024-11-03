package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Deplacement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;

public abstract class Projectile extends Deplacement {
    protected int cibleX, cibleY;
    protected int degats;
    private Environnement env;
    private String id;
    private static int compteur = 0;

    public Projectile(int x, int y, int cibleX, int cibleY, int degats, int vitesse, Environnement env) {
        super(x, y, vitesse, 0); // Appel au constructeur de Deplacement avec vitesse et direction par défaut
        this.cibleX = cibleX;
        this.cibleY = cibleY;
        this.degats = degats;
        this.env = env;
        this.id = "P" + compteur;
        compteur++;
    }

    public String getId() {
        return id;
    }

    public Environnement getEnv() {
        return env;
    }

    public abstract void deplacer();

    public void infligerDegats(Personnage cible) {
        cible.recevoirDegats(degats);
    }

    public int getX(){
        return super.xProperty().get();
    }

    public int getY(){
        return super.yProperty().get();
    }

    public void setX(int x){
        super.xProperty().set(x);
    }
    public void setY(int y){
        super.yProperty().set(y);
    }
}
