package universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires.ActionFXML;

import java.io.IOException;

public class ControleurMenu {


    public Button boutonJouer;
    public Button boutonCommandes;
    public Button boutonObjectif;

    @FXML
    public void reactionBoutonObjectif(ActionEvent actionEvent) throws IOException {
        ActionFXML.objectif(actionEvent);
    }

    @FXML
    public void reactionBoutonCommandes(ActionEvent actionEvent) throws IOException {
        ActionFXML.commandes(actionEvent);
    }

    @FXML
    public void reactionBoutonJouer(ActionEvent actionEvent) throws IOException {
        ActionFXML.jouer(actionEvent);
    }

    @FXML
    public void reactionBoutonPrecedent(ActionEvent actionEvent) throws IOException {
        ActionFXML.menu(actionEvent);
    }

}





