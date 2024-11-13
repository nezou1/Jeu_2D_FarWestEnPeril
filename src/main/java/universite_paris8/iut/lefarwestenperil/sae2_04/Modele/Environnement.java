package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import javafx.collections.ObservableList;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.BarreDeVie;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.PNJs.Gardien2;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Link;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.Projectile;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Gestionnaire.GestionEnnemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Gestionnaire.GestionGardien;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Gestionnaire.GestionProjectile;

import java.util.List;

/**
 * Classe Environnement :
 * <p>
 *     Cette classe se charge de la gestion de tous les éléments du jeu intéragissant entre eux.
 * </p>
 * Elle possède :
 * <ul>
 *     <li>un terrain {@link Terrain}</li>
 *     <li>un personnage principal {@link Link}</li>
 *     <li>un nombre de tours {@link #tours}</li>
 *     <li>un gestionnaire d'ennemis {@link GestionEnnemi}</li>
 *     <li>un gestionnaire de projectiles {@link GestionProjectile}</li>
 *     <li>un gestionnaire de personnages non-jouables {@link GestionGardien}</li>
 * </ul>
 */

public class Environnement {

    private static Environnement instance;

    private static Link link;
    private final Terrain terrain;

    private final GestionEnnemi gestionEnnemi;
    private final GestionProjectile gestionProjectile;
    private final GestionGardien gestionGardien;

    private int tours;

    public Environnement() {
        terrain = new Terrain();
        Environnement.link = Link.getInstance(this);
        gestionEnnemi = new GestionEnnemi(this);
        gestionProjectile = new GestionProjectile();
        gestionGardien = new GestionGardien();
        this.tours = 0;
    }

    public static Environnement getInstance() {
        if (instance == null) {
            instance = new Environnement();
        }
        return instance;
    }

    public Terrain getTerrain(){
        return terrain;
    }

    public int getHauteur(){
        return terrain.getHauteur();
    }
    public int getLargeur(){
        return terrain.getLargeur();
    }

    public static Link getLink2(){
        return link;
    }

    public ObservableList<Ennemi> getEnnemis() {
        return gestionEnnemi.getEnnemis();
    }
    public void ajouterEnnemisAleatoirement(int nbEnnemi){
        gestionEnnemi.ajouterEnnemisAleatoirement(nbEnnemi);
    }
    public List<Ennemi> getEnnemisDansRayon(int x, int y, int rayon) {
        return gestionEnnemi.getEnnemisDansRayon(x,y,rayon);
    }
    public ObservableList<BarreDeVie> getBarreDeVies() {
        return gestionEnnemi.getBarreDeVies();
    }

    public ObservableList<Projectile> getProjectiles(){
        return gestionProjectile.getProjectiles();
    }
    public void ajouterProjectile(Projectile projectile){
        gestionProjectile.ajouterProjectile(projectile);
    }

    public ObservableList<Gardien2> getGardiens() {
        return gestionGardien.getGardiens();
    }
    public void ajouterGardien(Gardien2 gardien) {
        gestionGardien.ajouterGardien(gardien);
    }
    public void ajouterQuestionGardien() {
        gestionGardien.ajouterQuestionGardien();
    }
    public Gardien2 verifierRencontreLinkGardien(){
        return gestionGardien.verifierRencontreLinkGardien();
    }

    public int getTours() {
        return tours;
    }

    public void unTour() {
        gestionEnnemi.deplacerEnnemis();
        gestionEnnemi.miseAjour();
        gestionProjectile.mettreAJourProjectiles();

        link.agit();
        tours++;
    }


    public boolean estMarchable(int x, int y) {
        return terrain.estMarchable(x,y);
    }

    public boolean verifierVictoire() {
        Link link = Environnement.getLink2();
        int x = link.getX()/32;
        int y = link.getY()/32;
        return getTerrain().getDonneeTerrain()[y][x] == 12 ;
    }
}
