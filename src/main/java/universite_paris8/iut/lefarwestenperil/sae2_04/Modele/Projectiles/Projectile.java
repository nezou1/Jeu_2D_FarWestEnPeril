package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Acteur;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;

/**
 * Classe Projectile:
 *      Cette classe est une sous-classe de EntiteMobile qui s'occupe de la gestion des projectiles dans l'environnement
 *      Elle peut :
 *          - être identifiable
 *          - infliger des dégats
 *          - perdre de la vie à chaque fois qu'elle se déplace (-1pv)
 */

public abstract class Projectile extends Acteur {

    private final String id;
    private static int increment =0;
    private final int degats;
    private final Environnement env;

    public Projectile(int x, int y, int dx, int dy, int vitesse, int pv, int degats, Environnement env) {
        super(x,y,dx,dy,vitesse,pv);
        this.id = "P"+ increment++;
        this.degats = degats;
        this.env = env;
    }

    public String getId() {
        return id;
    }

    public int getDegats() {
        return degats;
    }

    public Environnement getEnv() {
        return env;
    }

    // cette méthode gère la décrémentation de la vie des projectiles
    public void decrementerPv(){
        int val = getPv() > 0 ? 1 : 0; // soit -1, soit 0 (pour pas avoir des pv négatifs)
        setPv(getPv() - val);
    }

    // inflige ses dégats à une cible (JSP SI CA DOIT ÊTRE GÉRÉ ICI)
    public void infligerDegats(Personnage cible) {
        cible.recevoirDegats(degats);
    }
}