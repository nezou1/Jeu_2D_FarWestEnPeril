package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Personnage;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Utilitaires.Portee;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.StrategieAttaque.LassoW;

public class Cowboy2 extends Ennemi2{

    public Cowboy2(Environnement2 env) {
        super("Cowboy", 200, 200, Direction.NULL, 1, env, 3, 3, new LassoW(), 25, 19, Portee.PORTEECOWBOY, 20, false);
    }
}
