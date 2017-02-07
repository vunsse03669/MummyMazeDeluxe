package View.GamePlay;

import Helper.Helper;
import View.Scene;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 2/7/2017.
 */
public class Level1 extends Scene {

    public Level1() {
        try {
            background = ImageIO.read(new File(Helper.GAME_PLAY_BACKGROUND_SRC));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background,0,0,null);
    }

    @Override
    public void update() {

    }

    @Override
    public void keyPressed(int k) {

    }
}
