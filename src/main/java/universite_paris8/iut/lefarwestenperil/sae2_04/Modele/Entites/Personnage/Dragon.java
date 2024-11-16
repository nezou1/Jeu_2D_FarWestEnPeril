package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires.Portee;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque.AttaqueADistances.SouffleDuDragon;

public class Dragon extends Ennemi {

    public Dragon(Environnement env) {
        super("Dragon", 200, 200, Direction.NULL, 2, env, 10, 5, new SouffleDuDragon(), 18, 21, Portee.PORTEEDRAGON, 30, true);
    }
}
