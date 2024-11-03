package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Link;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;

public class BouleDeFeu extends Projectile {
    private final int creationTour;
    private boolean active;

    public BouleDeFeu(int x, int y, int cibleX, int cibleY, int degats, Environnement env) {
        super(x, y, cibleX, cibleY, degats, 4, env); // Appel au constructeur de Projectile
        this.creationTour = env.getTours();
        this.active = true;
    }

    public boolean isActive() {
        return active;
    }

    public int getCreationTour() {
        return creationTour;
    }

    public void explosion() {
        active = false;
    }

    @Override
    public void deplacer() {
        if (!active) return;

        // Met à jour la cible vers la position actuelle de Link
        Link link = getEnv().getLink();
        cibleX = link.getX();
        cibleY = link.getY();

        int x = getX();
        int y = getY();
        int vitesse = getVitesse(); // Utilise la vitesse depuis Deplacement

        // Ajuste les coordonnées x et y pour se rapprocher de la cible
        if (cibleX > x) {
            x += vitesse;
        } else if (cibleX < x) {
            x -= vitesse;
        }

        if (cibleY > y) {
            y += vitesse;
        } else if (cibleY < y) {
            y -= vitesse;
        }

        setX(x);
        setY(y);

        // Si le projectile est proche de la cible, inflige des dégâts et explose
        if (Math.abs(x - cibleX) < vitesse && Math.abs(y - cibleY) < vitesse) {
            infligerDegats(link);
            explosion();
        }
    }

    @Override
    public void infligerDegats(Personnage cible) {
        super.infligerDegats(cible);
        getEnv().ajouterBrulure();
    }
}
