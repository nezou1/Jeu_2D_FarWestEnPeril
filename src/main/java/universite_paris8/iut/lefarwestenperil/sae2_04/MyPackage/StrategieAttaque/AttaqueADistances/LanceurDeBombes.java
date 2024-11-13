package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.StrategieAttaque.AttaqueADistances;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Projectiles.Bombe;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Projectiles.Projectile;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;


public class LanceurDeBombes extends AttaqueADistance {

    @Override
    public Projectile getInstance(int x, int y, Direction direction, Environnement2 environnement) {
        return new Bombe(x, y, direction, environnement);
    }

    @Override
    public String toString() {
        return "LanceurDeBombes : "+super.toString();
    }
}
