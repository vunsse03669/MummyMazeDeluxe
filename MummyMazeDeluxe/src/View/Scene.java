package View;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Mr Hung on 1/27/2017.
 */
public abstract class Scene {
    protected BufferedImage background;
    public abstract void draw(Graphics g);
    public abstract void update();
    public abstract void keyPressed(int k);
}

