package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes.Arme;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes.Bombe;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Deplacement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

import java.util.ArrayList;
import java.util.List;

public class Personnage extends Deplacement {
    protected int tailleTuile = 32;
    private int pointVie;
    private int pointAttaque;
    private int pointDefense;
    private Environnement env;
    private List<Arme> armes;
    private Arme armeActuelle;
    private int indexArmeActuelle;
    private Terrain terrain;
    private boolean brule;
    private static int compteurBrulure;
    private int pointVieMax;
    private static final Logger LOGGER = LogManager.getLogger(Personnage.class);

    public Personnage(int x, int y, int pointVie, int pointAttaque, int pointDefense, Terrain terrain, int vitesse, int direction) {
        super(x, y, vitesse, direction); // Initialisation de x, y, vitesse, et direction via la superclasse
        this.pointVie = pointVie;
        this.pointVieMax = pointVie;
        this.pointAttaque = pointAttaque;
        this.pointDefense = pointDefense;
        this.armes = new ArrayList<>();
        this.armeActuelle = null;
        this.terrain = terrain;
        this.brule = false;
        this.compteurBrulure = 0;
    }

    public boolean isBrule() {
        return this.brule;
    }

    public void brulure() {
        if (compteurBrulure % 10 == 0) {
            this.setPointVie(getPointVie() - 1);
            LOGGER.log(Level.INFO, "Aie, notre personnage s'est brulé :)");
            if (compteurBrulure == 30) {
                compteurBrulure = 0;
                brule = false;
            }
        }
        compteurBrulure++;
    }

    public void ajouterArme(Arme arme) {
        this.armes.add(arme);
        if (this.armes.size() == 1) {
            this.armeActuelle = arme;
        }
    }

    public Arme getArme() {
        return armeActuelle;
    }

    public int getPointVieMax() {
        return pointVieMax;
    }

    public void setPointVieMax(int pointVieMax) {
        this.pointVieMax = pointVieMax;
    }

    public void changerArmeSuivante() {
        if (!armes.isEmpty()) {
            indexArmeActuelle = (indexArmeActuelle + 1) % armes.size();
            armeActuelle = armes.get(indexArmeActuelle);
        }
    }

    public void changerArmePrecedente() {
        if (!armes.isEmpty()) {
            indexArmeActuelle = (indexArmeActuelle - 1 + armes.size()) % armes.size();
            armeActuelle = armes.get(indexArmeActuelle);
        }
    }

    public int getDirection() {
        return super.getDirection();
    }

    public void attaque(List<Ennemi> cibles) {
        if (armeActuelle != null) {
            if (armeActuelle instanceof Bombe) {
                Bombe bombe = (Bombe) armeActuelle;
                if (bombe.estEnCours()) {
                    LOGGER.log(Level.TRACE, "Une bombe est déjà en cours. Veuillez attendre l'explosion");
                    return;
                }
            }
            armeActuelle.attaquer(this, cibles);
        } else {
            LOGGER.log(Level.INFO, "Aucune arme pour l'attaque directionnelle.");
        }
    }

    public void setPointVie(int pointVie) {
        this.pointVie = pointVie;
    }

    public boolean estVivant() {
        return this.pointVie > 0;
    }

    public IntegerProperty vieProperty() {
        return new SimpleIntegerProperty(pointVie);
    }

    public int getTailleTuile() {
        return tailleTuile;
    }

    public int getPointVie() {
        return pointVie;
    }

    public int getPointAttaque() {
        return pointAttaque;
    }

    public int getPointDefense() {
        return pointDefense;
    }

    public Environnement getEnv() {
        return env;
    }

    public int getVitesseDeplacement() {
        return getVitesse();
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void recevoirDegats(int pointsDegats) {
        int degatReel = pointsDegats - this.pointDefense;
        if (degatReel > 0) {
            this.pointVie = Math.max(this.pointVie - degatReel, 0);
        }
    }

    public Arme getArmeActuelle() {
        return armeActuelle;
    }

    public List<Arme> getArmes() {
        return this.armes;
    }

    public void ramasserArme(Arme arme) {
        this.armes.add(arme);
    }

    public void setArmeActuelle(Arme armeActuelle) {
        this.armeActuelle = armeActuelle;
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "pointVie=" + pointVie +
                ", pointAttaque=" + pointAttaque +
                ", pointDefense=" + pointDefense +
                ", armes=" + armes +
                '}';
    }

    public void setBrule() {
        this.brule = true;
    }

    public int getX() {
        return super.xProperty().get();
    }

    public int getY() {
        return super.yProperty().get();
    }

    public void setX(int x) {
        super.xProperty().set(x);
    }

    public void setY(int y) {
        super.yProperty().set(y);
    }
}
