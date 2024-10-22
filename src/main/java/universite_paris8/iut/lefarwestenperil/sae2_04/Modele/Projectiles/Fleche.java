package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Ennemi;

import java.util.List;

public class Fleche extends Projectile {
    private final int direction;
    private List<Ennemi> cibles;
    private Timeline timeline;


    public Fleche(int x, int y, int direction, Environnement env) {
        super(x, y + 10, direction == 0 ? x + 200 : direction == 2 ? x - 200 : x, direction == 1 ? y + 200 + 10 : direction == 3 ? y - 200 + 10 : y + 10, 6, 10, env);
        this.cibles = cibles;
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    @Override
    public void deplacer() {
        timeline = new Timeline(new KeyFrame(Duration.millis(50), event -> {

            if (direction == 0) {
                setX(getX() + vitesse);
                if (getX() >= cibleX) setX(cibleX);
            } else if (direction == 1) {
                setY(getY() + vitesse);
                if (getY() >= cibleY) setY(cibleY);
            } else if (direction == 2) {
                setX(getX() - vitesse);
                if (getX() <= cibleX) setX(cibleX);
            } else if (direction == 3) {
                setY(getY() - vitesse);
                if (getY() <= cibleY) setY(cibleY);
            }

            if (cibleEstProche() || (getX() == cibleX && getY() == cibleY)) {
                timeline.stop();
                getEnv().getFleches().remove(this);
            }

        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public boolean cibleEstProche() {
        if (cibles != null && cibles.size() > 0) {


            for (Ennemi ennemi : cibles) {
                double centreCibleX = ennemi.getX() + ennemi.getLargeurImage() / 2;
                double centreCibleY = ennemi.getY() + ennemi.getHauteurImage() / 2;
                double distance = Math.sqrt(Math.pow(centreCibleX - getX(), 2) + Math.pow(centreCibleY - getY(), 2));
                if (distance <= 10) {
                    ennemi.recevoirDegats(degats);
                    return true;
                }
            }
        }
        return false;
    }
}
