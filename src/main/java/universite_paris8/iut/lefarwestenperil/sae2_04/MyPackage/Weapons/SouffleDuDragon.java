package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Weapons;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants.EtreVivant;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Projectiles.BouleDeFeu;

public class SouffleDuDragon implements Weapon{

    @Override
    public void utilise(EtreVivant etreVivant) {
        BouleDeFeu bouleDeFeu = new BouleDeFeu(etreVivant.getX(), etreVivant.getY(), etreVivant.getDirection(), etreVivant.getEnv());
        etreVivant.getEnv().ajouterProjectile(bouleDeFeu);
        bouleDeFeu.seDeplace();
//        System.out.println("Le souffle du Dragon brûle et inflige "+bouleDeFeu.getDegats()+" points de dégâts.");
    }

    @Override
    public String toString(){
        return "Souffle du Dragon : " + super.toString();
    }
}
