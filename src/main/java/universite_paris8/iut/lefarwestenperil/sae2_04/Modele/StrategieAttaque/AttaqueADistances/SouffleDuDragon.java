package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque.AttaqueADistances;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.BouleDeFeu;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.Projectile;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;

public class SouffleDuDragon extends AttaqueADistance {

    @Override
    public Projectile creerProjectile(int x, int y, Direction direction, Environnement environnement) {
        return new BouleDeFeu(x, y, direction, environnement);
    }

    @Override
    public String toString() {
        return "Souffle du Dragon : " + super.toString();
    }
}
