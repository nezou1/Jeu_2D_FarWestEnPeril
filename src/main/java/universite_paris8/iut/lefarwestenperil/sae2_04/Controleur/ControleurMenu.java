package universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControleurMenu implements Initializable {

    private Parent root;
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void reactionBoutonObjectif(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/universite_paris8/iut/lefarwestenperil/sae2_04/vueObjectif.fxml"));
        root = loader.load();

        stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 561);
        stage.setResizable(false);
        stage.setTitle("Le Far West En Péril : Commandes");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void reactionBoutonCommandes(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/universite_paris8/iut/lefarwestenperil/sae2_04/vueCommandes.fxml"));
        root = loader.load();
        stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 561);
        stage.setResizable(false);
        stage.setTitle("Le Far West En Péril : Commandes");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void reactionBoutonJouer(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/universite_paris8/iut/lefarwestenperil/sae2_04/vue1.fxml"));
        root = loader.load();

        stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1025, 800);
        stage.setResizable(false);
        stage.setTitle("Le Far West En Péril");
        stage.setScene(scene);
        stage.show();
    }

    public void reactionBoutonPrecedent(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/universite_paris8/iut/lefarwestenperil/sae2_04/vueMenu.fxml"));
        root = loader.load();
        stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 800);
        stage.setResizable(false);
        stage.setTitle("Le Far West En Péril");
        stage.setScene(scene);

    }


}





