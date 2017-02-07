package Model;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Mr Hung on 2/7/2017.
 */
public abstract class GameObject {
    protected BufferedImage sprite;

    public abstract void draw(Graphics g);
    public abstract void move();
}
