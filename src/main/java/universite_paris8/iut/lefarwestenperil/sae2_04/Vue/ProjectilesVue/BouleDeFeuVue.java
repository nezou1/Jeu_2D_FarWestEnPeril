package universite_paris8.iut.lefarwestenperil.sae2_04.Vue.ProjectilesVue;


import javafx.scene.layout.Pane;

import universite_paris8.iut.lefarwestenperil.sae2_04.Main;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.Projectile;

public class BouleDeFeuVue extends ExplosifVue{

    public BouleDeFeuVue(Pane pane, Projectile projectile) {
        super(pane, projectile,
                Main.class.getResource("bouledefeu.png"),
                Main.class.getResource("explosion.wav"),
                Main.class.getResource("explosion_feu.gif"));
    }
}