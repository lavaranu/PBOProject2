import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Audio
 */
public class Audio {

    Clip clip;
    URL[] soundURL = new URL[30];

    public Audio(){
        soundURL[0] = getClass().getResource("/sound/BackgroundMusic.wav");
        soundURL[1] = getClass().getResource("/sound/ClickButton.wav");
        soundURL[2] = getClass().getResource("/sound/CoinMasuk.wav");
        soundURL[3] = getClass().getResource("/sound/GameOver.wav");
    }

    public void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void play(){
        clip.start();
    }
    
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }
}