package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque.AttaqueADistances;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.Bombe;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.Projectile;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;


public class LanceurDeBombes extends AttaqueADistance {

    @Override
    public Projectile getInstance(int x, int y, Direction direction, Environnement environnement) {
        return new Bombe(x, y, direction, environnement);
    }

    @Override
    public String toString() {
        return "LanceurDeBombes : "+super.toString();
    }
}
