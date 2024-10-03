package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Projectiles;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;

import java.util.List;

public class Fleche extends Projectile {
    private List<Ennemi> cibles;
    private int direction;
    private Timeline timeline;


    public Fleche(int x, int y, int direction, List<Ennemi> cibles, Environnement env) {
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
            boolean aTouche = false;
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

            for (Ennemi ennemi : cibles) {
                double centreCibleX = ennemi.getX() + ennemi.getLargeurImage() / 2;
                double centreCibleY = ennemi.getY() + ennemi.getHauteurImage() / 2;
                double distance = Math.sqrt(Math.pow(centreCibleX - getX(), 2) + Math.pow(centreCibleY - getY(), 2));
                if (distance <= 10) {
                    ennemi.recevoirDegats(degats);
                    aTouche = true;
                    break;
                }
            }

            if (aTouche || (getX() == cibleX && getY() == cibleY)) {
                timeline.stop();
                getEnv().getFleches().remove(this);
            }

            System.out.println("Flèche se déplace à (" + x + ", " + y + ")");
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
