package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires.PointDeVie;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque.Arsenal;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque.StrategieAttaque;

public class Link extends Guerrier{

    private boolean move;

    public Link(int x, int y, Environnement env) {
        super("Link", x, y, Direction.NULL, 10, env, PointDeVie.PVLINK, 1, new Arsenal());
        move = false;
    }

    public Link(Environnement env) {
        super("Link", 1600, 1500, Direction.NULL, 10, env, PointDeVie.PVLINK, 1, new Arsenal());
    }

    public void deplacerHaut() {
        move = true;
        setDirection(Direction.HAUT);
    }
    public void deplacerBas() {
        move = true;
        setDirection(Direction.BAS);
    }
    public void deplacerGauche() {
        move = true;
        setDirection(Direction.GAUCHE);
    }
    public void deplacerDroite() {
        move = true;
        setDirection(Direction.DROIT);
    }
    public void noWalking() {
        move = false;
    }

    public StrategieAttaque getArmeActuelle(){
        return ((Arsenal)getArme()).getArmeActuelle();
    }
    public void setArmeActuelle(StrategieAttaque arme){
        ((Arsenal)getArme()).setArmeActuelle(arme);
    }

    public void ajouterArme(StrategieAttaque arme){
        ((Arsenal)getArme()).ajouterArme(arme);
    }

    public void changerArmeSuivante() {
        ((Arsenal)getArme()).armeSuivante();
    }
    public void changerArmePrecedente() {
        ((Arsenal)getArme()).armePrecedente();
    }

    @Override
    public void seDeplace(){
        if (move)
            super.seDeplace();
    }

    @Override
    public void agit() {
        appliquerEtat();
        this.seDeplace();
    }
    @Override
    public String toString() {
        return "Link : ";
    }
}