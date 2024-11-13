package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.StrategieAttaque;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants.EtreVivant;

public interface StrategieAttaque {

    void attaquer(EtreVivant proprietaite);
    String toString();
}
