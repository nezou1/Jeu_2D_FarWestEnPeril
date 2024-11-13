package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Weapons;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants.EtreVivant;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Projectiles.Fleche;

public class ArcW implements Weapon{

    @Override
    public void attaquer(EtreVivant proprietaite) {
        Fleche fleche = new Fleche(proprietaite.getX(), proprietaite.getY(), proprietaite.getDirection(), proprietaite.getEnv());
        proprietaite.getEnv().ajouterProjectile(fleche);
        fleche.seDeplace();
//        System.out.println("Tir à l'arc touche et inflige " + fleche.getDegats() + " dégâts.");
    }

    @Override
    public String toString(){
        return "Tir à l'arc : " + super.toString();
    }
}
