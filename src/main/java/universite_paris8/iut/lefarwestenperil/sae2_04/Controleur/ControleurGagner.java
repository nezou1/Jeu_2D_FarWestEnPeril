package universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Main;

import java.io.IOException;
import java.net.URL;

public class ControleurGagner {

    private Parent root;
    private Stage stage;


    @FXML
    public void reactionBoutonRecommencer(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/universite_paris8/iut/lefarwestenperil/sae2_04/vue1.fxml"));
        root = loader.load();
        stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1025, 800);
        stage.setResizable(false);
        stage.setTitle("Le Far West En Péril");
        stage.setScene(scene);
        stage.show();
        URL urlImageVaiL = Main.class.getResource("sonFond.wav");
        String s = urlImageVaiL.getPath();
        Main.PlayMusicFond(s);

    }

    public void reactionBoutonMenu(javafx.event.ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        URL resource = (getClass().getResource("/universite_paris8/iut/lefarwestenperil/sae2_04/vueMenu.fxml"));
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root, 1024, 880);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        Main.stopMusicDefaite();
        URL urlImageVaiL = Main.class.getResource("sonFond.wav");
        String s = urlImageVaiL.getPath();
        Main.PlayMusicFond(s);


    }

    public void reactionBoutonQuitter(javafx.event.ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
