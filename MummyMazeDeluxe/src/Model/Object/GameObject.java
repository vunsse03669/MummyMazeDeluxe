package Model.Object;

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
}
