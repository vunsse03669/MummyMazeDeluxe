package View.GamePlay;

import Controller.GameManager;
import Helper.Helper;
import Model.Object.Player;
import View.Scene;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 2/7/2017.
 */
public class Level1 extends Scene {

    public Player player;

    public Level1() {
        try {
            player = new Player(100,100);
            background = ImageIO.read(new File(Helper.GAME_PLAY_BACKGROUND_SRC));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background,0,0,null);
        player.draw(g);
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void keyPressed(int k) {
        switch (k) {
            case KeyEvent.VK_DOWN:{
                player.setMoveDirection(Helper.MOVE_BOTTOM_DIRECTION);
                break;
            }

            case KeyEvent.VK_UP:{
                player.setMoveDirection(Helper.MOVE_TOP_DIRECTION);
                break;
            }

            case KeyEvent.VK_LEFT: {
                player.setMoveDirection(Helper.MOVE_LEFT_DIRECTION);
                break;
            }

            case KeyEvent.VK_RIGHT: {
                player.setMoveDirection(Helper.MOVE_RIGHT_DIRECTION);
                break;
            }
        }
    }
}
