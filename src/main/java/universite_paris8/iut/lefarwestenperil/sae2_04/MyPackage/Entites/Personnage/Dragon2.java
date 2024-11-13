package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Personnage;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Utilitaires.Portee;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.StrategieAttaque.AttaqueADistances.SouffleDuDragon;

public class Dragon2 extends Ennemi2{

    public Dragon2(Environnement2 env) {
        super("Dragon", 200, 200, Direction.NULL, 2, env, 10, 5, new SouffleDuDragon(), 18, 21, Portee.PORTEEDRAGON, 30, true);
    }
}
