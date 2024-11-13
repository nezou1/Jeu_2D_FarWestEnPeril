package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.PNJs;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Acteur;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;

public abstract class PNJ extends Acteur {

    private final int x;
    private final int y;

    public PNJ(String id, Environnement2 env, int x, int y) {
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
