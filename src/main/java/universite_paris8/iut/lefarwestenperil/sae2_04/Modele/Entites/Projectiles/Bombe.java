package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Portee;


import java.util.ArrayList;

/**<p>
 * Classe  {@code Bombe}:
 * <p>
 *     Cette classe est une sous-classe de  {@code Projectile} qui s'occupe de la gestion des  {@code bombes}
 * </p>
 * Elle a:
 * <ul>
 *     <li>7 points de {@code vitesse} initial</li>
 *     <li>7 points de  {@code durabilité}</li>
 *     <li>20 points de  {@code dégats}</li>
 *     <li>une  {@code portée} de 400 pixels (ou 64 jsp)</li>
 * </ul>
 * Elle peut infliger des {@code dégats de zones} (peut blesser {@code plusieurs ennemis} en même temps)
 */

public class Bombe extends Projectile {


    public Bombe(int x, int y, Direction direction, Environnement env) {
        super("Bomb",x,y,direction,7,env,7,20);
    }

    /**<p>
     * Cette méthode définit l'action d'une bombe dans la partie:
     * <ol>
     *     <li>Elle vérifie si une autre bombe est en cours ( {@link #isActive} )</li>
     *     <li>Elle se déplace {@link #seDeplace()}</li>
     *     <li>Elle cherche des ennemis autour d'elle {@link #chercheEnnemis()}</li>
     *     <li>Si elle en trouve au moins un, elle {@code explose} ({@link #explosion()}, {@link #desactivation()} ),
     *     Sinon elle continue sa route, {@code se dégrade} et {@code ralentit}</li>
     * </ol>
     */
    @Override
    public void agit() {
        if (isActive()) {
            System.out.println("Une bombe est déjà en cours. Veuillez attendre l'explosion.");
            return;
        }
        seDeplace();
        ArrayList<Ennemi> ennemis = chercheEnnemis();

        if (!ennemis.isEmpty()) {
            explosion();
            desactivation();
        }
        seDegrade();
        ralentit();
    }
    /**<p>
     * Cette méthode cherche des {@link Ennemi} dans l'{@link Environnement}:
     * <ol>
     *     <li>Elle compare la distance entre elle et les ennemis</li>
     *     <li>Elle utilise la méthode {@link #distanceAvec(double, double)} pour savoir qui ajouter dans sa liste d'ennemis proches}</li>
     *     <li>Si sa liste est vide elle retounre rien, Sinon elle retourne sa liste d'ennemis</li>
     * </ol>
     */
    private ArrayList<Ennemi> chercheEnnemis(){
        ArrayList<Ennemi> ennemisProches = new ArrayList<>();
        for (Ennemi e : getEnv().getEnnemis()) {
            assert false;
            double centreCibleX = e.getX() + (double) e.getLargeurImage() / 2;
            double centreCibleY = e.getY() + (double) e.getHauteurImage() / 2;
            if (distanceAvec(centreCibleX,centreCibleY) <= Portee.PORTEEBOMBE)
                ennemisProches.add(e);
        }
        return ennemisProches;
    }

    /**
     * Cette méthode inflige les dégats de la bombe à tous les ennemis proches
     */
    private void explosion() {
        ArrayList<Ennemi> ennemis = chercheEnnemis();
        for (Ennemi e : ennemis) {
            infligerDegats(e);
        }
    }

    /**
     * Cette méthode décrémente la vitesse de déplacement de la bombe
     */
    private void ralentit(){
        int val = getVitesse() > 0 ? 1 : 0;
        setVitesse(val-1);
    }

    @Override
    public String toString() {
        return "Bombe : " + super.toString();
    }
}
