package Model;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * Created by Mr Hung on 1/27/2017.
 */
public class Sound {
    Clip clip;
    public Sound(String s){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(s));

            AudioFormat baseFormat = ais.getFormat();
            AudioFormat decodeFomat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(),
                    false
            );

            AudioInputStream dais =
                    AudioSystem.getAudioInputStream(
                            decodeFomat, ais);
            clip = AudioSystem.getClip();
            clip.open(dais);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void play(){

        if(clip == null) return;
        stop();

        clip.setFramePosition(0);
        clip.start();
    }
    public void stop(){
        if(clip.isRunning()) clip.stop();
    }

    public void close(){
        stop();
        clip.close();
    }
}
