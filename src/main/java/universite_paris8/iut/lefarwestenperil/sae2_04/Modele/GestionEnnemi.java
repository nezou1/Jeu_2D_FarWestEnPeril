package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Ici on se concentre sur la gestion des ennemis, qui comprenait l'ajout, le déplacement et la detection de link.
 * Tout cela se trouvait dans la class Environnement et a été déplacée dans une nouvelle classe appelée GestionEnnemi.
 */

public class GestionEnnemi{
    private  ObservableList<Ennemi> ennemis;
    private Terrain terrain;
    private Environnement environnement;

    public GestionEnnemi(Terrain terrain, Environnement environnement) {
        this.terrain = terrain;
        this.environnement = environnement;
        this.ennemis = FXCollections.observableArrayList();
    }

    public void ajouterEnnemisAleatoirement(int nombreEnnemis) {
        /**
         *    Ajoute des ennemis aléatoirement sur la carte
         */
        Random rand = new Random();
        int largeurMap = terrain.getLargeur();
        int hauteurMap = terrain.getHauteur();

        int nombreCowboysHautGauche = (int) (nombreEnnemis * 0.25);
        int nombreDragonsHautGauche = (int) (nombreEnnemis * 0.10);

        int nombreCowboysHautDroit = (int) (nombreEnnemis * 0.15);
        int nombreDragonsHautDroit = (int) (nombreEnnemis * 0.15);

        int nombreCowboysBasDroit = (int) (nombreEnnemis * 0.10);
        int nombreDragonsBasDroit = (int) (nombreEnnemis * 0.25);

        ajouterEnnemisParType(rand, nombreCowboysHautGauche, "Cowboy", 0, hauteurMap, 0, largeurMap);
        ajouterEnnemisParType(rand, nombreDragonsHautGauche, "Dragon", 0, hauteurMap, 0, largeurMap);
        ajouterEnnemisParType(rand, nombreCowboysHautDroit, "Cowboy", 0, hauteurMap, 0, largeurMap);
        ajouterEnnemisParType(rand, nombreDragonsHautDroit, "Dragon", 0, hauteurMap, 0, largeurMap);
        ajouterEnnemisParType(rand, nombreCowboysBasDroit, "Cowboy", 0, hauteurMap, 0, largeurMap);
        ajouterEnnemisParType(rand, nombreDragonsBasDroit, "Dragon", 0, hauteurMap, 0, largeurMap);
    }

    private void ajouterEnnemisParType(Random rand, int nombreEnnemis,String type, int minY, int maxY, int minX, int maxX) {
        // Ajoute des ennemis d'un type spécifique

        for (int i = 0; i < nombreEnnemis; i++) {
            Ennemi ennemi;
            if (type.equals("Cowboy") ) {
                ennemi = new Cowboy(terrain, environnement);
            } else {
                ennemi = new Dragon(terrain, environnement);
            }
            placerEnnemiAleatoirement(rand, ennemi, terrain, minY, maxY, minX, maxX);
            ennemis.add(ennemi);
            environnement.ajouterBarreDeVie(ennemi.getBarreDeVie());
        }
    }


    public ObservableList<Ennemi> getEnnemis() {
        return ennemis;
    }

    public void deplacerEnnemis(Link link) {
        for (Ennemi ennemi : ennemis) {
            ennemi.seDeplacer(link);
            ennemi.getBarreDeVie().miseAJourVieTotale();
        }
    }

    public static void placerEnnemiAleatoirement(Random rand, Ennemi ennemi, Terrain terrain, int minY, int maxY, int minX, int maxX) {
        /*
            Cette méthode place aléatoirement les ennemis dans le terrain
         */

        int largeurImage = ennemi.getLargeurImage();
        int hauteurImage = ennemi.getHauteurImage();
        int x, y;
        do {
            x = minX * 32 + rand.nextInt((maxX - minX) * 32);
            y = minY * 32 + rand.nextInt((maxY - minY) * 32);
        } while (!terrain.estMarchable(y , x ) || !terrain.estMarchable((y + hauteurImage - 1) , (x + largeurImage - 1) ));
        ennemi.setX(x);
        ennemi.setY(y);


    }

    public List<Ennemi> getEnnemisDansRayon(int x, int y, int rayon) {
        List<Ennemi> ennemisDansRayon = new ArrayList<>();
        for (Ennemi ennemi : ennemis) {
            double distance = Math.sqrt(Math.pow(ennemi.getX() - x, 2) + Math.pow(ennemi.getY() - y, 2));
            if (distance <= rayon) {
                ennemisDansRayon.add(ennemi);
            }
        }
        return ennemisDansRayon;
    }

    public void miseAjour(Link link){
        for (int i = 0; i < ennemis.size(); i++) {
            Ennemi e = ennemis.get(i);
            e.seDeplacer(link);
            e.getBarreDeVie().setX(e.getX());
            e.getBarreDeVie().setY(e.getY());
            e.getBarreDeVie().setVieActuelle(e.getPointVie());
            e.getBarreDeVie().miseAJourVieTotale();
            System.out.println(e.getBarreDeVie().getVieRestante());
            System.out.println(e.estVivant() +" et " + e.getPointVie());
            if (!e.estVivant()) {
                ennemis.remove(i);
                i--;
            }
        }
    }
}

