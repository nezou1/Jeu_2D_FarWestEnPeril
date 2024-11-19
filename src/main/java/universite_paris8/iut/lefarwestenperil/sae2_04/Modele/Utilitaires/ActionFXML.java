package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Main;

import java.io.IOException;
import java.net.URL;

public class ActionFXML {

    public static void initStage(ActionEvent event, URL cheminFXML, double v, double v1) throws IOException {
        FXMLLoader loader = new FXMLLoader(cheminFXML);
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, v, v1);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void jouer(ActionEvent actionEvent) throws IOException {
        ActionFXML.initStage(
                actionEvent,
                Main.class.getResource("/universite_paris8/iut/lefarwestenperil/sae2_04/vue1.fxml"),
                1025, 800
        );
    }

    public static void menu(ActionEvent actionEvent) throws IOException {
        ActionFXML.initStage(
                actionEvent,
                Main.class.getResource("/universite_paris8/iut/lefarwestenperil/sae2_04/vueMenu.fxml"),
                1000, 800
        );
    }

    private static void info(ActionEvent actionEvent, URL chemin) throws IOException {
        ActionFXML.initStage(
                actionEvent,
                chemin,
                600, 561
        );
    }

    public static void commandes(javafx.event.ActionEvent actionEvent) throws IOException {
        ActionFXML.info(
                actionEvent,
                Main.class.getResource("/universite_paris8/iut/lefarwestenperil/sae2_04/vueCommandes.fxml")
        );
    }

    public static void objectif(javafx.event.ActionEvent actionEvent) throws IOException {
        ActionFXML.info(
                actionEvent,
                Main.class.getResource("/universite_paris8/iut/lefarwestenperil/sae2_04/vueObjectif.fxml")
        );
    }

    public static void quitter(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

}
