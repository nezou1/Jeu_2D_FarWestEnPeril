package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage;

import javafx.collections.ObservableList;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.*;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants.Ennemi2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.PNJs.Gardien2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants.Link2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Projectiles.Projectile;

import java.util.List;

/**
 * Classe Environnement :
 * <p>
 *     Cette classe se charge de la gestion de tous les éléments du jeu intéragissant entre eux.
 * </p>
 * Elle possède :
 * <ul>
 *     <li>un terrain {@link Terrain}</li>
 *     <li>un personnage principal {@link Link2}</li>
 *     <li>un nombre de tours {@link #tours}</li>
 *     <li>un gestionnaire d'ennemis {@link GestionEnnemi}</li>
 *     <li>un gestionnaire de projectiles {@link GestionProjectile}</li>
 *     <li>un gestionnaire de personnages non-jouables {@link GestionGardien}</li>
 * </ul>
 */

public class Environnement2 {

    private static Link2 link2;
    private final Terrain terrain;

    private final GestionEnnemi gestionEnnemi;
    private final GestionProjectile gestionProjectile;
    private final GestionGardien gestionGardien;

    private int tours;

    public Environnement2() {
        terrain = new Terrain();
        Environnement2.link2 = new Link2(this);
        gestionEnnemi = new GestionEnnemi(this);
        gestionProjectile = new GestionProjectile();
        gestionGardien = new GestionGardien();
        this.tours = 0;
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

    public static Link2 getLink2(){
        return link2;
    }

    public ObservableList<Ennemi2> getEnnemis() {
        return gestionEnnemi.getEnnemis();
    }
    public void ajouterEnnemisAleatoirement(int nbEnnemi){
        gestionEnnemi.ajouterEnnemisAleatoirement(nbEnnemi);
    }
    public List<Ennemi2> getEnnemisDansRayon(int x, int y, int rayon) {
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

        link2.agit();
        tours++;
    }


    public boolean estMarchable(int x, int y) {
        return terrain.estMarchable(x,y);
    }

    public boolean verifierVictoire() {
        Link2 link = Environnement2.getLink2();
        int x = link.getX()/32;
        int y = link.getY()/32;
        return getTerrain().getTab()[y][x] == 12 ;
    }
}
