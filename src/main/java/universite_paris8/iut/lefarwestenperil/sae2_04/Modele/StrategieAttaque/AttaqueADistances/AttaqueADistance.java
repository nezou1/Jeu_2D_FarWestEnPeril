package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque.AttaqueADistances;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.Projectile;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque.StrategieAttaque;

public abstract class AttaqueADistance implements StrategieAttaque {


    @Override
    public void attaquer(Personnage proprietaite) {
        Projectile projectile = creerProjectile(proprietaite.getX(), proprietaite.getY(), proprietaite.getDirection(),proprietaite.getEnv());
        proprietaite.getEnv().ajouterProjectile(projectile);
        projectile.seDeplace();
    }

    public abstract Projectile creerProjectile(int x, int y, Direction direction, Environnement environnement);
}
