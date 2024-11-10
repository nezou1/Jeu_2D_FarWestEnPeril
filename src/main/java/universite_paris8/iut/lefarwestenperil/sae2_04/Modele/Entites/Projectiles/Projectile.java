package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Action;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.EntiteMobile;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;

/**<p>
 * Classe  {@code Projectile}:
 * <p>
 *     Cette classe est une sous-classe de  {@link EntiteMobile} qui s'occupe de la gestion des  {@code projectiles} dans l'{@link Environnement}
 * </p>
 * <p>
 *     Elle implemente l'interface {@link Action} qui permet de faire agir le projectile
 * </p>
 * Elle a:
 * <ul>
 *     <li>une  {@code durabilité}</li>
 *     <li>des  {@code points de dégats}</li>
 * </ul>
 * Elle peut infliger des points de dégats
 * <p>
 * Elle perd de la vie lorsqu'elle se déplace (-1pv)
 *
 */

public abstract class Projectile extends EntiteMobile implements Action {

    private int durabilite;
    private final int degats;

    public Projectile(String id, int x, int y, Direction direction, int vitesse, Environnement env, int durabilite, int degats) {
        super(id,x,y,direction,vitesse,env);
        this.degats = degats;
        this.durabilite = durabilite;
    }

    public int getDegats() {
        return degats;
    }

    public void setDurabilite(int durabilite) {
        this.durabilite = durabilite;
    }
    public boolean isActive(){
        return durabilite > 0;
    }
    public void desactivation(){
        durabilite = 0;
    }

    /** cette méthode gère la décrémentation de la durabilité des projectiles*/
    public void seDegrade(){ // signifie s'épuiser
        int val = durabilite > 0 ? 1 : 0;
        setDurabilite(durabilite - val); // soit -1, soit -0 (pour pas avoir des pv négatifs)
    }

    /** inflige ses dégats à une cible (JSP SI CA DOIT ÊTRE GÉRÉ ICI)*/
    public void infligerDegats(Personnage cible) {
        cible.recevoirDegats(degats);
    }

    /** retoune la {@code distance} entre les coordonnées de la {@code flèche} et de l'{@code ennemi}
     * {@return  double}
     */
    public double distanceAvec(double x, double y){
        return Math.sqrt(Math.pow(x - getX(), 2) + Math.pow(y - getY(), 2));
    }
}