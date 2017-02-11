package Model.Object;

import Helper.Helper;
import Model.Animation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 2/11/2017.
 */
public class Mummy extends GameObject {
    private Animation moveLeft;
    private Animation moveRight;
    private Animation moveTop;
    private Animation moveBottom;

    private int moveDirection;

    public Mummy(int px, int py) {
        this.px = px;
        this.py = py;

        moveDirection = Helper.STOP;
        moveBottom = new Animation(Helper.MUMMY_SPRITE_SHEET_SRC,11,16,Helper.SPRITE_MUMMY_WIDTH, Helper.SPRITE_MUMMY_HEIGHT,
                Helper.TURN_OVER_SPEED);
        moveTop = new Animation(Helper.MUMMY_SPRITE_SHEET_SRC,1,5,Helper.SPRITE_MUMMY_WIDTH, Helper.SPRITE_MUMMY_HEIGHT,
                Helper.TURN_OVER_SPEED);
        moveRight = new Animation(Helper.MUMMY_SPRITE_SHEET_SRC,6,10,Helper.SPRITE_MUMMY_WIDTH, Helper.SPRITE_MUMMY_HEIGHT,
                Helper.TURN_OVER_SPEED);
        moveLeft = new Animation(Helper.MUMMY_SPRITE_SHEET_SRC,16,20,Helper.SPRITE_MUMMY_WIDTH, Helper.SPRITE_MUMMY_HEIGHT,
                Helper.TURN_OVER_SPEED);

        try{
            sprite = ImageIO.read(new File(Helper.MUMMY_SPRITE_SRC));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setMoveDirection(int direction) {
        moveDirection = direction;
    }

    @Override
    public void draw(Graphics g) {
        switch (moveDirection) {
            case Helper.STOP: {
                g.drawImage(sprite,px,py,null);
                break;
            }

            case Helper.MOVE_BOTTOM_DIRECTION: {

                break;
            }

            case Helper.MOVE_TOP_DIRECTION: {

                break;
            }

            case Helper.MOVE_LEFT_DIRECTION: {

                break;
            }

            case Helper.MOVE_RIGHT_DIRECTION: {

                break;
            }
        }
    }

    @Override
    public void move() {

    }

    @Override
    public void update() {

    }
}
