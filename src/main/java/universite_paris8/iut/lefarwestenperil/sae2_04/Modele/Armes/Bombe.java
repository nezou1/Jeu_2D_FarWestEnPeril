package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes;


import javafx.scene.layout.Pane;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.ArmesVue.BombeVue;

import java.util.List;

public class Bombe extends Arme {
    private final Pane panneauDeJeu;
    private final String id = "B";
    private final BombeVue bombeVue;
    private boolean enCours;
    private int impactX;
    private int impactY;

    public Bombe(Pane panneauDeJeu, BombeVue bombeVue) {
        super(20, 400);
        this.panneauDeJeu = panneauDeJeu;
        this.bombeVue = bombeVue;
        this.enCours = false;
    }

    public boolean estEnCours() {
        return enCours;
    }

    public String getId() {
        return id;
    }

    public int getImpactX() {
        return impactX;
    }

    public int getImpactY() {
        return impactY;
    }

    @Override
    public void attaquer(Personnage attaquant) {
        if (enCours) {
            System.out.println("Une bombe est déjà en cours. Veuillez attendre l'explosion.");
            return;
        }

        enCours = true;
        impactX = attaquant.getX();
        impactY = attaquant.getY();

        switch (attaquant.getDirection()) {
            case 0 -> impactX += 64;
            case 1 -> impactY += 64;
            case 2 -> impactX -= 64;
            case 3 -> impactY -= 64;
        }
    bombeVue.creerBombe(this);
        new Thread(() -> {
            try {
                Thread.sleep(500); // Delay for explosion
                cibleProche(attaquant.getEnv().getEnnemis());
                Thread.sleep(3000); // Cooldown period
                enCours = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void cibleProche(List<Ennemi> cibles) {
        for (Ennemi cible : cibles) {
            double centreCibleX = cible.getX() + (double) cible.getLargeurImage() / 2;
            double centreCibleY = cible.getY() + (double) cible.getHauteurImage() / 2;
            double distance = Math.sqrt(Math.pow(centreCibleX - impactX, 2) + Math.pow(centreCibleY - impactY, 2));
            if (distance <= 64) {
                cible.recevoirDegats(getPointAttaque());
                System.out.println("Bombe inflige " + getPointAttaque() + " dégâts à " + cible);
            }
        }
    }

    @Override
    public String toString() {
        return "Bombe : " + super.toString();
    }
}