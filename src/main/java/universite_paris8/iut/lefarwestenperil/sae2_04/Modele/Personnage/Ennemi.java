package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage;

import universite_paris8.iut.lefarwestenperil.sae2_04.BFS.BFS;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.BarreDeVie;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

import java.awt.*;
import java.util.List;

/**
 * La classe abstraite Ennemi représente un ennemi dans le jeu.
 * Un ennemi est un personnage qui peut se déplacer sur le terrain.
 */
public abstract class Ennemi extends Personnage {
    private int vitesse;
    public static int compteurId = 0;
    private String id;
    private int tuileActuel;
    private BarreDeVie barreDeVie;
    private int pixelsParcourus;
    private int directionActuelle;
    private int portee;
    private int porteeAttaque;
    private int largeurImage;
    private int hauteurImage;
    private BFS bfs;
    private List<Point> chemin;
    private boolean peutTraverserObstacles;
    private Environnement environnement;
    private int compteur;
    private final int tempsAttente;


    /**
     * Constructeur pour initialiser un Ennemi avec les paramètres donnés.
     * @param x la position x initiale
     * @param y la position y initiale
     * @param pointVie les points de vie de l'ennemi
     * @param pointAttaque les points d'attaque de l'ennemi
     * @param pointDefense les points de défense de l'ennemi
     * @param terrain le terrain sur lequel se déplace l'ennemi
     * @param vitesse la vitesse de déplacement de l'ennemi
     * * @param largeurImage la largeur de l'image de l'ennemi
     * * @param hauteurImage la hauteur de l'image de l'ennemi
     */
    public Ennemi(int x, int y, int pointVie, int pointAttaque, int pointDefense, Terrain terrain, int vitesse, int portee, boolean peutTraverserObstacles, int porteeAttaque, Environnement env, int tempsAttente, int largeurImage, int hauteurImage) {
        super(x, y, pointVie, pointAttaque, pointDefense, terrain);
        this.vitesse = vitesse;
        this.id = "E" + compteurId;
        compteurId++;
        this.barreDeVie = new BarreDeVie(pointVie, pointVie, getId(), getX(), getY());
        this.largeurImage = largeurImage;
        this.hauteurImage = hauteurImage;
        this.pixelsParcourus = 0;
        this.directionActuelle = 0;
        this.portee = portee;
        this.bfs = new BFS();
        this.peutTraverserObstacles = peutTraverserObstacles;
        this.porteeAttaque = porteeAttaque;
        this.environnement = env;
        this.compteur = 0;
        this.tempsAttente = tempsAttente;
    }

    public Environnement getEnvironnement(){
        return environnement;
    }

    public int getCompteur(){
        return compteur;
    }

    public void setCompteur(int i){
        this.compteur = i;
    }

    public int getVitesse() {
        return vitesse;
    }

    public static int getCompteurId() {
        return compteurId;
    }

    public int getTuileActuel() {
        return tuileActuel;
    }

    public BarreDeVie getBarreDeVie() {
        return barreDeVie;
    }

    public int getPixelsParcourus() {
        return pixelsParcourus;
    }

    public int getDirectionActuelle() {
        return directionActuelle;
    }


    /**
     * Déplace l'ennemi en suivant un chemin en carré.
     * L'ennemi change de direction après avoir parcouru une distance de 32 pixels.
     */
    public void deplacerEnCarre() {
        // Tableau des directions de déplacement (droite, bas, gauche, haut)
        int[][] directions = {{vitesse, 0}, {0, vitesse}, {-vitesse, 0}, {0, -vitesse}};

        // Calcule la nouvelle position en fonction de la direction actuelle
        int newX = getX() + directions[directionActuelle][0];
        int newY = getY() + directions[directionActuelle][1];

        // Calcule les cases correspondantes à la nouvelle position
        int caseX1 = newX ;
        int caseY1 = newY ;
        int caseX2 = (newX + largeurImage - 1) ;
        int caseY2 = (newY + hauteurImage - 1) ;

        // Vérifie si la nouvelle position est marchable pour toute la zone occupée par l'image
        if (getTerrain().estMarchable(caseY1, caseX1) && getTerrain().estMarchable(caseY2, caseX2)) {
            setX(newX);
            setY(newY);
            pixelsParcourus += vitesse;

            // Change de direction après avoir parcouru 32 pixels
            if (pixelsParcourus >= 32) {
                directionActuelle = (directionActuelle + 1) % 4;
                pixelsParcourus = 0;
            }
        } else {
            // Change de direction si la position n'est pas marchable
            directionActuelle = (directionActuelle + 1) % 4;
            pixelsParcourus = 0;
        }
    }

