package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Weapons;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants.EtreVivant;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Projectiles.Bombe;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;


public class LanceurDeBombes implements Weapon {
    @Override
    public void utilise(EtreVivant etreVivant) {
        Bombe bombe = new Bombe(etreVivant.getX(), etreVivant.getY(), etreVivant.getDirection(), etreVivant.getEnv());
        etreVivant.getEnv().ajouterProjectile(bombe);
        bombe.seDeplace();
    }

    @Override
    public String toString() {
        return "LanceurDeBombes : "+super.toString();
    }
}
