package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites;

import javafx.beans.property.*;

/**
 * BarreDeVie permet de suivre et de gérer visuellement l'état de santé d'un personnage, d'un objet,
 * ou de tout élément ayant un concept de "vie" ou de "santé"
 */

public class BarreDeVie extends Entite {

    private final IntegerProperty x;
    private final IntegerProperty y;

    private final DoubleProperty vieRestante;
    private double vieActuelle;
    private final double vieMax;


    public BarreDeVie(int x, int y, int vie) {
        super("BarreDeVie");
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

    public final int getY() {
        return this.yProperty().getValue();
    }

    public IntegerProperty xProperty() {
        return x;
    }

    public IntegerProperty yProperty() {
        return y;
    }

    public double getVieRestante() {
        return vieRestante.getValue();
    }

    public DoubleProperty vieRestanteProperty() {
        return vieRestante;
    }

    // === SETTERS ===

    public final void setX(int x) {
        this.xProperty().setValue(x - 5);
    }

    public final void setY(int y) {
        this.yProperty().setValue(y - 13);
    }

    public void setVieActuelle(double vieActuelle) {
        this.vieActuelle = vieActuelle;
    }

    // === MÉTHODES DE MISE À JOUR ===

    public void miseAJourVieTotale() {
        this.vieRestante.setValue(vieActuelle / vieMax);
    }
}
