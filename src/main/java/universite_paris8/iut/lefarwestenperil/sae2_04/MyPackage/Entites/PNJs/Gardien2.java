package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.PNJs;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants.Link2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Environnement2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Utilitaires.PointDeVie;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.StrategieAttaque.MarteauW;

import java.util.List;

//La classe Gardien représente un personnage non-joueur dans le jeu qui pose des questions au joueur.
//Elle gère la position du gardien, la question posée, les choix de réponse, la bonne réponse, et les messages de réussite ou d'échec.
//La classe inclut également un système de récompense pour le joueur (Link) en cas de bonne réponse, pouvant être soit une nouvelle arme, soit des points de vie supplémentaires.


public class Gardien2 extends PNJ {

    private final String question;

    private final List<String> choix;
    private final String bonneReponse;

    private final String messageReussite;
    private final String messageEchec;

    private boolean repondu;
    private long dernierInterrogatoire;
    private final int recompense;


    public Gardien2(int x, int y, String question, List<String> choix, String bonneReponse, String messageReussite, int recompense, Environnement2 env) {
        super("Gardien",env,x,y);
        this.question = question;
        this.choix = choix;
        this.bonneReponse = bonneReponse;
        this.messageReussite = messageReussite;
        this.messageEchec = "Mauvaise réponse! Vous perdez 2 points de vie.";
        this.repondu = false;
        this.dernierInterrogatoire = 0;
        this.recompense = recompense;
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

    public void recompense(Link2 link) {
        switch (recompense) {
            case 0:
                link.ajouterArme(new MarteauW());
                break;

            case 1:
                link.setPointVie(PointDeVie.PVLINK +4);
                break;
        }

    }

    @Override
    public void agit() {

    }
}