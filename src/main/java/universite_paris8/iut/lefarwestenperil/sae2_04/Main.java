package universite_paris8.iut.lefarwestenperil.sae2_04;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires.AudioManager;

import java.awt.*;
import java.io.IOException;

public class Main extends Application {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        AudioManager.playMusicFond();
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        LOGGER.log(Level.ERROR, "Une bombe est déjà en cours. Veuillez attendre l'explosion");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("vueMenu.fxml"));
        ScrollPane scrollPane = new ScrollPane();
        Scene scene = new Scene(fxmlLoader.load(), 1025, 800);
        stage.setTitle("LeFar West en Péril");
        stage.setScene(scene);
        stage.show();
    }
}