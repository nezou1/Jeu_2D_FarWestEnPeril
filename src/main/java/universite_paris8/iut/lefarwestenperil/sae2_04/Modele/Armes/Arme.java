package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Ennemi;

import java.util.List;

public abstract class Arme {
    private int pointAttaque;
    private int rayon;

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

    public String toString() {
        return "Arme :  pointAttaque " + pointAttaque;
    }
}