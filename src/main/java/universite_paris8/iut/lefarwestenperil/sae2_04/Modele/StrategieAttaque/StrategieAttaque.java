package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.EtreVivant;

public interface StrategieAttaque {

    void attaquer(EtreVivant proprietaite);
    String toString();
}
