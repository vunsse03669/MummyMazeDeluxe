package Model.Object;

import Helper.Helper;
import Model.Animation;
import Model.Cell;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.HierarchyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Mr Hung on 2/8/2017.
 */
public class Player extends GameObject implements Subject {

    private Animation moveLeft;
    private Animation moveRight;
    private Animation moveTop;
    private Animation moveBottom;
    private int moveDirection;
    private ArrayList<MummyObserver> observer = new ArrayList<>();

    public boolean isMoving;
    private int moveRange = 0;
    private Cell [][]currentMap;
    private int numberMove;

    private boolean canMoveRight;
    private boolean canMoveLeft;
    private boolean canMoveTop ;
    private boolean canMoveBottom;

    private static Player instance;


    public static Player getInstance(int px, int py) {
        if(instance == null){
            instance = new Player(px, py);
        }
        instance.reset();
        return instance;
    }

    private Player(int px, int py) {
        this.px = px;
        this.py = py;

        numberMove = 0;
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

    public void setIntanceNull() {
        instance = null;
    }

    public void reset() {
        canMoveRight = true;
        canMoveBottom = true;
        canMoveTop = true;
        canMoveLeft = true;
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

    public void setPx(int px){
        this.px = px;
    }

    public void setPy(int py) {
        this.py = py;
    }

    public int getMoveDirection(){
        return moveDirection;
    }

    public void increaseMove() {
        numberMove++;
    }

    public void setNumberMove(int numberMove) {
        this.numberMove = numberMove;
    }

    public int getNumberMove() {return numberMove;}

    public void setMoveDirection(int direction) {

        switch (direction){
            case Helper.MOVE_BOTTOM_DIRECTION:{
                if(Helper.getOy(py) >= 5) {
                    isMoving = false;
                    return;
                }
                else{
                    isMoving = true;
                }

                break;
            }
            case Helper.MOVE_TOP_DIRECTION:{
                if(Helper.getOy(py) <= 0) {
                    isMoving = false;
                    return;
                }
                else{
                    isMoving = true;
                }
                break;
            }
            case Helper.MOVE_LEFT_DIRECTION:{
                if(Helper.getOx(px) <= 0) {
                    isMoving = false;
                    return;
                }
                else{
                    isMoving = true;
                }
                break;
            }
            case Helper.MOVE_RIGHT_DIRECTION:{
                if(Helper.getOx(px) >= 5) {
                    isMoving = false;
                    return;
                }
                else{
                    isMoving = true;
                }
                break;
            }
        }

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
        moveRange += Helper.MOVE_UNIT;

        if(moveRange > Helper.MOVE_RANGE){
            moveRange = 0;
            isMoving = false;
            setMoveDirection(Helper.STOP);
            notifyObserver();
            increaseMove();
            checkCollision(px,py);

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

    @Override
    public void update() {

      if (isMoving){
          move();
      }

    }


    // implement Subject interface method
    @Override
    public void registerObserver(MummyObserver ob) {
        observer.add(ob);
    }

    @Override
    public void removeObserver(MummyObserver ob) {
        observer.remove(ob);
    }

    @Override
    public void notifyObserver() {
        for(MummyObserver ob : observer) {
            ob.resetMoveStep();
        }
    }
}
