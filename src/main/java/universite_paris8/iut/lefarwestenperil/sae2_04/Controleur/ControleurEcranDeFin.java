package universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires.ActionFXML;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires.AudioManager;

import java.io.IOException;

public abstract class ControleurEcranDeFin {

    @FXML
    public void reactionBoutonRecommencer(ActionEvent actionEvent) throws IOException {
        ActionFXML.jouer(actionEvent);
        AudioManager.playMusicFond();
    }

    @FXML
    public void reactionBoutonRevenirAuMenu(ActionEvent actionEvent) throws IOException {
        ActionFXML.menu(actionEvent);
        AudioManager.playMusicFond();
    }

    @FXML
    public void reactionBoutonQuitter(ActionEvent event) {
        ActionFXML.quitter(event);
    }

}
