package universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;

import javafx.fxml.FXML;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires.AudioManager;

import java.io.IOException;

public class ControleurDefaite extends ControleurEcranDeFin {

    @FXML
    public void reactionBoutonRecommencer(javafx.event.ActionEvent actionEvent) throws IOException {
        AudioManager.stopMusicDefaite();
        super.reactionBoutonRecommencer(actionEvent);
    }

    @FXML
    public void reactionBoutonRevenirAuMenu(javafx.event.ActionEvent actionEvent) throws IOException {
        AudioManager.stopMusicDefaite();
        super.reactionBoutonRevenirAuMenu(actionEvent);
    }
}
