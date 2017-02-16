package View.GamePlay;

import Controller.GameManager;
import Helper.Helper;
import Model.Cell;
import Model.Object.Flag;
import Model.Object.Mummy;
import Model.Object.Player;
import View.GameOver;
import View.Scene;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 2/14/2017.
 */
public class Level2 extends Scene {

    private Player player;
    private Mummy mummy;
    private Flag flag;
    private Cell[][] map = Helper.MAP_LV2;
    private int totalStep;

    private BufferedImage wallTop;
    private BufferedImage wallRight;
    private BufferedImage wallBottom;
    private BufferedImage wallLeft;

    private GameManager gsm;

    public Level2() {
        try{
            player = Player.getInstance(Helper.getPx(0),Helper.getPy(1));
            player.setPx(Helper.getPx(2));
            player.setPy(Helper.getPy(4));
            player.setNumberMove(0);
            totalStep = 10;

            mummy = new Mummy(Helper.getPx(5),Helper.getPy(1));
            flag = new Flag(Helper.getPx(4),Helper.getPy(1));
            gsm = GameManager.getInstance();

            player.registerObserver(mummy);
            player.setMap(map);
            mummy.setMap(map);

            background = ImageIO.read(new File(Helper.GAME_PLAY_BACKGROUND_SRC));
            wallBottom = ImageIO.read(new File(Helper.WALL_BOTTOM_SRC));
            wallTop = ImageIO.read(new File(Helper.WALL_TOP_SRC));
            wallRight = ImageIO.read(new File(Helper.WALL_RIGHT_SRC));
            wallLeft = ImageIO.read(new File(Helper.WALL_LEFT_SRC));
            menu = ImageIO.read(new File(Helper.MENU_LV2));
        }catch(IOException e) {
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
        flag.draw(g);
        player.draw(g);
        mummy.draw(g);

        int fontWidth = g.getFontMetrics().stringWidth("MOVE STEP: " + (totalStep - player.getNumberMove()));
        g.setColor(Color.white);
        g.setFont(new Font(Helper.MENU_FONT_FAMILY, Font.PLAIN,20));
        g.drawString("MOVE STEP: " + (totalStep - player.getNumberMove()), 220/2 - fontWidth/2, 160);
        g.drawString("LEVEL" + gsm.getCurrentLv(), 80, 100);
        g.drawImage(menu,50,250,null);
    }

    @Override
    public void update() {
        player.update();
        mummy.update(Helper.getOx(player.getPX()),Helper.getOy(player.getPY()));

        if(!mummy.isMoving) {
            if((Helper.getOx(mummy.getPX()) == Helper.getOx( player.getPX())
                    && Helper.getOy( mummy.getPY()) == Helper.getOy(player.getPY()))
                    || (totalStep - player.getNumberMove()) == 0) {
                System.out.println("Game over");
                gsm.popToStack();
                gsm.pushToStack(new GameOver());
            }
        }
        if(Helper.getOx(flag.getPx()) == Helper.getOx(player.getPX())
                && Helper.getOy(flag.getPy()) == Helper.getOy(player.getPY())
                && !player.isMoving && !mummy.isMoving) {
            player.resetMoveHistory();
            gsm.popToStack();
            gsm.setCurrentLv(3);
            gsm.pushToStack(new Level3());
        }
    }

    @Override
    public void keyPressed(int k) {
        if (!player.isMoving && !mummy.isMoving)
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

                case KeyEvent.VK_X: {
                    resetLevel();
                    break;
                }

                case KeyEvent.VK_Z: {
                    returnPreviousPosition();
                    break;
                }
            }
    }

    private void returnPreviousPosition() {
        player.returnPreviousPosition();
        mummy.returnPreviousPosition();
    }

    private void resetLevel() {
        player.setPx(Helper.getPx(2));
        player.setPy(Helper.getPy(4));

        mummy.setPx(Helper.getPx(5));
        mummy.setPy(Helper.getPy(1));

        player.reset();
        player.setNumberMove(0);
    }

    @Override
    public void keyReleased(int k) {

    }

    @Override
    public void keyTyped(int k) {

    }
}
