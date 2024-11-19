package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;

/**
 * BarreDeVie permet de suivre et de gérer visuellement l'état de santé d'un personnage, d'un objet,
 * ou de tout élément ayant un concept de "vie" ou de "santé"
 */

public class BarreDeVie extends Entite {

    private final IntegerProperty x;
    private final IntegerProperty y;

    private final DoubleProperty vieRestante;
    private final double vieMax;
    private double vieActuelle;


    public BarreDeVie(int x, int y, int vie, Environnement environnement) {
        super("BarreDeVie", environnement);
        this.x = new SimpleIntegerProperty(x - 5);
        this.y = new SimpleIntegerProperty(y - 5);
        this.vieActuelle = vie;
        this.vieMax = vie;
        this.vieRestante = new SimpleDoubleProperty(vieActuelle / vieMax);
    }

    // === GETTERS ===

    public final int getX() {
        return this.xProperty().getValue();
    }

    public final void setX(int x) {
        this.xProperty().setValue(x - 5);
    }

    public final int getY() {
        return this.yProperty().getValue();
    }

    public final void setY(int y) {
        this.yProperty().setValue(y - 13);
    }

    public IntegerProperty xProperty() {
        return x;
    }

    public IntegerProperty yProperty() {
        return y;
    }

    // === SETTERS ===

    public double getVieRestante() {
        return vieRestante.getValue();
    }

    public DoubleProperty vieRestanteProperty() {
        return vieRestante;
    }

    public void setVieActuelle(double vieActuelle) {
        this.vieActuelle = vieActuelle;
    }

    // === MÉTHODES DE MISE À JOUR ===

    public void miseAJourVieTotale() {
        this.vieRestante.setValue(vieActuelle / vieMax);
    }
}
