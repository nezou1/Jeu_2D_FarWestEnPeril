package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import javafx.beans.property.*;

public class BarreDeVie  {

    private IntegerProperty x, y;
    private DoubleProperty vieTotale;
    private Double vie;
    private Double vieMax;
    private String id;

    public BarreDeVie(int vie, int vieMax, String id, int x, int y){
        this.x = new SimpleIntegerProperty(x-5);
        this.y = new SimpleIntegerProperty(y-5);
        this.vie= (double) vie;
        this.vieMax = (double)vieMax;
        this.id = id;
        this.vieTotale = new SimpleDoubleProperty(vie/vieMax);
    }

    public double getVieTotale() {
        return vieTotale.getValue();
    }

    public DoubleProperty vieTotaleProperty() {
        return vieTotale;
    }

    public void miseAJourVieTotale() {
        this.vieTotale.setValue((double) vie/ vieMax);
    }

    public void setVie(double vie) {
        this.vie = vie;
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
