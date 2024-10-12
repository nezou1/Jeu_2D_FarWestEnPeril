package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import javafx.beans.property.*;

public class BarreDeVie  {

    private IntegerProperty x, y;
    private DoubleProperty vieRestante;
    private Double vieActuelle;
    private Double vieMax;
    private String id;

    public BarreDeVie(int vie, int vieMax, String id, int x, int y){
        this.x = new SimpleIntegerProperty(x-5);
        this.y = new SimpleIntegerProperty(y-5);
        this.vieActuelle = (double) vie;
        this.vieMax = (double)vieMax;
        this.id = id;
        this.vieRestante = new SimpleDoubleProperty(vie/vieMax);
    }

    public double getVieRestante() {
        return vieRestante.getValue();
    }

    public DoubleProperty vieRestanteProperty() {
        return vieRestante;
    }

    public void miseAJourVieTotale() {
        this.vieRestante.setValue((double) vieActuelle / vieMax);
    }

    public void setVieActuelle(double vieActuelle) {
        this.vieActuelle = vieActuelle;
    }

    public IntegerProperty xProperty() {
        return x;
    }

    public IntegerProperty yProperty() {
        return y;
    }

    public String getId() {
        return id;
    }

    public final int getX() {
        return this.xProperty().getValue();
    }

    public final void setX(int x) {
        this.xProperty().setValue(x-5);
    }


    public final int getY() {
        return this.yProperty().getValue();
    }

    public final void setY(int y) {
        this.yProperty().setValue(y-13);
    }


}
