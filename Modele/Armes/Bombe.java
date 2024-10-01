package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.ArmesVue.BombeVue;

import java.util.List;

public class Bombe extends Arme {
    private Pane panneauDeJeu;
    private boolean enCours;
    private int x;
    private int y;
    private int impactX;
    private int impactY;
    private String id;
    private BombeVue bombeVue;

    public Bombe(Pane panneauDeJeu, BombeVue bombeVue) {
        super(20, 400);
        this.panneauDeJeu = panneauDeJeu;
        this.enCours = false;
        this.id = "B" ;
        this.bombeVue = bombeVue;
    }

    public boolean estEnCours() {
        return enCours;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getImpactX() {
        return impactX;
    }

    public int getImpactY() {
        return impactY;
    }

    public String getId() {
        return id;
    }

    @Override
    public void attaquer(Personnage attaquant, List<Ennemi> cibles) {
        if (enCours) {
            System.out.println("Une bombe est déjà en cours. Veuillez attendre l'explosion.");
            return;
        }

        enCours = true;

        int direction = attaquant.getDirection();
        x = attaquant.getX();
        y = attaquant.getY();
        impactX = x;
        impactY = y;

        switch (direction) {
            case 0:
                impactX += 64;
                break;
            case 1:
                impactY += 64;
                break;
            case 2:
                impactX -= 64;
                break;
            case 3:
                impactY -= 64;
                break;
        }

        
        bombeVue.creerBombe(this);

        Timeline explosionDelay = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> {
            for (Ennemi cible : cibles) {
                double centreCibleX = cible.getX() + cible.getLargeurImage() / 2;
                double centreCibleY = cible.getY() + cible.getHauteurImage() / 2;
                double distance = Math.sqrt(Math.pow(centreCibleX - impactX, 2) + Math.pow(centreCibleY - impactY, 2));
                if (distance <= 64) {
                    cible.recevoirDegats(getPointAttaque());
                    System.out.println("Bombe inflige " + getPointAttaque() + " dégâts à " + cible);
                }
            }
        }));
        explosionDelay.setOnFinished(event -> {
            Timeline cooldown = new Timeline(new KeyFrame(Duration.seconds(3), cooldownEvent -> {
                enCours = false;
            }));
            cooldown.play();
        });
        explosionDelay.play();
    }

    @Override
    public String toString() {
        return "Bombe : " + super.toString();
    }
}
