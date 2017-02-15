package View;

import Controller.GameManager;
import Helper.Helper;
import Model.Object.GameObject;
import Model.Object.Player;
import Model.Sound;
import View.GamePlay.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Mr Hung on 2/15/2017.
 */
public class GameOver extends Scene {

    private String [] options = {Helper.PLAY_AGAIN,Helper.GO_TO_MENU};
    private int currentOption = 0;
    private HashMap<String, Sound> soundDictionary;

    public GameOver() {
        try {
            background = ImageIO.read(new File(Helper.GAME_OVER_BACKGROUND));
            soundDictionary = new HashMap<>();
            soundDictionary.put(Helper.SELECT_SOUND_KEY, new Sound(Helper.SELECT_SOUND_SRC));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background,0,0,null);
        for(int i = 0; i < options.length; i++) {
            if(i == currentOption) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.WHITE);
            }

            g.setFont(new Font(Helper.MENU_FONT_FAMILY,Font.PLAIN, Helper.MENU_FONT_SIZE));
            int fontWidth = g.getFontMetrics().stringWidth(options[i]);
            g.drawString(options[i],Helper.WINDOW_WIDTH/2-fontWidth/2, (int) (Helper.WINDOW_HEIGHT/2 +Helper.MENU_FONT_SIZE*5
                    + i*Helper.MENU_DISTANCE_LINE));
        }

        g.setFont(new Font(Helper.MENU_FONT_FAMILY,Font.PLAIN, 70));
        int fontWidth = g.getFontMetrics().stringWidth("MOVE STEP: " + Player.getInstance(0,0).getNumberMove());
        g.drawString("MOVE STEP: "+ Player.getInstance(0,0).getNumberMove(),Helper.WINDOW_WIDTH/2-fontWidth/2, (int) (Helper.WINDOW_HEIGHT/2 ));
    }

    @Override
    public void update() {

    }

    @Override
    public void keyPressed(int k) {
        switch (k) {
            case KeyEvent.VK_DOWN:{
                currentOption ++;
                soundDictionary.get(Helper.SELECT_SOUND_KEY).play();
                if(currentOption == options.length)
                    currentOption = 0;
                break;
            }

            case KeyEvent.VK_UP:{
                currentOption --;
                soundDictionary.get(Helper.SELECT_SOUND_KEY).play();
                if(currentOption < 0)
                    currentOption = options.length - 1;
                break;
            }

            case KeyEvent.VK_ENTER: {
                if(currentOption == 0) {
                    GameManager.getInstance().popToStack();
                    if(GameManager.getInstance().getCurrentLv() == 1) {
                        GameManager.getInstance().pushToStack(new Level1());
                    } else if(GameManager.getInstance().getCurrentLv() == 2) {
                        GameManager.getInstance().pushToStack(new Level2());
                    } else if(GameManager.getInstance().getCurrentLv() == 3) {
                        GameManager.getInstance().pushToStack(new Level3());
                    } else if(GameManager.getInstance().getCurrentLv() == 4) {
                        GameManager.getInstance().pushToStack(new Level4());
                    } else if(GameManager.getInstance().getCurrentLv() == 5) {
                        GameManager.getInstance().pushToStack(new Level5());
                    }



                } else if(currentOption == 1) {
                    GameManager.getInstance().popToStack();
                    Player.getInstance(0,0).setIntanceNull();
                }
                break;
            }
        }
    }

    @Override
    public void keyReleased(int k) {

    }

    @Override
    public void keyTyped(int k) {

    }
}
