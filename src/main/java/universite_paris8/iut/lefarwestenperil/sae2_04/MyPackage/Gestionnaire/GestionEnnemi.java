package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Gestionnaire;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.BarreDeVie;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Personnage.Cowboy2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Personnage.Dragon2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Personnage.Ennemi2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Terrain;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Utilitaires.Outils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Ici on se concentre sur la gestion des ennemis, qui comprenait l'ajout, le déplacement et la detection de link.
 * Tout cela se trouvait dans la class Environnement et a été déplacée dans une nouvelle classe appelée GestionEnnemi.
 */

public class GestionEnnemi{

    private final ObservableList<Ennemi2> ennemis = FXCollections.observableArrayList();
    private final ObservableList<BarreDeVie> barreDeVies = FXCollections.observableArrayList();
    private final Environnement2 environnement;

    public GestionEnnemi(Environnement2 environnement) {
        this.environnement = environnement;
    }

    public ObservableList<Ennemi2> getEnnemis() {
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
            Ennemi2 ennemi;
            if (type.equals("Cowboy") ) {
                ennemi = new Cowboy2(environnement);
            } else {
                ennemi = new Dragon2(environnement);
            }
            placerEnnemiAleatoirement(ennemi, environnement.getTerrain(), 0, maxY, 0, maxX);
            ennemis.add(ennemi);
            barreDeVies.add(ennemi.getBarreDeVie());
        }
    }

    public void deplacerEnnemis() {
        for (Ennemi2 ennemi : ennemis) {
            ennemi.agit();
            ennemi.getBarreDeVie().miseAJourVieTotale();
        }
    }

    public static void placerEnnemiAleatoirement(Ennemi2 ennemi, Terrain terrain, int minY, int maxY, int minX, int maxX) {
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
        } while (!terrain.estMarchable(x,y) || !terrain.estMarchable((x + largeurImage - 1), (y + hauteurImage - 1) ));
        ennemi.setX(x);
        ennemi.setY(y);
    }

    public List<Ennemi2> getEnnemisDansRayon(int x, int y, int rayon) {
        List<Ennemi2> ennemisDansRayon = new ArrayList<>();
        for (Ennemi2 ennemi : ennemis) {
            if (Outils.distanceEntre(x,y,ennemi.getX(),ennemi.getY()) < rayon) {
                ennemisDansRayon.add(ennemi);
            }
        }
        return ennemisDansRayon;
    }

    public void miseAjour(){
        for (int i = 0; i < ennemis.size(); i++) {
            Ennemi2 e = ennemis.get(i);
            BarreDeVie bVie = e.getBarreDeVie();
            bVie.setX(e.getX());
            bVie.setY(e.getY());
            bVie.setVieActuelle(e.getPointVie());
            bVie.miseAJourVieTotale();
//            System.out.println(e.getBarreDeVie().getVieRestante());
            if (!e.estVivant()) {
                ennemis.remove(i);
                i--;
            }
        }
    }
}