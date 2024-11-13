package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Projectiles;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.ActeurMobile;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants.EtreVivant;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;

/**<p>
 * Classe  {@code Projectile}:
 * <p>
 *     Cette classe est une sous-classe de  {@link Acteur} qui s'occupe de la gestion des  {@code projectiles} dans l'{@link Environnement2}
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

public abstract class Projectile extends ActeurMobile {

    private int durabilite;
    private final int degats;

    public Projectile(String id, int x, int y, Direction direction, int vitesse, Environnement2 env, int durabilite, int degats) {
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

    /** inflige ses dégats à une cible */
    public void infligerDegats(EtreVivant cible) {
        cible.encaisseDegats(degats);
    }
}