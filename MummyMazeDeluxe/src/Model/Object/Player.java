package Model.Object;

import Helper.Helper;
import Model.Animation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.HierarchyEvent;
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

    public boolean isMoving;
    private int moveRange = 0;

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
        //isMoving = true;
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
       // this.isMoving = true;
        moveRange += Helper.MOVE_UNIT;

    if(moveRange >= Helper.MOVE_RANGE + 1){
        moveRange = 0;
        isMoving = false;
        setMoveDirection(Helper.STOP);
    }




        switch (moveDirection){
            case Helper.MOVE_RIGHT_DIRECTION: {

               if(px >= Helper.getPx(0) && px <= Helper.getPx(5))
                   px += Helper.MOVE_UNIT;
                break;
            }

            case Helper.MOVE_LEFT_DIRECTION: {

                if(px >= Helper.getPx(0) && px <= Helper.getPx(5))
                    px -= Helper.MOVE_UNIT;
                break;
            }

            case Helper.MOVE_TOP_DIRECTION: {
                if(py >= Helper.getPy(0) && py <= Helper.getPy(5))
                    py -= Helper.MOVE_UNIT;
                break;
            }

            case Helper.MOVE_BOTTOM_DIRECTION: {

                if(py <= Helper.getPy(5))
                    py += Helper.MOVE_UNIT;
                break;
            }
        }
        System.out.println(""+px+" "+py);


    }

    @Override
    public void update() {

      if (isMoving){
          move();
      }

    }
}
