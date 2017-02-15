package Controller;

import View.MenuScene;
import View.Scene;

import java.awt.*;
import java.util.Stack;

/**
 * Created by Mr Hung on 1/27/2017.
 */

public class GameManager {
    private static GameManager instance;
    private Stack<Scene> stack;
    private SoundManager soundManager;
    private int currentLv;


    private GameManager(){
        stack = new Stack<>();
        this.pushToStack(new MenuScene());
        currentLv = 0;
        soundManager = SoundManager.getInstance();
        soundManager.play();
    }

    public static GameManager getInstance() {
        if(instance == null) {
            instance = new GameManager();
        }
        return instance;
    }


    public void setCurrentLv(int lv) {
        currentLv = lv;
    }

    public int getCurrentLv() {return currentLv;}


    public void draw(Graphics g) {
        stack.peek().draw(g);
    }

    public void update() {
        stack.peek().update();
        soundManager.update();
    }

    public void keyPressed(int k) {
        stack.peek().keyPressed(k);
    }

    public void keyReleased(int k){
        stack.peek().keyReleased(k);
    }

    public void keyTyped(int k){
        stack.peek().keyTyped(k);
    }

    public void pushToStack(Scene scene) {
        stack.push(scene);
    }

    public void popToStack() {
        stack.pop();
    }
}
