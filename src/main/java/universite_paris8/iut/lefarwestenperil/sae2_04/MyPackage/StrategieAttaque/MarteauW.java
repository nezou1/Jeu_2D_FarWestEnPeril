package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.StrategieAttaque;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Personnage.EtreVivant;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Personnage.Link2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;


public class MarteauW implements StrategieAttaque {

    @Override
    public void attaquer(EtreVivant proprietaite) {
        Link2 link = Environnement2.getLink2();
        int x = (link.getX() + 11) / 32;
        int y = (link.getY() + 13) / 32;

        switch (link.getDirection()) {
            case DROIT:
                ++x;
                break;
            case BAS:
                ++y;
                break;
            case GAUCHE:
                --x;
                break;
            case HAUT:
                --y;
                break;
        }
        int[][] tab = proprietaite.getEnv().getTerrain().getDonneeTerrain();
        if (tab[y][x] == 3)
            tab[y][x] = 0;
    }

    @Override
    public String toString() {
        return "Marteau : " + super.toString();
    }
}
