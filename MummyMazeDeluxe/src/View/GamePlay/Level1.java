package View.GamePlay;

import Controller.GameManager;
import Helper.Helper;
import Model.Cell;
import Model.Object.Mummy;
import Model.Object.Player;
import View.Scene;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 2/7/2017.
 */
public class Level1 extends Scene {

    private Player player;
    private Mummy mummy;
    private Cell [][] map = Helper.MAP_LV1;

    private BufferedImage wallTop;
    private BufferedImage wallRight;
    private BufferedImage wallBottom;
    private BufferedImage wallLeft;

    public Level1() {
        try {
            player = Player.getInstance(Helper.getPx(3),Helper.getPy(1));
            mummy = new Mummy(Helper.getPx(1),Helper.getPy(5));
            player.registerObserver(mummy);
            player.setMap(map);
            mummy.setMap(map);

            background = ImageIO.read(new File(Helper.GAME_PLAY_BACKGROUND_SRC));
            wallBottom = ImageIO.read(new File(Helper.WALL_BOTTOM_SRC));
            wallTop = ImageIO.read(new File(Helper.WALL_TOP_SRC));
            wallRight = ImageIO.read(new File(Helper.WALL_RIGHT_SRC));
            wallLeft = ImageIO.read(new File(Helper.WALL_LEFT_SRC));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background,0,0,null);
        for(int i = 0; i < map.length; i++)  {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j].top){
                    g.drawImage(wallTop,Helper.getPx(i)-15,Helper.getPy(j)-15,null);
                }
                if(map[i][j].right){
                    g.drawImage(wallRight,Helper.getPx(i)-15,Helper.getPy(j)-15,null);
                }
                if(map[i][j].left){
                    g.drawImage(wallLeft,Helper.getPx(i)-15,Helper.getPy(j)-15,null);
                }
                if(map[i][j].bottom){
                    g.drawImage(wallBottom,Helper.getPx(i)-15,Helper.getPy(j)-15,null);
                }
            }
        }
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
