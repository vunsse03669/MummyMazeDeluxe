package View;

import Controller.GameManager;
import Helper.Helper;
import Model.Sound;
import View.GamePlay.Level1;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.event.KeyEvent;
import java.nio.Buffer;
import java.util.HashMap;

/**
 * Created by Mr Hung on 1/27/2017.
 */
public class MenuScene extends Scene {


    private String [] options = {Helper.MENU_SCENE_START,
                                 Helper.MENU_SCENE_HELP,
                                 Helper.MENU_SCENE_HIGH_SCORE,
                                 Helper.MENU_SCENE_ABOUT,
                                 Helper.MENU_SCENE_EXIT};
    private int currentOption;
    private HashMap<String, Sound>soundDictionary;

    public MenuScene(){
        super();
        currentOption = 0;
        soundDictionary = new HashMap<String,Sound>();
        soundDictionary.put(Helper.SELECT_SOUND_KEY, new Sound(Helper.SELECT_SOUND_SRC));


        try{
            background = ImageIO.read(new File(Helper.MENU_BACKGROUND_SRC));

        }catch(IOException e){e.printStackTrace();}
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background,0,0,null);
        for(int i = 0; i < options.length; i++) {
            if(i == currentOption)
                g.setColor(Color.RED);
            else
                g.setColor(Color.BLACK);
            int fontWidth = g.getFontMetrics().stringWidth(options[i]);
            g.setFont(new Font(Helper.MENU_FONT_FAMILY,Font.PLAIN, Helper.MENU_FONT_SIZE));
            g.drawString(options[i],Helper.WINDOW_WIDTH/2-fontWidth/2, (int) (Helper.WINDOW_HEIGHT/2 +Helper.MENU_FONT_SIZE*2
                                + i*Helper.MENU_DISTANCE_LINE));
        }
    }

    @Override
    public void update() {

    }

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
                    GameManager.getInstance().setCurrentLv(1);
                    GameManager.getInstance().pushToStack(new Level1());
                } else if(currentOption == 1) {

                }
               break;
           }
       }
    }

    public void keyReleased(int k){

    }

    public void keyTyped(int k){}


}
