package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Link;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Etats.EtatBrulure;

/**<p>
 * Classe  {@code BouleDeFeu}:
 * <p>
 *     Cette classe est une sous-classe de  {@code Projectile} qui s'occupe de la gestion des  {@code boules de feux}
 * </p>
 * Elle a:
 * <ul>
 *     <li>4 points de {@code vitesse}</li>
 *     <li>50 points de  {@code durabilité}</li>
 *     <li>7 points de  {@code dégats}</li>
 * </ul>
 * Elle peut brûler Link en le touchant
 */
public class BouleDeFeu extends Projectile {


    public BouleDeFeu(int x, int y, Direction direction, Environnement env) {
        super("Bdf",x, y, direction, 4,env, 50,7);
    }

    /**<p>
     * Cette méthode définit l'action d'une boule de feu dans la partie:
     * <ol>
     *     <li>Elle met à jour sa direction ( {@link #updateDir()} )</li>
     *     <li>Elle se déplace  {@link #seDeplace()}</li>
     *     <li>Elle vérifie si elle est proche de Link {@link #distanceAvec(double, double)}</li>
     *     <li>Si elle le trouve, elle le {@code brûle}  ({@link #infligerDegats(Personnage)}  }, {@link #desactivation()} ),
     *     Sinon elle continue sa route et {@code se dégrade}</li>
     * </ol>
     */

    @Override
    public void agit() {
        Link l = getEnv().getLink2();
        this.updateDir();
        seDeplace();
        if (distanceAvec(l.getX(), l.getY()) < getVitesse()) {
            infligerDegats(l);
            desactivation();
        }
        seDegrade();
    }

    /**
     * Cette méthode inflige des dégats à une cible et le {@code brûle}
     * @param cible
     */
    @Override
    public void infligerDegats(Personnage cible) {
        super.infligerDegats(cible);
        cible.ajoutEtat(new EtatBrulure());
    }

    /**
     * Cette méthode met à jour la direction de la boule de feu
     */
    private void updateDir(){
        int linkX = getEnv().getLink2().getX();
        int linkY = getEnv().getLink2().getY();
        int newDx = Integer.compare(linkX, getX()); // compare la coordonnée x de la cible et de la boule de feu => val possibles : -1, 0, 1
        int newDy = Integer.compare(linkY, getY());// idem avec y
        changeDir(newDx, newDy);
    }

    /**<p>
     *  Cette méthpde modifie la direction par rapport à des directions dx et dy
     * </p>
     */
    private void changeDir(int dx, int dy){
        Direction d = getDirection();
        switch (dx){
            case -1:
                if (dy == -1)
                    d = Direction.HAUT_GAUCHE;
                else if (dy == 0)
                    d = Direction.GAUCHE;
                else
                    d = Direction.BAS_GAUCHE;
                break;
            case 0:
                if (dy == -1)
                    d = Direction.HAUT;
                else
                    d = Direction.BAS;
                break;
            case 1:
                if (dy == -1)
                    d = Direction.HAUT_DROIT;
                else if (dy == 0)
                    d = Direction.DROIT;
                else
                    d = Direction.BAS_DROIT;
                break;
        }
        setDirection(d);
    }

    @Override
    public String toString() {
        return "Boule de feu : " + super.toString();
    }
}
