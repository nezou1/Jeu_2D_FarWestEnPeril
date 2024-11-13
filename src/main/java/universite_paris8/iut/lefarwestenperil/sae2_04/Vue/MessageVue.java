// Exemple de la classe MessageVue.java
package universite_paris8.iut.lefarwestenperil.sae2_04.Vue;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.PNJs.Gardien2;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.Link2;

public class MessageVue {

    public void afficherMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        ButtonType okButton = new ButtonType("OK");
        alert.getButtonTypes().setAll(okButton);
        alert.showAndWait();
    }

    public void afficherDialogueGardien(Gardien2 gardien, Link2 link) {
        long tempsActuel = System.currentTimeMillis();
        long tempsEcouleDepuisDernierInterrogatoire = tempsActuel - gardien.getDernierInterrogatoire();

        if (gardien.isRepondu() || tempsEcouleDepuisDernierInterrogatoire < 10000) {
            return;
        }

        ChoiceDialog<String> dialog = new ChoiceDialog<>(gardien.getChoix().get(0), gardien.getChoix());
        dialog.setTitle("Gardien");
        dialog.setHeaderText(gardien.getQuestion());
        dialog.setContentText("Choisissez votre réponse:");

        dialog.showAndWait().ifPresent(response -> {
            if (response.equalsIgnoreCase(gardien.getBonneReponse())) {
                afficherMessage(gardien.getMessageReussite());
                gardien.recompense(link);
                gardien.setRepondu(true);
            } else {
                afficherMessage(gardien.getMessageEchec());
                link.setPointVie(link.getPointVie() - 2);
            }
            gardien.setDernierInterrogatoire(System.currentTimeMillis());
        });
    }
}
