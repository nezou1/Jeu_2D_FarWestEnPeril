package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.StrategieAttaque.AttaqueADistances;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants.EtreVivant;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Projectiles.Projectile;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.StrategieAttaque.StrategieAttaque;

public abstract class AttaqueADistance implements StrategieAttaque {


    @Override
    public void attaquer(EtreVivant proprietaite) {
        Projectile projectile = getInstance(proprietaite.getX(), proprietaite.getY(), proprietaite.getDirection(),proprietaite.getEnv());
        proprietaite.getEnv().ajouterProjectile(projectile);
        projectile.seDeplace();
    }

    public abstract Projectile getInstance(int x, int y, Direction direction, Environnement2 environnement);
}
