package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Utilitaires.PointDeVie;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Weapons.Arsenal;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Weapons.Weapon;

public class Link2 extends Guerrier{

    private boolean move;

    public Link2(int x, int y, Environnement2 env) {
        super("Link", x, y, Direction.NULL, 10, env, PointDeVie.PVLINK, 1, new Arsenal());
        move = false;
    }

    public Link2(Environnement2 env) {
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

    public Weapon getArmeActuelle(){
        return ((Arsenal)getArme()).getArmeActuelle();
    }
    public void setArmeActuelle(Weapon arme){
        ((Arsenal)getArme()).setArmeActuelle(arme);
    }

    public void ajouterArme(Weapon arme){
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