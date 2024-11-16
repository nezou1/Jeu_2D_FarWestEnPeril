package universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires.ActionFXML;


public  class ControleurPause {

    @FXML
    public void reactionBoutonContinuer(ActionEvent actionEvent) {
        ActionFXML.quitter(actionEvent);
    }

}

