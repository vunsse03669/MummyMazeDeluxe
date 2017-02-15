package View;

import Controller.GameManager;
import Helper.Helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 2/14/2017.
 */
public class About extends Scene {

    public About() {
        try{
            background = ImageIO.read(new File(Helper.ABOUT_BACKGROUND_SRC));
        }catch(IOException e) {
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
        switch (k) {
            case KeyEvent.VK_B: {
                GameManager.getInstance().popToStack();
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
