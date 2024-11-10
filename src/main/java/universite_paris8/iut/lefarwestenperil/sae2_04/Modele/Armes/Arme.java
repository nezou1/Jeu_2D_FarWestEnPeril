package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;


public abstract class Arme {
    private final int pointAttaque;
    private final int rayon;

    public Arme(int pointAttaque, int rayon) {
        this.pointAttaque = pointAttaque;
        this.rayon = rayon;
    }

    public int getRayon() {
        return rayon;
    }

    public int getPointAttaque() {
        return this.pointAttaque;
    }

    public abstract void attaquer(Personnage att);


    protected static double calculerDistance(int x1, int y1, int x2, int y2) {
        return Math.hypot(x2 - x1, y2 - y1);
    }

    @Override
    public String toString() {
        return "Arme : pointAttaque=" + pointAttaque;
    }
}