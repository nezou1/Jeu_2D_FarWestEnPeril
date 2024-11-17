package universite_paris8.iut.lefarwestenperil.sae2_04.Vue.ProjectilesVue;

import javafx.scene.layout.Pane;

import universite_paris8.iut.lefarwestenperil.sae2_04.Main;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.Projectile;


public class BombeVue extends ExplosifVue{

    public BombeVue(Pane pane, Projectile projectile) {
        super(
                pane, projectile,
                Main.class.getResource("bombe.png"),
                Main.class.getResource("bombeExp.wav"),
                Main.class.getResource("explosion.gif")
        );
    }
}
