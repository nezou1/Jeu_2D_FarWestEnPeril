package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque.AttaqueADistances;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.Fleche;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.Projectile;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;

public class Arc extends AttaqueADistance {

    public Arc() {
    }

    @Override
    public Projectile creerProjectile(int x, int y, Direction direction, Environnement environnement) {
        return new Fleche(x, y, direction, environnement);
    }

    @Override
    public String toString() {
        return "Tir à l'arc : " + super.toString();
    }
}
