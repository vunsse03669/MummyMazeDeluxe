package Model.Object;

import Helper.Helper;
import Model.Animation;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 2/11/2017.
 */
public class Mummy extends GameObject implements MummyObserver {

    private Animation moveLeft;
    private Animation moveRight;
    private Animation moveTop;
    private Animation moveBottom;

    private int moveStep;
    private int moveRange;
    private boolean isMoving;
    private int moveDirection;

    public Mummy(int px, int py) {
        this.px = px;
        this.py = py;
        moveRange = 0;
        moveStep = 0;
        moveDirection = Helper.STOP;

        moveBottom = new Animation(Helper.MUMMY_SPRITE_SHEET_SRC,11,15,Helper.SPRITE_MUMMY_WIDTH, Helper.SPRITE_MUMMY_HEIGHT,
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

    public void setMoveStep(int moveStep) {
        this.moveStep = moveStep;
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
                moveBottom.draw(g,px,py);
                break;
            }

            case Helper.MOVE_TOP_DIRECTION: {
                moveTop.draw(g,px,py);
                break;
            }

            case Helper.MOVE_LEFT_DIRECTION: {
                moveLeft.draw(g,px,py);
                break;
            }

            case Helper.MOVE_RIGHT_DIRECTION: {
                moveRight.draw(g,px,py);
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

    public void update(int playerOX, int playerOY) {
        move(playerOX,playerOY);
    }

    public void move(int playerOX, int playerOY){

        if(moveStep > 2) {
            moveDirection = Helper.STOP;
            return;
        }

        if(!isMoving) {
            return;
        }

        moveRange += Helper.MOVE_UNIT;
        if(moveRange >= Helper.MOVE_RANGE + 1){
            moveRange = 0;

            moveStep ++;
            System.out.println("move step "+moveStep);
            setMoveDirection(Helper.STOP);
            findDirection(playerOX, playerOY);
        }


        switch (moveDirection){
            case Helper.MOVE_RIGHT_DIRECTION: {
                if( px <= Helper.getPx(5))
                    px += Helper.MOVE_UNIT;
                break;
            }

            case Helper.MOVE_LEFT_DIRECTION: {
                if(px >= Helper.getPx(0))
                    px -= Helper.MOVE_UNIT;
                break;
            }

            case Helper.MOVE_TOP_DIRECTION: {
                if(py >= Helper.getPy(0))
                    py -= Helper.MOVE_UNIT;
                break;
            }

            case Helper.MOVE_BOTTOM_DIRECTION: {
                if(py <= Helper.getPy(5))
                    py += Helper.MOVE_UNIT;
                break;
            }
        }
    }

    private void findDirection(int playerOX, int playerOY){
        int currentOX = Helper.getOx(px);
        int currentOY = Helper.getOy(py);

        if(currentOX == playerOX) {
            if(currentOY > playerOY) {
                setMoveDirection(Helper.MOVE_TOP_DIRECTION);
            } else if(currentOY < playerOY) {
                setMoveDirection(Helper.MOVE_BOTTOM_DIRECTION);
            }
        } else if(currentOY == playerOY) {
            if(currentOX > playerOX) {
                setMoveDirection(Helper.MOVE_LEFT_DIRECTION);
            } else if(currentOX < playerOX) {
                setMoveDirection(Helper.MOVE_RIGHT_DIRECTION);
            }
        } else if(currentOX != playerOX && currentOY != playerOY) {
            if(currentOX > playerOX) {
                setMoveDirection(Helper.MOVE_LEFT_DIRECTION);
            } else if(currentOX < playerOX) {
                setMoveDirection(Helper.MOVE_RIGHT_DIRECTION);
            }
        }
    }

    @Override
    public void resetMoveStep() {
        moveStep = 0;
        isMoving = true;
    }
}
