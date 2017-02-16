package View.GamePlay;

import Helper.Helper;
import View.Scene;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 2/17/2017.
 */
public class EndGame extends Scene{

    private String [] options = {"DEVELOP BY",
            "NGUYEN SON VU",
            "HA PHAN ANH CONG",
            "DO NGOC TRINH",
            "VU TRI TRUNG",
             "TA QUANG HUY"};

    public EndGame() {
        try{
            background = ImageIO.read(new File(Helper.TREASURE_SRC));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background,0,0,null);
        for(int i = 0; i < options.length; i++) {
            int fontWidth = g.getFontMetrics().stringWidth(options[i]);
            g.setFont(new Font(Helper.MENU_FONT_FAMILY,Font.PLAIN, Helper.MENU_FONT_SIZE));
            g.setColor(Color.white);
            g.drawString(options[i],Helper.WINDOW_WIDTH/2-fontWidth/2, (int) (Helper.WINDOW_HEIGHT/2 - 250
                    + i*Helper.MENU_DISTANCE_LINE));
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void keyPressed(int k) {

    }

    @Override
    public void keyReleased(int k) {

    }

    @Override
    public void keyTyped(int k) {

    }
}
