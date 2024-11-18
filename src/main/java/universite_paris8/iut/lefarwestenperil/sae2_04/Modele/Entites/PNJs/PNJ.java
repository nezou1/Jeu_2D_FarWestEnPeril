package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.PNJs;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Acteur;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Entite;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;

public abstract class PNJ extends Entite {

    private final int x;
    private final int y;

    public PNJ(String id, Environnement env, int x, int y) {
        super(id,env);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
