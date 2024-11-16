package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires.Portee;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque.Lasso;

public class Cowboy extends Ennemi {

    public Cowboy(Environnement env) {
        super("Cowboy", 200, 200, Direction.NULL, 1, env, 3, 3, new Lasso(), 25, 19, Portee.PORTEECOWBOY, 20, false);
    }
}
