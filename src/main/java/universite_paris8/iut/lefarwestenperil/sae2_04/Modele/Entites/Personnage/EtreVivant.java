package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.ActeurMobile;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Etats.Etat;

/**
 * Classe EtreVivant:
 * <p>
 *      Cette classe est une sous-classe de {@link ActeurMobile} qui  s'occupe de la gestion des acteurs {@code vivants} de notre jeu.
 * </p>
 *      Elle possède des {@code points de vie}.
 */

public abstract class EtreVivant extends ActeurMobile {

    private int pointVie;
    private final int pointDef;
    private Etat etat;

    public EtreVivant(String id, int x, int y, Direction direction, int vitesse, Environnement env, int pv, int def) {
        super(id,x, y, direction, vitesse, env);
        this.pointVie = pv;
        this.pointDef = def;
        etat = null;
    }

    public int getPointVie() {
        return pointVie;
    }
    public void setPointVie(int pointVie) {
        this.pointVie = pointVie;
    }

    public int getPointDef() {
        return pointDef;
    }

    public Etat getEtat() {
        return etat;
    }
    public void setEtat(Etat etat) {
        if (this.etat == null)
            this.etat = etat;
    }

    public void seBlesse(int ptsDegats) {
        this.pointVie -= ptsDegats;
    }
    public boolean estVivant() {
        return this.pointVie > 0;
    }
    public void meurt(){
        this.pointVie = 0;
    }

    public void encaisseDegats(int ptsDegats){
        int degatReel = ptsDegats - pointDef;
//        System.out.println("degat reel :" + degatReel);
        if (degatReel > 0) {
            if (getPointVie() >= degatReel)
                seBlesse(degatReel);
            else
                meurt();
        }
//        System.out.println(getPointVie());
    }

    public void appliquerEtat() {
        if(etat != null){
            etat.apply(this);
            if (etat.isFinish())
                etat = null;
        }
    }
}
