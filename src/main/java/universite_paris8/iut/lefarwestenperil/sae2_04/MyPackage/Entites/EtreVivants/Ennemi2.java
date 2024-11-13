package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants;

import universite_paris8.iut.lefarwestenperil.sae2_04.BFS.BFS;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Weapons.Weapon;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.BarreDeVie;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Direction;

import java.util.List;
import java.awt.Point;

public abstract class Ennemi2 extends Guerrier{

    private final int hauteurI;
    private final int largeurI;
    private BFS bfs;
    private List<Point> chemin;
    private int pixelsParcourus;

    private final int portee;

    private final int tempsAttente;
    private int compteur;

    private boolean peutTraverserObstacles;

    private final BarreDeVie barreDeVie;

    public Ennemi2(String id, int x, int y, Direction direction, int vitesse, Environnement2 env, int pv, int pointDef, Weapon arme, int hauteurI, int largeurI, int portee, int tempsAttente, boolean peutTraverserObstacles) {
        super(id, x, y, direction, vitesse, env, pv, pointDef, arme);
        this.barreDeVie = new BarreDeVie(x, y, pv);
        bfs = new BFS();
        this.hauteurI = hauteurI;
        this.largeurI = largeurI;
        this.portee = portee;
        this.tempsAttente = tempsAttente;
        this.compteur = 0;
        this.peutTraverserObstacles = peutTraverserObstacles;
    }

    public BarreDeVie getBarreDeVie() {
        return barreDeVie;
    }

    public List<Point> getCheminCourt() {
        return chemin;
    }

    /**
     * Retourne la largeur de l'image de l'ennemi.
     * {@return int}
     */
    public int getLargeurImage() {
        return largeurI;
    }

    /**
     * Retourne la hauteur de l'image de l'ennemi.
     * @return int
     */
    public int getHauteurImage() {
        return hauteurI;
    }

    private void setCompteur(int tours) {
        compteur = tours;
    }

    public boolean traverserObstacles() {
        return peutTraverserObstacles;
    }

    public void setPeutTraverserObstacles(boolean peutTraverserObstacles) {
        this.peutTraverserObstacles = peutTraverserObstacles;
    }

    public void parcoursBFS(){
        if (chemin.isEmpty()) {
            return;
        }

        Point prochaineTuile = chemin.get(chemin.size() - 1);
        int deltaX = prochaineTuile.x * 32 - getX();
        int deltaY = prochaineTuile.y * 32 - getY();

        int stepX = 0;
        int stepY = 0;

        // Calcul du déplacement en X
        if (deltaX != 0) {
            stepX = (deltaX > 0 ? getVitesse() : -getVitesse());
            if (Math.abs(deltaX) < getVitesse()) {
                stepX = deltaX;
            }
        }

        // Calcul du déplacement en Y
        if (deltaY != 0) {
            stepY = (deltaY > 0 ? getVitesse() : -getVitesse());
            if (Math.abs(deltaY) < getVitesse()) {
                stepY = deltaY;
            }
        }

        // Tentative de déplacement en diagonale
        if (stepX != 0 && stepY != 0) {
            if (verifieMarchabilite(getX() + stepX, getY() + stepY)) {
                setX(getX() + stepX);
                setY(getY() + stepY);
            } else if (verifieMarchabilite(getX() + stepX, getY())) {
                setX(getX() + stepX);
            } else if (verifieMarchabilite(getX(), getY() + stepY)) {
                setY(getY() + stepY);
            }
        } else if (stepX != 0) {
            if (verifieMarchabilite(getX() + stepX, getY())) {
                setX(getX() + stepX);
            }
        } else if (stepY != 0) {
            if (verifieMarchabilite(getX(), getY() + stepY)) {
                setY(getY() + stepY);
            }
        }

        // Vérifier si l'ennemi a atteint la prochaine tuile
        deltaX = prochaineTuile.x * 32 - getX();
        deltaY = prochaineTuile.y * 32 - getY();
        if (Math.abs(deltaX) < getVitesse() && Math.abs(deltaY) < getVitesse()) {
            setX(prochaineTuile.x * 32);
            setY(prochaineTuile.y * 32);
            chemin.remove(chemin.size() - 1);
        }
    }

    /**
     * Déplace l'ennemi en suivant un chemin en carré.
     * L'ennemi change de direction après avoir parcouru une distance de 32 pixels.
     */
    @Override
    public void seDeplace() {
        // Calcule la nouvelle position en fonction de la direction actuelle
        int newX = getX() + getVitesse()*getDx();
        int newY = getY() + getVitesse()*getDy();

        // Calcule les cases correspondantes à la nouvelle position

        int caseX2 = newX + largeurI - 1;
        int caseY2 = newY + hauteurI - 1;

        // Vérifie si la nouvelle position est marchable pour toute la zone occupée par l'image
        if (getEnv().estMarchable(newX,newY) && getEnv().estMarchable(caseX2,caseY2)) {
            setX(newX);
            setY(newY);
            pixelsParcourus += getVitesse();

            // Change de direction après avoir parcouru 32 pixels
            if (pixelsParcourus >= 32) {
                updateDir();
                pixelsParcourus = 0;
            }
        } else {
            // Change de direction si la position n'est pas marchable
            updateDir();
            pixelsParcourus = 0;
        }
    }

    @Override
    public void agit() {
        Link2 link = Environnement2.getLink2();
        if (linkACote()) {
            initChemin(link.getX(),link.getY());
            parcoursBFS();
            if (getEnv().getTours() - compteur >= tempsAttente) {
                getArme().attaquer(this);
                setCompteur(getEnv().getTours());
            }
        } else {
            this.seDeplace();
        }
    }

    private boolean verifieMarchabilite(int x, int y){
        if (peutTraverserObstacles)
            return true;
        int caseX2 = (x + largeurI - 1) ;
        int caseY2 = (y + hauteurI - 1) ;
        return getEnv().estMarchable(x, y) && getEnv().estMarchable(caseX2, caseY2);
    }

    private boolean linkACote() {
        Link2 link = Environnement2.getLink2();
        return distanceAvec(link.getX(),link.getY()) <= portee;
    }

    private void initChemin(int cibleX, int cibleY) {
        int[][] tab = getEnv().getTerrain().getTab();
        int newX = (getX()+8) / 32;
        int newY = (getY()+8) / 32;
        int newLinkX = cibleX/ 32;
        int newLinkY = cibleY / 32;
        this.chemin = BFS.bfs(tab, new Point(newX, newY), new Point(newLinkX, newLinkY));
    }

    private void updateDir(){
         switch (getDirection()) {
             case HAUT, NULL -> setDirection(Direction.DROIT);
             case DROIT -> setDirection(Direction.BAS);
             case BAS -> setDirection(Direction.GAUCHE);
             case GAUCHE -> setDirection(Direction.HAUT);
         }
    }

}
