package Controller;

import Helper.Helper;
import Model.Sound;
import View.Help;

import java.util.Stack;

/**
 * Created by Mr Hung on 2/14/2017.
 */
public class SoundManager {
    private static SoundManager instance;
    private Stack<String>listSong;
    private Sound soundPlayer;


    private SoundManager(){
        listSong = new Stack<>();
        makeListSong();
        soundPlayer = new Sound(listSong.peek());
    }

    public static SoundManager getInstance() {
        if(instance == null) {
            instance = new SoundManager();
        }
        return instance;
    }

    public void play() {
        soundPlayer.play();
    }

    public void update() {
        if(!listSong.isEmpty() && soundPlayer.clip != null && !soundPlayer.clip.isRunning()){
            listSong.pop();
            if(!listSong.isEmpty()){
                soundPlayer = new Sound(listSong.peek());
                play();
            }
            else {
                soundPlayer.stop();
            }
        }
    }

    private void makeListSong() {
        listSong.push(Helper.LV1_SOUND_SRC);
        listSong.push(Helper.LV2_SOUND_SRC);
        listSong.push(Helper.LV3_SOUND_SRC);
    }


}
