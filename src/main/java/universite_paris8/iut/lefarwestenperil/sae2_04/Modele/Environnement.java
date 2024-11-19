package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import javafx.collections.ObservableList;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.BarreDeVie;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.PNJs.Gardien;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Link;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.Projectile;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Gestionnaire.GestionEnnemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Gestionnaire.GestionGardien;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Gestionnaire.GestionProjectile;

import java.util.List;

/**
 * Classe Environnement :
 * <p>
 * Cette classe se charge de la gestion de tous les éléments du jeu intéragissant entre eux.
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

    private final Link link;
    private final Terrain terrain;

    private final GestionEnnemi gestionEnnemi;
    private final GestionProjectile gestionProjectile;
    private final GestionGardien gestionGardien;

    private int tours;

    public Environnement() {
        terrain = new Terrain();
        link = new Link(this);
        gestionEnnemi = new GestionEnnemi(this);
        gestionProjectile = new GestionProjectile();
        gestionGardien = new GestionGardien(this);
        this.tours = 0;
    }

    public void unTour() {
        gestionEnnemi.deplacerEnnemis();
        gestionEnnemi.miseAjour();
        gestionProjectile.mettreAJourProjectiles();

        link.agit();
        tours++;
    }


    public void ajouterEnnemisAleatoirement(int nbEnnemi) {

        gestionEnnemi.ajouterEnnemisAleatoirement(nbEnnemi);
    }

    public void ajouterProjectile(Projectile projectile) {
        gestionProjectile.ajouterProjectile(projectile);
    }

    public void ajouterGardien(Gardien gardien) {
        gestionGardien.ajouterGardien(gardien);
    }

    public void ajouterQuestionGardien() {
        gestionGardien.ajouterQuestionGardien();
    }


    public Gardien verifierRencontreLinkGardien() {
        return gestionGardien.verifierRencontreLinkGardien();
    }

    public boolean estMarchable(int x, int y) {
        return terrain.estMarchable(x, y);
    }

    public boolean verifierVictoire() {
        int x = link.getX() / 32;
        int y = link.getY() / 32;
        return getTerrain().getDonneeTerrain()[y][x] == 12;
    }

    // GETTERS

    public Terrain getTerrain() {
        return terrain;
    }

    public int getHauteur() {
        return terrain.getHauteur();
    }

    public int getLargeur() {
        return terrain.getLargeur();
    }

    public Link getLink2() {
        return link;
    }

    public ObservableList<Ennemi> getEnnemis() {

        return gestionEnnemi.getEnnemis();
    }

    public List<Ennemi> getEnnemisDansRayon(int x, int y, int rayon) {
        return gestionEnnemi.getEnnemisDansRayon(x, y, rayon);
    }

    public ObservableList<BarreDeVie> getBarreDeVies() {

        return gestionEnnemi.getBarreDeVies();
    }

    public ObservableList<Projectile> getProjectiles() {

        return gestionProjectile.getProjectiles();
    }

    public ObservableList<Gardien> getGardiens() {
        return gestionGardien.getGardiens();
    }

    public int getTours() {
        return tours;
    }
}
