package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.ActeurMobile;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Etats.Etat;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Etats.EtatComposite;

/**
 * Classe Personnage:
 * <p>
 * Cette classe est une sous-classe de {@link ActeurMobile} qui  s'occupe de la gestion des acteurs {@code vivants} de notre jeu.
 * </p>
 * Elle possède des {@code points de vie}.
 */

public abstract class Personnage extends ActeurMobile {

    private final int pointDef;
    private int pointVie;
    private final EtatComposite etat;

    public Personnage(String id, int x, int y, Direction direction, int vitesse, Environnement env, int pv, int def) {
        super(id, x, y, direction, vitesse, env);
        this.pointVie = pv;
        this.pointDef = def;
        etat = new EtatComposite();
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

    public void ajoutEtat(Etat etat) {
        this.etat.ajouterEtat(etat);
    }

    public void seBlesse(int ptsDegats) {
        this.pointVie -= ptsDegats;
    }

    public boolean estVivant() {
        return this.pointVie > 0;
    }

    public void meurt() {
        this.pointVie = 0;
    }

    public void encaisseDegats(int ptsDegats) {
        int degatReel = ptsDegats - pointDef;
        if (degatReel > 0) {
            if (getPointVie() >= degatReel)
                seBlesse(degatReel);
            else
                meurt();
        }
    }

    public void appliquerEtat() {
        if (!this.etat.isVide()) {
            this.etat.apply(this);
        }
    }

    public void appliquerEtat(EtatComposite etat) {

    }
}
