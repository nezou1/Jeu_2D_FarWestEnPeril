package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;

/**
 * Classe EtreVivant:
 * <p>
 *      Cette classe est une sous-classe de {@link EntiteMobile} qui  s'occupe de la gestion des entités {@code vivantes} de notre jeu.
 * </p>
 *      Elle possède a des {@code points de vie}.
 */

public abstract class EtreVivant extends EntiteMobile {

    private int pointVie;

    public EtreVivant(String id, int x, int y, Direction direction, int vitesse, Environnement env, int pv) {
        super(id,x, y, direction, vitesse, env);
        this.pointVie = pv;
    }

    public int getPointVie() {
        return pointVie;
    }
    public void setPointVie(int pointVie) {
        this.pointVie = pointVie;
    }

}
