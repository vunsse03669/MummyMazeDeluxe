package Model.Object;

import Helper.Helper;
import Model.Animation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 2/8/2017.
 */
public class Player extends GameObject {

    private Animation moveLeft;
    private Animation moveRight;
    private Animation moveTop;
    private Animation moveBottom;
    private int moveDirection;

    public Player(int px, int py) {
        this.px = px;
        this.py = py;
        moveDirection = Helper.STOP;

        moveRight = new Animation(Helper.PLAYER_SPRITE_SHEET_SRC,6,10,Helper.SPRITE_PLAYER_WIDTH,Helper.SPRITE_PLAYER_HEIGHT,
                Helper.TURN_OVER_SPEED);
        moveLeft = new Animation(Helper.PLAYER_SPRITE_SHEET_SRC,16,20,Helper.SPRITE_PLAYER_WIDTH,Helper.SPRITE_PLAYER_HEIGHT,
                Helper.TURN_OVER_SPEED);
        moveTop = new Animation(Helper.PLAYER_SPRITE_SHEET_SRC,11,15,Helper.SPRITE_PLAYER_WIDTH,Helper.SPRITE_PLAYER_HEIGHT,
                Helper.TURN_OVER_SPEED);
        moveBottom = new Animation(Helper.PLAYER_SPRITE_SHEET_SRC,1,5,Helper.SPRITE_PLAYER_WIDTH,Helper.SPRITE_PLAYER_HEIGHT,
                Helper.TURN_OVER_SPEED);
        try{
            sprite = ImageIO.read(new File(Helper.PLAYER_SPRITE_SRC));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public int getMoveDirection(){
        return moveDirection;
    }

    public void setMoveDirection(int direction) {
        moveDirection = direction;
    }

    @Override
    public void draw(Graphics g) {
        if(moveDirection == Helper.STOP){
            g.drawImage(sprite,px,py,null);
        }

        if(moveDirection == Helper.MOVE_LEFT_DIRECTION){
            moveLeft.draw(g,px,py);
        }

        if(moveDirection == Helper.MOVE_RIGHT_DIRECTION){
            moveRight.draw(g,px,py);
        }

        if(moveDirection == Helper.MOVE_TOP_DIRECTION){
            moveBottom.draw(g,px,py);
        }

        if(moveDirection == Helper.MOVE_BOTTOM_DIRECTION){
            moveTop.draw(g,px,py);
        }
    }

    @Override
    public void move() {
        switch (moveDirection){
            case Helper.MOVE_RIGHT_DIRECTION: {
               if(px >= 0 && px <= Helper.WINDOW_WIDTH)
                   px += 5;
                break;
            }

            case Helper.MOVE_LEFT_DIRECTION: {
                if(px >= 0 && px <= Helper.WINDOW_WIDTH)
                    px -= 5;
                break;
            }

            case Helper.MOVE_TOP_DIRECTION: {
                if(px >= 0 && px <= Helper.WINDOW_HEIGHT)
                    py -= 5;
                break;
            }

            case Helper.MOVE_BOTTOM_DIRECTION: {
                if(px >= 0 && px <= Helper.WINDOW_HEIGHT)
                    py += 5;
                break;
            }
        }

    }

    @Override
    public void update() {
      //  move();

    }
}
