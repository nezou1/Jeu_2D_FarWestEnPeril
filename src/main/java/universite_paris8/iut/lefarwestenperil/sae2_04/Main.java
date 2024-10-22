package universite_paris8.iut.lefarwestenperil.sae2_04;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    protected static Clip clipFond;
    private static Clip clipVictoire;
    private static Clip clipDefaite;

    public static void main(String[] args) {
        URL urlImageVaiL = Main.class.getResource("sonFond.wav");
        String s = urlImageVaiL.getPath();
        PlayMusicFond(s);
        launch();
    }

    public static void PlayMusicFond(String location) {
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(location));
        } catch (UnsupportedAudioFileException | IOException e) {
            throw new RuntimeException(e);
        }
        DataLine.Info info = new DataLine.Info(Clip.class, audioInputStream.getFormat());
        try {
            clipFond = (Clip) AudioSystem.getLine(info);
            clipFond.open(audioInputStream);
            clipFond.loop(Clip.LOOP_CONTINUOUSLY); // Ajout pour répéter la musique indéfiniment
            clipFond.start();
        } catch (LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void stopMusicFond() {
        if (clipFond != null && clipFond.isRunning()) {
            clipFond.stop();
            clipFond.close();
        }
    }

    public static void PlayMusicVictoire(String location) {
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(location));
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DataLine.Info info = new DataLine.Info(Clip.class, audioInputStream.getFormat());
        try {
            clipVictoire = (Clip) AudioSystem.getLine(info);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        try {
            clipVictoire.open(audioInputStream);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        clipVictoire.start();
    }

    public static void stopMusicVictoire() {
        if (clipVictoire != null && clipVictoire.isRunning()) {
            clipVictoire.stop();
            clipVictoire.close();
        }
    }

    public static void PlayMusicDefaite(String location) {
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(location));
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DataLine.Info info = new DataLine.Info(Clip.class, audioInputStream.getFormat());
        try {
            clipDefaite = (Clip) AudioSystem.getLine(info);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        try {
            clipDefaite.open(audioInputStream);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        clipDefaite.start();
    }

    public static void stopMusicDefaite() {
        if (clipDefaite != null && clipDefaite.isRunning()) {
            clipDefaite.stop();
            clipDefaite.close();
        }
    }

    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("vueMenu.fxml"));
        ScrollPane scrollPane = new ScrollPane();
        Scene scene = new Scene(fxmlLoader.load(), 1025, 800);
        stage.setTitle("LeFar West en Péril");
        stage.setScene(scene);
        stage.show();
    }
}