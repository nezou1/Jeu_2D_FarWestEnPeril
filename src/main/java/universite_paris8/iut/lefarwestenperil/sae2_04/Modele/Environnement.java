package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.*;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles.BouleDeFeu;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles.Fleche;

import java.util.*;

/**
 * La classe Environnement représente le contexte global du jeu, incluant les ennemis, les gardiens, les projectiles, etc.
 */
public class Environnement {
    private ObservableList<Ennemi> ennemis;
    private ObservableList<BarreDeVie> barreDeVies;
    private ObservableList<Fleche> fleches;
    private ObservableList<BouleDeFeu> boulesDeFeu;
    private IntegerProperty nombreEnnemis;
    private Link link;
    private int tours;
    private Terrain terrain;
    private ObservableList<Gardien> gardiens;

    public Environnement(Terrain terrain, Link link) {
        this.terrain = terrain;
        this.link = link;
        this.ennemis = FXCollections.observableArrayList();
        this.barreDeVies = FXCollections.observableArrayList();
        this.fleches = FXCollections.observableArrayList();
        this.boulesDeFeu = FXCollections.observableArrayList();
        this.gardiens = FXCollections.observableArrayList();
        this.tours = 0;
        this.nombreEnnemis = new SimpleIntegerProperty(0);
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public ObservableList<Gardien> getGardiens() {
        return gardiens;
    }

    public ObservableList<Ennemi> getEnnemis() {
        return ennemis;
    }

    public ObservableList<BarreDeVie> getBarreDeVies() {
        return barreDeVies;
    }

    public ObservableList<Fleche> getFleches() {
        return fleches;
    }

    public ObservableList<BouleDeFeu> getBoulesDeFeu() {
        return boulesDeFeu;
    }

    public int getTours() {
        return tours;
    }

    public Link getLink() {
        return link;
    }

    public void ajouterGardien(Gardien gardien) {
        gardiens.add(gardien);
    }

    public void ajouterEnnemisAleatoirement(int nombreEnnemis) {
        Map<String, Integer> repartitionEnnemis = calculerRepartitionEnnemis(nombreEnnemis);
        placerEnnemisRegion(repartitionEnnemis.get("CowboysHautGauche"), Cowboy.class, 0, terrain.getHauteur() / 2, 0, terrain.getLargeur() / 2);
        placerEnnemisRegion(repartitionEnnemis.get("DragonsHautGauche"), Dragon.class, 0, terrain.getHauteur() / 2, 0, terrain.getLargeur() / 2);
        placerEnnemisRegion(repartitionEnnemis.get("CowboysHautDroit"), Cowboy.class, 0, terrain.getHauteur() / 2, terrain.getLargeur() / 2, terrain.getLargeur());
        placerEnnemisRegion(repartitionEnnemis.get("DragonsHautDroit"), Dragon.class, 0, terrain.getHauteur() / 2, terrain.getLargeur() / 2, terrain.getLargeur());
        placerEnnemisRegion(repartitionEnnemis.get("CowboysBasDroit"), Cowboy.class, terrain.getHauteur() / 2, terrain.getHauteur(), terrain.getLargeur() / 2, terrain.getLargeur());
        placerEnnemisRegion(repartitionEnnemis.get("DragonsBasDroit"), Dragon.class, terrain.getHauteur() / 2, terrain.getHauteur(), terrain.getLargeur() / 2, terrain.getLargeur());
    }

    private Map<String, Integer> calculerRepartitionEnnemis(int nombreEnnemis) {
        Map<String, Integer> repartition = new HashMap<>();
        repartition.put("CowboysHautGauche", (int) (nombreEnnemis * 0.25));
        repartition.put("DragonsHautGauche", (int) (nombreEnnemis * 0.10));
        repartition.put("CowboysHautDroit", (int) (nombreEnnemis * 0.15));
        repartition.put("DragonsHautDroit", (int) (nombreEnnemis * 0.15));
        repartition.put("CowboysBasDroit", (int) (nombreEnnemis * 0.10));
        repartition.put("DragonsBasDroit", (int) (nombreEnnemis * 0.25));
        return repartition;
    }

    private void placerEnnemisRegion(int nombreEnnemis, Class<? extends Ennemi> type, int minY, int maxY, int minX, int maxX) {
        Random rand = new Random();
        for (int i = 0; i < nombreEnnemis; i++) {
            try {
                Ennemi ennemi = type.getDeclaredConstructor(Terrain.class, Environnement.class).newInstance(terrain, this);
                placerEnnemiAleatoirement(rand, ennemi, minY, maxY, minX, maxX);
                ennemis.add(ennemi);
                ajouterBarreDeVie(ennemi.getBarreDeVie());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void placerEnnemiAleatoirement(Random rand, Ennemi ennemi, int minY, int maxY, int minX, int maxX) {
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

    public void ajouterBarreDeVie(BarreDeVie b) {
        barreDeVies.add(b);
    }

    public void ajouterFleche(Fleche f) {
        fleches.add(f);
    }

    public void ajouterBouleDeFeu(BouleDeFeu bdf) {
        boulesDeFeu.add(bdf);
    }

    public void unTour() {
        deplacerEnnemis();
        gererProjectiles();
        gererEffetsLink();
        tours++;
    }

    private void deplacerEnnemis() {
        for (Iterator<Ennemi> iterator = ennemis.iterator(); iterator.hasNext(); ) {
            Ennemi ennemi = iterator.next();
            ennemi.seDeplacer(link);
            mettreAJourBarreDeVie(ennemi);
            if (!ennemi.estVivant()) {
                iterator.remove();
            }
        }
    }

    private void mettreAJourBarreDeVie(Ennemi ennemi) {
        BarreDeVie barre = ennemi.getBarreDeVie();
        barre.setX(ennemi.getX());
        barre.setY(ennemi.getY());
        barre.setVieActuelle(ennemi.getPointVie());
        barre.miseAJourVieTotale();
    }

    private void gererProjectiles() {
        gererBoulesDeFeu();
    }

    private void gererBoulesDeFeu() {
        for (Iterator<BouleDeFeu> iterator = boulesDeFeu.iterator(); iterator.hasNext(); ) {
            BouleDeFeu bdf = iterator.next();
            if (bdf.isActive()) {
                bdf.deplacer();
                if (tours - bdf.getCreationTour() >= 50) {
                    bdf.explosion();
                }
            } else {
                iterator.remove();
            }
        }
    }

    private void gererEffetsLink() {
        if (link.isBrule()) {
            link.brulure();
        }
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

    public boolean verifierVictoire() {
        int x = link.getX();
        int y = link.getY();
        return terrain.getTab()[y / 32][x / 32] == 12;
    }

    public Gardien verifierRencontreLinkGardien() {
        for (Gardien gardien : gardiens) {
            if (link.getX() / 32 == gardien.getX() / 32 && link.getY() / 32 == gardien.getY() / 32) {
                return gardien;
            }
        }
        return null;
    }

    public void ajouterBrulure() {
        link.setBrule();
    }
}
