package universite_paris8.iut.lefarwestenperil.sae2_04;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Link;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {
    private Terrain terrain;
    private Link link;

    @BeforeEach
    void setUp() {
//        new Environnement2();
        terrain = new Terrain(); // Créez un terrain de test, par exemple 20x20
        link = new Link(new Environnement());
    }

    @Test
    void testDeplacerHaut() {
        int initialY = link.getY();
        link.deplacerHaut();
        link.seDeplace();
        assertEquals(initialY - 10, link.getY());
    }

    @Test
    void testDeplacerBas() {
        int initialY = link.getY();
        link.deplacerBas();
        link.seDeplace();
        assertEquals(initialY + 10, link.getY());
    }

    @Test
    void testDeplacerGauche() {
        int initialX = link.getX();
        link.deplacerGauche();
        link.seDeplace();
        assertEquals(initialX - 10, link.getX());
    }

    @Test
    void testDeplacerDroite() {
        int initialX = link.getX();
        link.deplacerDroite();
        link.seDeplace();
        assertEquals(initialX + 10, link.getX());
    }

    @Test
    void testDeplacerLimiteTerrain() {
        // Assurez-vous que Link ne peut pas sortir du terrain
        link.setX(180);
        link.setY(180);

        link.deplacerGauche();
        link.seDeplace();
        assertEquals(170, link.getX());

        link.deplacerHaut();
        link.seDeplace();
        assertEquals(170, link.getY());

        // Déplacez Link vers le bas et à droite pour vérifier les limites

        for (int i =0 ; i < 4 ; i++){
            link.deplacerDroite();
            link.seDeplace();
        }
        assertEquals(210, link.getX());

        for (int i =0 ; i < 4 ; i++){
            link.deplacerBas();
            link.seDeplace();
        }
        assertEquals(210, link.getY());
    }

    @Test
    void testDeplacerCollisionTerrain() {
        // Modifiez le terrain pour qu'il ne soit pas marchable là où Link se déplace
        terrain.estMarchable(1, 1);

        // Placez Link à une position où il va rencontrer une collision
        link.setX(10);
        link.setY(10);

        link.deplacerDroite();
        link.seDeplace();
        assertEquals(10, link.getX());

        link.deplacerBas();
        link.seDeplace();
        assertEquals(10, link.getY());
    }

    @Test
    void testToString() {
        String expectedString = "Link : ";
        assertEquals(expectedString, link.toString());
    }
}
