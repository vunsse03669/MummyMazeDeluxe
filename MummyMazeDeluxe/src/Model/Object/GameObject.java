package Model.Object;

import Helper.Helper;
import Model.Cell;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Mr Hung on 2/7/2017.
 */
public abstract class GameObject {
    protected BufferedImage sprite;
    protected int px;
    protected int py;

    public abstract void draw(Graphics g);
    public abstract void move();
    public abstract void update();

    protected int getWidthSprite(){
        return sprite.getWidth();
    }

    protected int getHeightSprite(){
        return sprite.getHeight();
    }

    protected boolean isCollisionLeft (int px, int py, Cell cell[][]) {
        int ox = Helper.getOx(px);
        int oy = Helper.getOy(py);

        if(ox == 0)
            return true;

        if(cell[ox][oy].left || cell[ox-1][oy].right )
            return true;
        else
            return false;
    }

    protected boolean isCollisionRight (int px, int py, Cell cell[][]) {
        int ox = Helper.getOx(px);
        int oy = Helper.getOy(py);

        if(ox == 5)
            return true;

        if(cell[ox][oy].right || cell[ox+1][oy].left )
            return true;
        else
           return false;

    }

    protected boolean isCollisionTop (int px, int py, Cell cell[][]) {
        int ox = Helper.getOx(px);
        int oy = Helper.getOy(py);

        if(oy == 0)
            return true;

        if(cell[ox][oy].top || cell[ox][oy-1].bottom )
            return true;
        else
            return false;
    }

    protected boolean isCollisionBottom (int px, int py, Cell cell[][]) {
        int ox = Helper.getOx(px);
        int oy = Helper.getOy(py);

        if(oy == 5)
            return true;

        if(cell[ox][oy].bottom || cell[ox][oy+1].top )
            return true;
        else
            return false;
    }
}