    public List<Point> getCheminCourt() {
        return chemin;
    }

    /**
     * Retourne l'identifiant unique de l'ennemi.
     * @return l'identifiant unique de l'ennemi
     */
    public String getId() {
        return id;
    }

    /**
     * Retourne la largeur de l'image de l'ennemi.
     * @return la largeur de l'image de l'ennemi
     */
    public int getLargeurImage() {
        return largeurImage;
    }

    /**
     * Retourne la hauteur de l'image de l'ennemi.
     * @return la hauteur de l'image de l'ennemi
     */
    public int getHauteurImage() {
        return hauteurImage;
    }


    public void setPeutTraverserObstacles(boolean peutTraverserObstacles) {
        this.peutTraverserObstacles = peutTraverserObstacles;
    }

    public boolean getPeutTraverserObstacles() {
        return peutTraverserObstacles;
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
            stepX = (deltaX > 0 ? vitesse : -vitesse);
            if (Math.abs(deltaX) < vitesse) {
                stepX = deltaX;
            }
        }

        // Calcul du déplacement en Y
        if (deltaY != 0) {
            stepY = (deltaY > 0 ? vitesse : -vitesse);
            if (Math.abs(deltaY) < vitesse) {
                stepY = deltaY;
            }
        }

        // Tentative de déplacement en diagonale
        if (stepX != 0 && stepY != 0) {
            if (verifierMarchabilite(getX() + stepX, getY() + stepY)) {
                setX(getX() + stepX);
                setY(getY() + stepY);
            } else if (verifierMarchabilite(getX() + stepX, getY())) {
                setX(getX() + stepX);
            } else if (verifierMarchabilite(getX(), getY() + stepY)) {
                setY(getY() + stepY);
            }
        } else if (stepX != 0) {
            if (verifierMarchabilite(getX() + stepX, getY())) {
                setX(getX() + stepX);
            }
        } else if (stepY != 0) {
            if (verifierMarchabilite(getX(), getY() + stepY)) {
                setY(getY() + stepY);
            }
        }

        // Vérifier si l'ennemi a atteint la prochaine tuile
        deltaX = prochaineTuile.x * 32 - getX();
        deltaY = prochaineTuile.y * 32 - getY();
        if (Math.abs(deltaX) < vitesse && Math.abs(deltaY) < vitesse) {
            setX(prochaineTuile.x * 32);
            setY(prochaineTuile.y * 32);
            chemin.remove(chemin.size() - 1);
        }
    }
    // c bon vous etes la ?ouii//OUI
    // Les ennemis chaque tours ils vont utiliser cette méthode et

    public void seDeplacer(Link link) {
        if (detectionLink(link)) {    // du coup si link est detectet
            parcoursBFS(); // on trouve le chemin quii mene vers link et on se deplace vers lui
            if (getEnvironnement().getTours() - getCompteur() >= tempsAttente && linkACote()) {

                getArme().attaquer(this, null);
                setCompteur(getEnvironnement().getTours());
            }
        } else {
            deplacerEnCarre();
        }
    }


    private boolean verifierMarchabilite(int x, int y) {
        if (peutTraverserObstacles) {
            return true;
        }

        int caseX1 = x ;
        int caseY1 = y ;
        int caseX2 = (x + largeurImage - 1) ;
        int caseY2 = (y + hauteurImage - 1) ;

        return getTerrain().estMarchable(caseY1, caseX1) && getTerrain().estMarchable(caseY2, caseX2);
    }

    public boolean peutAttaquer(Link link) {
        double distance = Math.sqrt(Math.pow(link.getX() - getX() , 2) + Math.pow(link.getY() - getY(), 2));
        return distance <= porteeAttaque;
    }

    public boolean detectionLink(Link link) {
        double distance = Math.sqrt(Math.pow(link.getX() - getX() , 2) + Math.pow(link.getY() - getY(), 2));
        if(distance <= portee) {
            this.chemin = BFS.bfs(getTerrain().getDonneeTerrain(),new Point((getX()+8)/32, (getY()+10)/32), new Point(link.getX()/32, link.getY()/32));
            for (Point tuile : chemin) {
                System.out.println(tuile);
            }
        }
        return distance <= portee;
    }

    public boolean linkACote() {
        Link link = environnement.getLink();
        double distance = Math.sqrt(Math.pow(link.getX() - getX(), 2) + Math.pow(link.getY() - getY(), 2));
        return distance <= 100;
    }

}
