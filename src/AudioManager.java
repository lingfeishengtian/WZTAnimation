import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioManager {
    static AudioInputStream BGMAudioStream;
    static Clip BGMclip;

    public static void playBGM(){
        try {
            BGMAudioStream = AudioSystem.getAudioInputStream(new File("audio/bgm.wav"));
            BGMclip = AudioSystem.getClip();
            BGMclip.open(BGMAudioStream);
            FloatControl gainControl =
                    (FloatControl) BGMclip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-2.0f);
            BGMclip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopBGM() {
        BGMclip.stop();
    }

    public static boolean isBGMOn(){
        return BGMclip.isRunning();
    }

    public static void continueBGM(){
        BGMclip.start();
    }

    public static void playBreeze(){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("audio/windbreeze.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            ((FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN)).setValue(-4.0f);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
