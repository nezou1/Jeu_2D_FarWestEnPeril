package universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.transform.Scale;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.BarreDeVie;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.PNJs.Gardien;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Link;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Projectiles.Projectile;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque.*;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque.AttaqueADistances.Arc;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.StrategieAttaque.AttaqueADistances.LanceurDeBombes;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires.ActionFXML;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires.AudioManager;
import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.*;
import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.PersonnageVue.LinkVue;
import universite_paris8.iut.lefarwestenperil.sae2_04.Vue.VieVue.ListCoeurVue;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable{

    @FXML
    private Pane panneauDeJeu;
    @FXML
    private TilePane tuile;
    private Scale scaleTransform;
    @FXML
    private HBox vieBox;

    @FXML
    public Button boutonRecommencer;
    @FXML
    public Button boutonPrecedent;
    @FXML
    public Button boutonPause;

    private Timeline gameLoop;
    private Environnement env;
    private Link link;
    private LinkVue linkVue;

    private ListCoeurVue coeurVue;
    private MessageVue messageVue;

    private TerrainVue tv;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        env = new Environnement();
        link = env.getLink2();

        tv = new TerrainVue(env.getTerrain(), tuile);
        linkVue = new LinkVue(panneauDeJeu);
        messageVue = new MessageVue();

        tv.creerCarte();
        linkVue.creerLink(link);

        link.ajouterArme(new Tomahawk());
        link.ajouterArme(new Arc());
        link.ajouterArme(new LanceurDeBombes());

        ListChangeListener<Ennemi> listenE = new ListObsEnnemis(panneauDeJeu);
        env.getEnnemis().addListener(listenE);

        ListChangeListener<BarreDeVie> listenB = new ListObsBarreDeVie(panneauDeJeu);
        env.getBarreDeVies().addListener(listenB);

        ListChangeListener<Projectile> listenP = new ListObsProjectiles(panneauDeJeu);
        env.getProjectiles().addListener(listenP);

        env.ajouterQuestionGardien();

        env.ajouterEnnemisAleatoirement(50);
        panneauDeJeu.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.setOnKeyPressed(this::gererTouchePressee);
                newScene.setOnKeyReleased(this::keyReleased);
            }
        });

        scaleTransform = new Scale();
        panneauDeJeu.getTransforms().add(scaleTransform);

        scaleTransform.setPivotX(link.getX()-200);
        scaleTransform.setPivotY(link.getY()-200);

        coeurVue = new ListCoeurVue(link, vieBox);

        initAnimation();
        gameLoop.play();
    }

    @FXML
    private void gererTouchePressee(KeyEvent event) {
//        System.out.println("Touche pressée: " + event.getCode());
        if (gererDeplacement(event.getCode()) || gererAction(event.getCode())) {
            miseAJourZoom();
            verifierRencontreGardien();
        }
    }

    private boolean gererDeplacement(KeyCode code) {
        boolean deplacementEffectue = switch (code) {
            case Z -> {
                link.deplacerHaut();
                yield true;
            }
            case Q -> {
                link.deplacerGauche();
                yield true;
            }
            case S -> {
                link.deplacerBas();
                yield true;
            }
            case D -> {
                link.deplacerDroite();
                yield true;
            }
            default -> false;
        };
        if (deplacementEffectue)
            linkVue.updateImage(link.getDirection(),link.getArme());
        return deplacementEffectue;
    }

    @FXML
    private void keyReleased(KeyEvent keyEvent) {
        link.noWalking();
    }

    /**
     * Cette méthode s'occupe les actions spécifiques du joueur (attaque, changement d'arme, etc.)
     * {@param code}
     * {@return }
     */
    private boolean gererAction(KeyCode code) {
        return switch (code) {
            case I -> {
                gererAttaque();
                yield true;
            }
            case K -> {
                link.changerArmeSuivante();
                yield true;
            }
            case J -> {
                link.changerArmePrecedente();
                yield true;
            }
            case L -> {
                attaquerAvecLanceurDeBombes();
                yield true;
            }
            default -> false;
        };
    }

    private void gererAttaque() {
        if (link.getArme() != null) {
            link.attaquer();
            if (link.getArmeActuelle() instanceof Marteau) {
                tv.creerCarte();
            }
        }
    }

    private void attaquerAvecLanceurDeBombes() {
        StrategieAttaque armeTemporaire = link.getArmeActuelle();
        link.setArmeActuelle(new LanceurDeBombes());
        link.attaquer();
        link.setArmeActuelle(armeTemporaire);
    }

    private void miseAJourZoom(){
        double paneWidth = panneauDeJeu.getWidth();
        double paneHeight = panneauDeJeu.getHeight();
        double linkX = link.getX();
        double linkY = link.getY();

        panneauDeJeu.setTranslateX(-linkX * scaleTransform.getX() + paneWidth / 2);
        panneauDeJeu.setTranslateY(-linkY * scaleTransform.getY() + paneHeight / 2);
    }

    private void verifierRencontreGardien() {
        Gardien g = env.verifierRencontreLinkGardien();
        if (g != null) {
            messageVue.afficherDialogueGardien(g, link);
        }
    }

    private void initAnimation() {
        gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.1),
                ev -> {
                    env.unTour();
                    miseAJourZoom();
                    coeurVue.mettreAJourCoeurs(link.getPointVie());
                    mettreAJourEtatJeu(); // Appel de la méthode pour mettre à jour l'état du jeu
                }
        );
        gameLoop.getKeyFrames().add(kf);
    }

    private void mettreAJourEtatJeu() {
        if (!link.estVivant())
            afficherEcranGameOver();
        if (env.verifierVictoire())
            afficherEcranVictoire();
    }

    private void afficherEcran(URL chemin, String titre){
        try {
            FXMLLoader loader = new FXMLLoader(chemin);
            Parent root = loader.load();

            // Récupérer la scène actuelle à partir d'un nœud parent
            Scene scene = panneauDeJeu.getScene();
            // Remplacer le contenu de la scène actuelle par le contenu de la vue Game Over
            scene.setRoot(root);

            Stage stage = (Stage) scene.getWindow();
            stage.setTitle(titre);
            stage.show();

            AudioManager.stopMusicFond();
            gameLoop.stop();
        } catch (IOException ignored) {}
    }

    private void afficherEcranGameOver() {
        afficherEcran(
                getClass().getResource("/universite_paris8/iut/lefarwestenperil/sae2_04/vueGameOver.fxml"),
                "Game Over"
        );
        AudioManager.playMusicDefaite();
    }

    private void afficherEcranVictoire() {
        afficherEcran(
                getClass().getResource("/universite_paris8/iut/lefarwestenperil/sae2_04/gagner.fxml"),
                "Victoire"
        );
        AudioManager.playMusicVictoire();
    }

    // Méthode pour mettre le jeu en pause
    @FXML
    public void reactionBoutonPause(ActionEvent actionEvent) throws IOException {
        pauseGame();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/universite_paris8/iut/lefarwestenperil/sae2_04/VuePause.fxml"));
        Parent pauseRoot = loader.load();

        Stage pauseStage = new Stage();
        pauseStage.initModality(Modality.APPLICATION_MODAL);
        pauseStage.setTitle("Pause Menu");
        pauseStage.setScene(new Scene(pauseRoot));
        pauseStage.showAndWait();
        resumeGame();
    }


    private void pauseGame() {
        gameLoop.pause();
    }
    // Méthode pour reprendre le jeu
    private void resumeGame() {
        gameLoop.play();
    }

    @FXML
    public void reactionBoutonPrecedent(ActionEvent actionEvent) throws IOException{
        ActionFXML.menu(actionEvent);
    }

    @FXML
    public void reactionBoutonRecommencer(ActionEvent actionEvent) throws IOException {
        ActionFXML.jouer(actionEvent);
    }
}