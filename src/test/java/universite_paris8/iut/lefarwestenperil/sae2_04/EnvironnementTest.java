package universite_paris8.iut.lefarwestenperil.sae2_04;


import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.*;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Direction;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants.*;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.PNJs.Gardien2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Projectiles.Projectile;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Projectiles.BouleDeFeu;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Etats.EtatBrulure;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnvironnementTest  {
    private Environnement2 environnement;
    private Terrain terrain;
    private Link2 link;

    @BeforeEach
    void setUp() {
        environnement = new Environnement2();
        terrain = Environnement2.getTerrain(); // Supposons que le terrain est 20x20
        link = Environnement2.getLink2();
    }

    @Test
    void testAjouterGardien() {
        Gardien2 gardien = new Gardien2(100, 100, "Question", new ArrayList<>(), "Réponse", "Message", 0, environnement);
        environnement.ajouterGardien(gardien);
        ObservableList<Gardien2> gardiens = environnement.getGardiens();
        assertEquals(1, gardiens.size());
        assertEquals(gardien, gardiens.get(0));
    }



    @Test
    void testUnTour() {
        Cowboy2 cowboy = new Cowboy2(environnement);
        Environnement2.getEnnemis().add(cowboy);
        environnement.unTour();
        assertEquals(1, environnement.getTours());
    }



    @Test
    void testAjouterBouleDeFeu() {
        BouleDeFeu bouleDeFeu = new BouleDeFeu(1,2, Direction.DROIT,environnement);//va vers la droite
        Environnement2.ajouterProjectile(bouleDeFeu);
        ObservableList<Projectile> boulesDeFeu = Environnement2.getProjectiles();
        assertEquals(1, boulesDeFeu.size());
        assertEquals(bouleDeFeu, boulesDeFeu.get(0));
    }

    @Test
    void testGetEnnemisDansRayon() {
        Ennemi2 ennemi1 = new Cowboy2(environnement);
        ennemi1.setX(10);
        ennemi1.setY(10);
        Ennemi2 ennemi2 = new Dragon2(environnement);
        ennemi2.setX(100);
        ennemi2.setY(100);
        Environnement2.getEnnemis().addAll(ennemi1, ennemi2);
        List<Ennemi2> ennemisDansRayon = environnement.getEnnemisDansRayon(10, 10, 20);
        assertEquals(1, ennemisDansRayon.size());
        assertEquals(ennemi1, ennemisDansRayon.get(0));
    }

    @Test
    void testAjouterQuestionGardien() {
        environnement.ajouterQuestionGardien();
        ObservableList<Gardien2> gardiens = environnement.getGardiens();
        assertEquals(3, gardiens.size());
    }

    @Test
    void testAjouterBrulure() {
        link.setEtat(new EtatBrulure());
        assertTrue(link.getEtat().isActive());
    }

    @Test
    void testVerifierVictoire() {
        link.setX(32);
        link.setY(32);
        terrain.getTab()[1][1] = 12;
        assertTrue(environnement.verifierVictoire());
    }
}
