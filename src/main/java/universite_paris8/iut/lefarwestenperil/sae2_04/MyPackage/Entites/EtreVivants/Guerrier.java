package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants;


import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.StrategieAttaque.StrategieAttaque;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Direction;

public abstract class Guerrier extends EtreVivant {

    private final StrategieAttaque arme;

    public Guerrier(String id, int x, int y, Direction direction, int vitesse, Environnement2 env, int pv, int pointDef, StrategieAttaque arme) {
        super(id, x, y, direction, vitesse, env, pv, pointDef);
        this.arme = arme;
    }

    public StrategieAttaque getArme() {
        return arme;
    }

    public void attaquer(){
        arme.attaquer(this);
    }

}
