package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires;

import universite_paris8.iut.lefarwestenperil.sae2_04.Main;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class AudioManager {

    private static Clip clipFond;
    private static Clip clipVictoire;
    private static Clip clipDefaite;

    // Méthode générique pour jouer une musique
    public static Clip initClip(String location, boolean loop) {
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(location))) {
            DataLine.Info info = new DataLine.Info(Clip.class, audioInputStream.getFormat());
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioInputStream);
            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            return clip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public static void playMusicFond() {
        clipFond = initClip(
                Objects.requireNonNull(Main.class.getResource("sonFond.wav")).getPath(),
                true
        );
        clipFond.start();
    }

    public static void playMusicVictoire() {
        clipVictoire = initClip(
                Objects.requireNonNull(Main.class.getResource("sonVictoire.wav")).getPath(),
                false
        );
        clipVictoire.start();
    }

    public static void playMusicDefaite() {
        clipDefaite = initClip(
                Objects.requireNonNull(Main.class.getResource("sonPerdue.wav")).getPath(),
                false
        );
        clipDefaite.start();
    }

    public static void stopMusic(Clip clip) {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

    public static void stopMusicFond() {
        stopMusic(clipFond);
    }

    public static void stopMusicVictoire() {
        stopMusic(clipVictoire);
    }

    public static void stopMusicDefaite() {
        stopMusic(clipDefaite);
    }
}
