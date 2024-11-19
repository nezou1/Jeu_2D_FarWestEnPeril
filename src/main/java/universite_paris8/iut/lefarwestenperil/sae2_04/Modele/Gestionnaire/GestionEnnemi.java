package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Gestionnaire;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.BarreDeVie;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Cowboy;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Dragon;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires.Outils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Ici on se concentre sur la gestion des ennemis, qui comprenait l'ajout, le déplacement et la detection de link.
 * Tout cela se trouvait dans la class Environnement et a été déplacée dans une nouvelle classe appelée GestionEnnemi.
 */

public class GestionEnnemi {

    private final ObservableList<Ennemi> ennemis = FXCollections.observableArrayList();
    private final ObservableList<BarreDeVie> barreDeVies = FXCollections.observableArrayList();
    private final Environnement environnement;

    public GestionEnnemi(Environnement environnement) {
        this.environnement = environnement;
    }

    public static void placerEnnemiAleatoirement(Ennemi ennemi, Terrain terrain, int minY, int maxY, int minX, int maxX) {
        /*
            Cette méthode place aléatoirement les ennemis dans le terrain
         */
        int largeurImage = ennemi.getLargeurImage();
        int hauteurImage = ennemi.getHauteurImage();
        Random rand = new Random();
        int x, y;
        do {
            x = minX * 32 + rand.nextInt((maxX - minX) * 32);
            y = minY * 32 + rand.nextInt((maxY - minY) * 32);
        } while (!terrain.estMarchable(x, y) || !terrain.estMarchable((x + largeurImage - 1), (y + hauteurImage - 1)));
        ennemi.setX(x);
        ennemi.setY(y);
    }

    public ObservableList<Ennemi> getEnnemis() {
        return ennemis;
    }

    public ObservableList<BarreDeVie> getBarreDeVies() {
        return barreDeVies;
    }

    public void ajouterEnnemisAleatoirement(int nombreEnnemis) {
        /*
         *    Ajoute des ennemis aléatoirement sur la carte
         */
        int largeurMap = environnement.getLargeur();
        int hauteurMap = environnement.getHauteur();

        int nombreCowboys = (int) (nombreEnnemis * 0.50);  // 50% de Cowboys
        int nombreDragons = (int) (nombreEnnemis * 0.50);  // 50% de Dragons

        ajouterEnnemisParType(nombreCowboys, "Cowboy", hauteurMap, largeurMap);
        ajouterEnnemisParType(nombreDragons, "Dragon", hauteurMap, largeurMap);
    }

    private void ajouterEnnemisParType(int nombreEnnemis, String type, int maxY, int maxX) {
        // Ajoute des ennemis d'un type spécifique
        for (int i = 0; i < nombreEnnemis; i++) {
            Ennemi ennemi;
            if (type.equals("Cowboy")) {
                ennemi = new Cowboy(environnement);
            } else {
                ennemi = new Dragon(environnement);
            }
            placerEnnemiAleatoirement(ennemi, environnement.getTerrain(), 0, maxY, 0, maxX);
            ennemis.add(ennemi);
            barreDeVies.add(ennemi.getBarreDeVie());
        }
    }

    public void deplacerEnnemis() {
        for (Ennemi ennemi : ennemis) {
            ennemi.agit();
            ennemi.getBarreDeVie().miseAJourVieTotale();
        }
    }

    public List<Ennemi> getEnnemisDansRayon(int x, int y, int rayon) {
        List<Ennemi> ennemisDansRayon = new ArrayList<>();
        for (Ennemi ennemi : ennemis) {
            if (Outils.distanceEntre(x, y, ennemi.getX(), ennemi.getY()) < rayon) {
                ennemisDansRayon.add(ennemi);
            }
        }
        return ennemisDansRayon;
    }

    public void miseAjour() {
        for (int i = 0; i < ennemis.size(); i++) {
            Ennemi e = ennemis.get(i);
            BarreDeVie bVie = e.getBarreDeVie();
            bVie.setX(e.getX());
            bVie.setY(e.getY());
            bVie.setVieActuelle(e.getPointVie());
            bVie.miseAJourVieTotale();
            if (!e.estVivant()) {
                ennemis.remove(i);
                i--;
            }
        }
    }
}