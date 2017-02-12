package View.GamePlay;

import Controller.GameManager;
import Helper.Helper;
import Model.Object.Mummy;
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

    private Player player;
    private Mummy mummy;

    public Level1() {
        try {
            player = Player.getInstance(Helper.getPx(1),Helper.getPy(5));
            mummy = new Mummy(Helper.getPx(3),Helper.getPy(3));
            player.registerObserver(mummy);
            background = ImageIO.read(new File(Helper.GAME_PLAY_BACKGROUND_SRC));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background,0,0,null);
        player.draw(g);
        mummy.draw(g);
    }

    @Override
    public void update() {
        player.update();
        mummy.update(Helper.getOx(player.getPX()),Helper.getOy(player.getPY()));
    }

    @Override
    public void keyPressed(int k) {
        if (!player.isMoving)
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

    public void keyReleased(int k){
    }

    public void keyTyped(int k){}
}
