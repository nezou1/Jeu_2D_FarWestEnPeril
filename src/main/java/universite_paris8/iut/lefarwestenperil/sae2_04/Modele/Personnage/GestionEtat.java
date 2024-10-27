package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage;

public class GestionEtat {
    Personnage personnage;
    private static int compteurBrulure;
    private boolean brule;

    public GestionEtat() {
        this.compteurBrulure = 0;
        this.brule = false;
    }
    public Personnage getPersonnage() {
        return personnage;

    }
    public void brulure(Personnage personnage) {//gestion etat
        if (compteurBrulure % 10 == 0) {
            personnage.setPointVie(personnage.getPointVie() - 1);
            if (compteurBrulure == 30) {
                compteurBrulure = 0;
                brule = false;
            }
        }
        compteurBrulure++;
    }
    public boolean isBrule() {
        return this.brule;
    }
    public void setBrule() {
        this.brule = true;
    }

}
