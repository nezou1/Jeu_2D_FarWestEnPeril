package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.StrategieAttaque.AttaqueADistances;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Projectiles.Fleche;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Projectiles.Projectile;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;

public class ArcW extends AttaqueADistance {

    public ArcW() {}

    @Override
    public Projectile getInstance(int x, int y, Direction direction, Environnement2 environnement) {
        return new Fleche(x, y, direction, environnement);
    }

    @Override
    public String toString(){
        return "Tir à l'arc : " + super.toString();
    }
}
