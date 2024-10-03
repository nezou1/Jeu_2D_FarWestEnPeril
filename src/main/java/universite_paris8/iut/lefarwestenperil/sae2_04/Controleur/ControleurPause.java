package universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public  class ControleurPause implements Initializable {
    private Parent root;
    private Stage stage;
    private Timeline gameLoop;
    @FXML
    private Button boutonRecommencer;

    @FXML
    public void reactionBoutonContinuer(ActionEvent actionEvent) {
        // Fermer le menu de pause
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}

