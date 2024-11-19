package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque.StrategieAttaque;

public abstract class Guerrier extends Personnage {

    private final StrategieAttaque arme;

    public Guerrier(String id, int x, int y, Direction direction, int vitesse, Environnement env, int pv, int pointDef, StrategieAttaque arme) {
        super(id, x, y, direction, vitesse, env, pv, pointDef);
        this.arme = arme;
    }

    public StrategieAttaque getArme() {
        return arme;
    }

    public void attaquer() {
        arme.attaquer(this);
    }

}
