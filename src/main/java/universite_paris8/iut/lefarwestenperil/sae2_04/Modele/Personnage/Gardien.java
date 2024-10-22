package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes.Marteau;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;

import java.util.List;

public class Gardien {
    private final int x;
    private final int y;
    private final String question;
    private final List<String> choix;
    private final String bonneReponse;
    private final String messageReussite;
    private final String messageEchec;
    private final int recompense;
    private final Environnement env;
    private boolean repondu;
    private long dernierInterrogatoire;

    public Gardien(int x, int y, String question, List<String> choix, String bonneReponse, String messageReussite, int recompense, Environnement env) {
        this.x = x;
        this.y = y;
        this.question = question;
        this.choix = choix;
        this.bonneReponse = bonneReponse;
        this.messageReussite = messageReussite;
        this.messageEchec = "Mauvaise réponse! Vous perdez 2 points de vie.";
        this.repondu = false;
        this.dernierInterrogatoire = 0;
        this.recompense = recompense;
        this.env = env;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getChoix() {
        return choix;
    }

    public String getBonneReponse() {
        return bonneReponse;
    }

    public String getMessageReussite() {
        return messageReussite;
    }

    public String getMessageEchec() {
        return messageEchec;
    }

    public boolean isRepondu() {
        return repondu;
    }

    public void setRepondu(boolean repondu) {
        this.repondu = repondu;
    }

    public long getDernierInterrogatoire() {
        return dernierInterrogatoire;
    }

    public void setDernierInterrogatoire(long dernierInterrogatoire) {
        this.dernierInterrogatoire = dernierInterrogatoire;
    }

    public void recompense(Link link) {
        switch (recompense) {
            case 0:
                link.ramasserArme(new Marteau(0, 0, env));
                break;

            case 1:
                link.setPointVie(link.getPointVieMax() + 4);
                break;

        }

    }
}
