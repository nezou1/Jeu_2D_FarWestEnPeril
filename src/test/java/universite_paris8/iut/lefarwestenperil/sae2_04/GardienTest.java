package universite_paris8.iut.lefarwestenperil.sae2_04;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes.Marteau;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Gardien;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Link;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GardienTest {

    private Gardien gardien;
    private Environnement env;
    private Link link;

    @BeforeEach
    void setUp() {
        env = new Environnement(new Terrain(),link);
        List<String> choix = Arrays.asList("Choix 1", "Choix 2", "Choix 3");
        gardien = new Gardien(10, 20, "Question test?", choix, "Choix 2", "Bravo!", 0, env);

    }

    @Test
    void testGetX() {
        assertEquals(10, gardien.getX());
    }

    @Test
    void testGetY() {
        assertEquals(20, gardien.getY());
    }

    @Test
    void testGetQuestion() {
        assertEquals("Question test?", gardien.getQuestion());
    }

    @Test
    void testGetChoix() {
        List<String> expectedChoix = Arrays.asList("Choix 1", "Choix 2", "Choix 3");
        assertEquals(expectedChoix, gardien.getChoix());}

    @Test
    void testGetBonneReponse() {
        assertEquals("Choix 2", gardien.getBonneReponse());
    }

    @Test
    void testGetMessageReussite() {
        assertEquals("Bravo!", gardien.getMessageReussite());
    }

    @Test
    void testGetMessageEchec() {
        assertEquals("Mauvaise réponse! Vous perdez 2 points de vie.", gardien.getMessageEchec());
    }

    @Test
    void testIsRepondu() {
        assertFalse(gardien.isRepondu());
        gardien.setRepondu(true);
        assertTrue(gardien.isRepondu());
    }

    @Test
    void testSetDernierInterrogatoire() {
        long time = System.currentTimeMillis();
        gardien.setDernierInterrogatoire(time);
        assertEquals(time, gardien.getDernierInterrogatoire());
    }

    @Test
    void testRecompenseMarteau() {
        gardien = new Gardien(10, 20, "Question test?", Arrays.asList("Choix 1", "Choix 2"), "Choix 2", "Bravo!", 0, env);
        gardien.recompense(link);
        assertTrue(link.getArme() instanceof Marteau);
    }

    @Test
    void testRecompensePointsVie() {
        gardien = new Gardien(10, 20, "Question test?", Arrays.asList("Choix 1", "Choix 2"), "Choix 2", "Bravo!", 1, env);
        int pointsVieInitiaux = link.getPointVieMax();
        gardien.recompense(link);
        assertEquals(pointsVieInitiaux + 4, link.getPointVieMax());
    }
}