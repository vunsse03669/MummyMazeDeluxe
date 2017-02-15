package Controller;

import Helper.Helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Mr Hung on 1/27/2017.
 */
public class GameWindow extends Frame implements Runnable, KeyListener {

    private BufferedImage backGroundSprite;
    private GameManager gameManager;
    private boolean isRunning;
    private Image backImage;
    private Graphics backGraphics;
    private static GameWindow instance;

    private GameWindow() {
        super();
        isRunning = true;
        gameManager = GameManager.getInstance();
        setGame();
    }

    public static GameWindow getInstance() {
        if(instance == null) {
            instance = new GameWindow();
        }
        return instance;
    }


    private void setGame() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setResizable(false);
        this.setTitle(Helper.GAME_TITLE);
        this.setSize(Helper.WINDOW_WIDTH,Helper.WINDOW_HEIGHT);
        this.setVisible(true);
        this.setFocusable(true);
        this.setLocation(Helper.FRAME_LOCATION_PX,Helper.FRAME_LOCATION_PY);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        this.addKeyListener(this);
    }

    public void paint(Graphics g){
        super.paint(g);
        g.clearRect(0,0,Helper.WINDOW_WIDTH,Helper.WINDOW_HEIGHT);
        gameManager.draw(g);
    }

    @Override
    public void run() {
        while(isRunning){
            gameManager.update();
            repaint();
            try {
                Thread.sleep(Helper.FPS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Key event listener
    @Override
    public void keyTyped(KeyEvent e) {
        gameManager.keyTyped(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        gameManager.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gameManager.keyReleased(e.getKeyCode());
    }

    public void update(Graphics g) {
        if (backImage == null) {
            backImage = createImage(this.getWidth(), this.getHeight());
            backGraphics = backImage.getGraphics();
        }
        backGraphics.setColor(getBackground());
        backGraphics.fillRect(0, 0, getWidth(), getHeight());
        backGraphics.setColor(getForeground());
        paint(backGraphics);
        g.drawImage(backImage, 0, 0, null);
    }
}
