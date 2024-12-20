package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.ActeurMobile;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;

/**
 * <p>
 * Classe  {@code Projectile}:
 * <p>
 * Cette classe est une sous-classe de  {@link ActeurMobile} qui s'occupe de la gestion des  {@code projectiles} dans l'{@link Environnement}
 * </p>
 * Elle a:
 * <ul>
 *     <li>une  {@code durabilité}</li>
 *     <li>des  {@code points de dégats}</li>
 * </ul>
 * Elle peut infliger des points de dégats
 * <p>
 * Elle perd de la vie lorsqu'elle se déplace (-1pv)
 */

public abstract class Projectile extends ActeurMobile {

    private final int degats;
    private int durabilite;

    public Projectile(String id, int x, int y, Direction direction, int vitesse, Environnement env, int durabilite, int degats) {
        super(id, x, y, direction, vitesse, env);
        this.degats = degats;
        this.durabilite = durabilite;
    }

    public int getDegats() {
        return degats;
    }

    public void setDurabilite(int durabilite) {
        this.durabilite = durabilite;
    }

    public boolean isActive() {
        return durabilite > 0;
    }

    public void desactivation() {
        durabilite = 0;
    }

    /**
     * Cette méthode gère la décrémentation de la durabilité des projectiles
     */
    public void seDegrade() { // signifie s'épuiser
        int val = durabilite > 0 ? 1 : 0;
        setDurabilite(durabilite - val); // soit -1, soit -0 (pour pas avoir des pv négatifs)
    }

    /**
     * Inflige les dégats du projectile à une cible
     */
    public void infligerDegats(Personnage cible) {
        cible.encaisseDegats(degats);
    }
}