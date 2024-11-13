package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Weapons;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants.EtreVivant;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Projectiles.Bombe;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;


public class LanceurDeBombes implements Weapon {
    @Override
    public void attaquer(EtreVivant proprietaite) {
        Bombe bombe = new Bombe(proprietaite.getX(), proprietaite.getY(), proprietaite.getDirection(), proprietaite.getEnv());
        proprietaite.getEnv().ajouterProjectile(bombe);
        bombe.seDeplace();
    }

    @Override
    public String toString() {
        return "LanceurDeBombes : "+super.toString();
    }
}
