package Model.Object;

import Helper.Helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 2/13/2017.
 */
public class Flag extends GameObject{
    public Flag(int px, int py) {
        this.px = px;
        this.py = py;
        try{
            sprite = ImageIO.read(new File(Helper.FLAG_SPRITE_SRC));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public int getPx() {
        return px;
    }

    public int getPy() {
        return py;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(sprite,px,py,null);
    }

    @Override
    public void move() {

    }

    @Override
    public void update() {

    }
}
