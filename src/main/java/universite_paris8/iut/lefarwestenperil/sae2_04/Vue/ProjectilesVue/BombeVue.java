package universite_paris8.iut.lefarwestenperil.sae2_04.Vue.ProjectilesVue;

import javafx.scene.layout.Pane;

import universite_paris8.iut.lefarwestenperil.sae2_04.Main;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Projectiles.Projectile;


public class BombeVue extends ExplosifVue{

    public BombeVue(Pane pane, Projectile projectile) {
        super(pane, projectile,
                Main.class.getResource("bombe.png"),
                Main.class.getResource("bombeExp.wav"),
                Main.class.getResource("explosion.gif"));
    }

//    public void creerBombe(Bombe bombe) {
//
//        Timeline animation = new Timeline(
//                new KeyFrame(Duration.millis(50), event -> {
//                    double newX = ivBombe.getX() + (bombe.getImpactX() - ivBombe.getX()) / 10;
//                    double newY = ivBombe.getY() + (bombe.getImpactY() - ivBombe.getY()) / 10;
//                    Platform.runLater(() -> {
//                        ivBombe.setX(newX);
//                        ivBombe.setY(newY);
//                    });
//                })
//        );
//        animation.setCycleCount(10);
//        animation.play();
//
//        animation.setOnFinished(event -> {
//
//        });
//    }

}
