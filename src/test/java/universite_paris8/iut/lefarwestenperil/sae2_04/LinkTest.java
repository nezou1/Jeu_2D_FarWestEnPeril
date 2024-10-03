package universite_paris8.iut.lefarwestenperil.sae2_04;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Link;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {
    private Terrain terrain;
    private Link link;

    @BeforeEach
    void setUp() {
        terrain = new Terrain(); // Créez un terrain de test, par exemple 20x20
        link = new Link(terrain);
    }

    @Test
    void testDeplacerHaut() {
        int initialY = link.getY();
        link.deplacerHaut();
        assertEquals(initialY - 10, link.getY());
    }

    @Test
    void testDeplacerBas() {
        int initialY = link.getY();
        link.deplacerBas();
        assertEquals(initialY + 10, link.getY());
    }

    @Test
    void testDeplacerGauche() {
        int initialX = link.getX();
        link.deplacerGauche();
        assertEquals(initialX - 10, link.getX());
    }

    @Test
    void testDeplacerDroite() {
        int initialX = link.getX();
        link.deplacerDroite();
        assertEquals(initialX + 10, link.getX());
    }

    @Test
    void testDeplacerLimiteTerrain() {
        // Assurez-vous que Link ne peut pas sortir du terrain
        link.setX(0);
        link.setY(0);

        link.deplacerGauche();
        assertEquals(0, link.getX());

        link.deplacerHaut();
        assertEquals(0, link.getY());

        // Déplacez Link vers le bas et à droite pour vérifier les limites
        link.deplacerDroite();
        link.deplacerDroite();
        link.deplacerDroite();
        link.deplacerDroite();
        assertEquals(20, link.getX());

        link.deplacerBas();
        link.deplacerBas();
        link.deplacerBas();
        link.deplacerBas();
        assertEquals(20, link.getY());
    }

    @Test
    void testDeplacerCollisionTerrain() {
        // Modifiez le terrain pour qu'il ne soit pas marchable là où Link se déplace
        terrain.estMarchable(1, 1);

        // Placez Link à une position où il va rencontrer une collision
        link.setX(10);
        link.setY(10);

        link.deplacerDroite();
        assertEquals(10, link.getX());

        link.deplacerBas();
        assertEquals(10, link.getY());
    }

    @Test
    void testToString() {
        String expectedString = "Link : Personnage{x=1600, y=1500}";
        assertEquals(expectedString, link.toString());
    }
}
