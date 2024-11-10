package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;

/**
 * Classe EntiteMobile:
 *      <p>
 *          Cette classe est une sous-classe de Entite qui s'occupe de la gestion de toutes les entités pouvant se déplacer
 *      </p>
 *      Elle possède:
 *      <ul>
 *          <li>des coordonnées x et y</li>
 *          <li>une {@link Direction direction}</li>
 *          <li>une {@code vitesse}</li>
 *          <li>un {@link Environnement environnement</li>
 *      </ul>
 *      Elle peut se déplacer dans l'environnement
 */


public class EntiteMobile extends Entite {
    private final IntegerProperty x;
    private final IntegerProperty y;
    private Direction dir;
    private int vitesse;
    private final Environnement env;

    public EntiteMobile(String id,int x, int y, Direction direction, int vitesse, Environnement env) {
        super(id);
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.dir = direction;
        this.vitesse = vitesse;
        this.env = env;
    }

    public int getX() {
        return this.x.getValue();
    }
    public void setX(int x) {
        this.x.setValue(x);
    }
    public IntegerProperty xProperty() {
        return this.x;
    }

    public int getY() {
        return this.y.getValue();
    }
    public void setY(int y) {
        this.y.setValue(y);
    }
    public IntegerProperty yProperty() {
        return this.y;
    }

    public Direction getDirection(){
        return dir;
    }
    public void setDirection(Direction d){
        dir = d;
    }

    public int getDx() {
        return this.dir.getDx();
    }
    public int getDy() {
        return this.dir.getDy();
    }

    public int getVitesse() {
        return this.vitesse;
    }
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public Environnement getEnv() {
        return this.env;
    }

    /**
     * Cette méthode gère le déplacement de l'entité:
     * <ol>
     *     <li>Elle calcule le prochain emplacement</li>
     *     <li>Elle vérifie si l'emplacement est possible {@link Environnement#estMarchable(int, int)}</li>
     *     <li> si oui, elle modifie l'emplacement actuel par ceux calculer  ({@link #setX(int)}, {@link #setY(int)}),<br>
     *     Sinon elle rectifie les nouvelles coordonnées {@link #rectifieCoordonnee(int, int)}</li>
     * </ol>
     */
    public void seDeplace(){
        int newX = getX() + vitesse * getDx();
        int newY = getY() + vitesse * getDy();
        if (!getEnv().getTerrain().estMarchable(newX, newY)){
            newX = rectifieCoordonnee(newX,getEnv().getTerrain().getLargeur());
            newY = rectifieCoordonnee(newY,getEnv().getTerrain().getHauteur());
        }
        setX(newX);
        setY(newY);
    }

    /** Cette méthode rectifie la valeur d'une coordonnée qui est en dehors du terrain par rapport à une limite donnée
     *
     * @return int
     */
    private int rectifieCoordonnee(int coordonnee, int valMax){
        if (coordonnee < 0)
            return 0;
        else if (coordonnee > valMax)
            return --valMax;
        else return coordonnee;
    }
}
