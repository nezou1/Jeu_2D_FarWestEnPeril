package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Personnage;

public interface StrategieAttaque {

    void attaquer(Personnage proprietaite);
    String toString();
}
