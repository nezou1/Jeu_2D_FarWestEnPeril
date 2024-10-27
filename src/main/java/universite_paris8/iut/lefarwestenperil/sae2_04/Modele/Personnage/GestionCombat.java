package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage;

import java.util.List;

public class GestionCombat {
    Personnage personnage;
    public GestionCombat(Personnage personnage) {
        this.personnage = personnage;
    }
    public void attaque(List<Ennemi> cibles) {
        if (personnage.getGestionArme().getArme() != null) {
            personnage.getGestionArme().getArme().attaquer(personnage, cibles);
        } else {
            System.out.println("Aucune arme pour l'attaque.");
        }
    }
    public void recevoirDegats(int pointsDegats) {
        int degatReel = pointsDegats - personnage.getPointDefense();
        if (degatReel > 0) {
            if (personnage.getPointVie() >= degatReel) {
                personnage.setPointVie(personnage.getPointVie() - degatReel);

            }
        }
    }
}
