package Model.Object;

import Helper.Helper;
import Model.Animation;
import Model.Cell;
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
    private boolean canMove;
    private int moveDirection;

    private Cell[][]currentMap;

    private boolean canMoveRight = true;
    private boolean canMoveLeft = true;
    private boolean canMoveTop  = true;
    private boolean canMoveBottom = true;

    public boolean isMoving;

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

    public void setMap(Cell [][]map) {
        this.currentMap = map;
    }

    public int getPX() {
        return px;
    }

    public int getPY() {
        return py;
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
            isMoving = false;
            moveDirection = Helper.STOP;
            return;
        }

        if(!canMove) {
            return;
        }

        moveRange += Helper.MOVE_UNIT;
        if(moveRange >= Helper.MOVE_RANGE + 1){
            moveRange = 0;
            checkCollision(px,py);
            moveStep ++;
            System.out.println("move step "+moveStep);
            setMoveDirection(Helper.STOP);
            findDirection(playerOX, playerOY);
        }


        switch (moveDirection){
            case Helper.MOVE_RIGHT_DIRECTION: {

                if(px <= Helper.getPx(5))
                    if(canMoveRight)
                        px += Helper.MOVE_UNIT;

                    else
                        px += 0;
                break;
            }

            case Helper.MOVE_LEFT_DIRECTION: {

                if(px >= Helper.getPx(0))
                    if(canMoveLeft)
                        px -= Helper.MOVE_UNIT;
                    else
                        px -= 0;
                break;
            }

            case Helper.MOVE_TOP_DIRECTION: {
                if(py >= Helper.getPy(0))
                    if(canMoveTop)
                        py -= Helper.MOVE_UNIT;
                    else
                        py -= 0;
                break;
            }

            case Helper.MOVE_BOTTOM_DIRECTION: {

                if(py <= Helper.getPy(5))
                    if(canMoveBottom)
                        py += Helper.MOVE_UNIT;
                    else
                        py += 0;
                break;
            }
        }
    }

    private void checkCollision(int px, int py) {
        if(isCollisionRight(px,py,currentMap)){
            canMoveRight = false;
        }else{
            canMoveRight = true;
        }

        if(isCollisionLeft(px,py,currentMap)){
            canMoveLeft = false;
        }else{
            canMoveLeft = true;
        }

        if(isCollisionTop(px,py,currentMap)){
            canMoveTop = false;
        }else{
            canMoveTop = true;
        }

        if(isCollisionBottom(px,py,currentMap)){
            canMoveBottom = false;
        }else{
            canMoveBottom = true;
        }
    }

    private void findDirection(int playerOX, int playerOY){
        int currentOX = Helper.getOx(px);
        int currentOY = Helper.getOy(py);

        if(currentOX == playerOX) {
            if(currentOY > playerOY && canMoveTop) {
                setMoveDirection(Helper.MOVE_TOP_DIRECTION);
                isMoving = true;
            } else if(currentOY < playerOY && canMoveBottom) {
                setMoveDirection(Helper.MOVE_BOTTOM_DIRECTION);
                isMoving = true;
            }
            //isMoving = true;
        } else if(currentOY == playerOY) {
            if(currentOX > playerOX && canMoveLeft) {
                setMoveDirection(Helper.MOVE_LEFT_DIRECTION);
                isMoving = true;
            } else if(currentOX < playerOX && canMoveRight) {
                setMoveDirection(Helper.MOVE_RIGHT_DIRECTION);
                isMoving = true;
            }


        } else if(currentOX != playerOX && currentOY != playerOY) {
            if(currentOX > playerOX && canMoveLeft) {
                setMoveDirection(Helper.MOVE_LEFT_DIRECTION);
                isMoving = true;
            } else if(currentOX < playerOX && canMoveRight) {
                setMoveDirection(Helper.MOVE_RIGHT_DIRECTION);
                isMoving = true;
            } else if(currentOY > playerOY && canMoveTop) {
                setMoveDirection(Helper.MOVE_TOP_DIRECTION);
                isMoving = true;
            } else if(currentOY < playerOY && canMoveBottom) {
                setMoveDirection(Helper.MOVE_BOTTOM_DIRECTION);
                isMoving = true;
            }


        }
    }

    @Override
    public void resetMoveStep() {
        moveStep = 0;
        canMove = true;
    }
}
