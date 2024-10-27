package universite_paris8.iut.lefarwestenperil.sae2_04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.BouleDeFeu;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Link;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

import static org.junit.jupiter.api.Assertions.*;

public class BouleDeFeuTest {
    private Environnement env;
    private Link link;
    private BouleDeFeu bouleDeFeu;

    @BeforeEach
    public void setUp() {
        Terrain terrain = new Terrain();
        link = new Link(terrain);
        env = new Environnement(terrain, link);
        bouleDeFeu = new BouleDeFeu(0, 0, 0,1, env);//va vers le bas
    }

    @Test
    public void testBouleDeFeuInitialisation() {
        assertEquals(0, bouleDeFeu.getX());
        assertEquals(0, bouleDeFeu.getY());
    }

    @Test
    public void testDeplacerVersCible() {
        link.setX(100);
        link.setY(100);
        bouleDeFeu.agit();
        assertTrue(bouleDeFeu.getX() > 0);
        assertTrue(bouleDeFeu.getY() > 0);
    }

    @Test
    public void testExplosion() {
        bouleDeFeu.desactivation();
        assertFalse(bouleDeFeu.isActive());
    }

    @Test
    public void testInfligerDegats() {
        int initialPV = link.getPointVie();
        bouleDeFeu.infligerDegats(link);
        assertEquals(initialPV - bouleDeFeu.getDegats() + link.getPointDefense(), link.getPointVie());
    }

    @Test
    public void testDeplacerEtExplosion() {
        link.setX(4);
        link.setY(4);
        bouleDeFeu.agit();
        assertFalse(bouleDeFeu.isActive());
        assertTrue(link.getPointVie() < 1600); // assuming initial HP of Link is 1600
    }
}
