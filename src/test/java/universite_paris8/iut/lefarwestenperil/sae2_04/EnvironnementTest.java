package universite_paris8.iut.lefarwestenperil.sae2_04;


import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.PNJs.Gardien;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Cowboy;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Dragon;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Link;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.BouleDeFeu;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.Projectile;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Etats.EtatBrulure;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EnvironnementTest {
    private Environnement environnement;
    private Terrain terrain;
    private Link link;

    @BeforeEach
    void setUp() {
        environnement = new Environnement();
        terrain = environnement.getTerrain(); // Supposons que le terrain est 20x20
        link = environnement.getLink2();
    }

    @Test
    void testAjouterGardien() {
        Gardien gardien = new Gardien(100, 100, "Question", new ArrayList<>(), "Réponse", "Message", 0, environnement);
        environnement.ajouterGardien(gardien);
        ObservableList<Gardien> gardiens = environnement.getGardiens();
        assertEquals(1, gardiens.size());
        assertEquals(gardien, gardiens.get(0));
    }


    @Test
    void testUnTour() {
        Cowboy cowboy = new Cowboy(environnement);
        environnement.getEnnemis().add(cowboy);
        environnement.unTour();
        assertEquals(1, environnement.getTours());
    }


    @Test
    void testAjouterBouleDeFeu() {
        BouleDeFeu bouleDeFeu = new BouleDeFeu(1, 2, Direction.DROIT, environnement);//va vers la droite
        environnement.ajouterProjectile(bouleDeFeu);
        ObservableList<Projectile> boulesDeFeu = environnement.getProjectiles();
        assertEquals(1, boulesDeFeu.size());
        assertEquals(bouleDeFeu, boulesDeFeu.get(0));
    }

    @Test
    void testGetEnnemisDansRayon() {
        Ennemi ennemi1 = new Cowboy(environnement);
        ennemi1.setX(10);
        ennemi1.setY(10);
        Ennemi ennemi2 = new Dragon(environnement);
        ennemi2.setX(100);
        ennemi2.setY(100);
        environnement.getEnnemis().addAll(ennemi1, ennemi2);
        List<Ennemi> ennemisDansRayon = environnement.getEnnemisDansRayon(10, 10, 20);
        assertEquals(1, ennemisDansRayon.size());
        assertEquals(ennemi1, ennemisDansRayon.get(0));
    }

    @Test
    void testAjouterQuestionGardien() {
        environnement.ajouterQuestionGardien();
        ObservableList<Gardien> gardiens = environnement.getGardiens();
        assertEquals(3, gardiens.size());
    }

    @Test
    void testAjouterBrulure() {
        link.ajoutEtat(new EtatBrulure());
        assertTrue(link.getEtat().isActive());
    }

    @Test
    void testVerifierVictoire() {
        link.setX(32);
        link.setY(32);
        terrain.getDonneeTerrain()[1][1] = 12;
        assertTrue(environnement.verifierVictoire());
    }
}
