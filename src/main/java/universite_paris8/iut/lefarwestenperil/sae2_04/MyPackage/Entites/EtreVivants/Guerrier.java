package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants;


import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Weapons.Weapon;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Direction;

public abstract class Guerrier extends EtreVivant {

    private final Weapon arme;

    public Guerrier(String id, int x, int y, Direction direction, int vitesse, Environnement2 env, int pv, int pointDef, Weapon arme) {
        super(id, x, y, direction, vitesse, env, pv, pointDef);
        this.arme = arme;
    }

    public Weapon getArme() {
        return arme;
    }

    public void attaquer(){
        arme.attaquer(this);
    }

}
