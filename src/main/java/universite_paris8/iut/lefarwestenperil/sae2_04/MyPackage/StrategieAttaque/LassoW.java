package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.StrategieAttaque;


import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants.EtreVivant;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants.Link2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Utilitaires.Outils;


import static universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Utilitaires.Portee.PORTEELASSO;

public class LassoW implements StrategieAttaque {
    @Override
    public void attaquer(EtreVivant proprietaite) {
        Link2 link = Environnement2.getLink2();
        double distance = Outils.distanceEntre(proprietaite.getX(), proprietaite.getY(),link.getX(),link.getY());
        if (distance <= PORTEELASSO) {
            link.encaisseDegats(4);
//            System.out.println("Lasso attrape Link et inflige 4 dégâts.");
        }
    }

    @Override
    public String toString(){
        return "Lasso : " + super.toString();
    }
}
