package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Mr Hung on 2/7/2017.
 */
public class Animation {

    private Vector<Image> vectorFrame;
    private int countTime;
    private int index;
    private int deltaSpeed;
    private final int TURN_OVER_FRAME_SPEED = 17;
    private BufferedImage bigImage;

    public Animation(String spriteURL,int start, int end, int frameWidth, int frameHeight, int deltaSpeed){
        vectorFrame = new Vector<>();
        index = 0;
        countTime = 0;
        this.deltaSpeed = deltaSpeed;
        try {
            bigImage = ImageIO.read(new File(spriteURL));

            for(int i = caculateIndexAboutOy(start,frameWidth,frameHeight); i <= caculateIndexAboutOy(end,frameWidth,frameHeight); i++){
                for(int j = caculateIndexAboutOx(start,frameWidth,frameHeight); j < caculateIndexAboutOx(end,frameWidth,frameHeight); j++ ){
                    Image img = bigImage.getSubimage(j*frameWidth,(i-1)*frameHeight,frameWidth,frameHeight);
                    vectorFrame.add(img);
                }
            }
            System.out.println(vectorFrame.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int caculateIndexAboutOx(int number, int frameWidth, int frameHeight) {
        int numberFrameInRow = (int)bigImage.getWidth()/frameWidth;
        int numbefFrameInColumn = (int)bigImage.getHeight()/frameHeight;

        if(number > numberFrameInRow) {
            int tmp = number - numberFrameInRow;
            return caculateIndexAboutOx(tmp,frameWidth,frameHeight);
        }
        else
             return number;
    }

    private int caculateIndexAboutOy(int number, int frameWidth, int frameHeight) {
        int numbefFrameInColumn = (int)bigImage.getHeight()/frameHeight;
        int numberFrameInRow = (int)bigImage.getWidth()/frameWidth;
        int index = 0;
        if(number > numberFrameInRow*numbefFrameInColumn)
            return 0;
        for(int i = 1; i <= numbefFrameInColumn; i++){
            if(number <= numberFrameInRow*i){
                index = i;
                break;
            }
        }
        return index;
    }

    public void draw(Graphics g, int px, int py) {
        g.drawImage(vectorFrame.get(index),px,py, null);
        countTime += TURN_OVER_FRAME_SPEED;
        if(countTime >= deltaSpeed) {
            countTime = 0;
            index ++;
            if(index >= vectorFrame.size()) {
                index = 0;
            }
        }
    }
}
