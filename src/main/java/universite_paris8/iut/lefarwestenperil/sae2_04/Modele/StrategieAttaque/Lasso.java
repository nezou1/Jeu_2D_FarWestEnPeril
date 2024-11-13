package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque;


import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Link2;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires.Outils;


import static universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires.Portee.PORTEELASSO;

public class Lasso implements StrategieAttaque {
    @Override
    public void attaquer(Personnage proprietaite) {
        Link2 link = Environnement.getLink2();
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
