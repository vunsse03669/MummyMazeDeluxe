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
    private GameManager(){
        stack = new Stack<>();
        this.pushToStack(new MenuScene());
    }

    public static GameManager getInstance() {
        if(instance == null) {
            instance = new GameManager();
        }
        return instance;
    }


    public void draw(Graphics g) {
        stack.peek().draw(g);
    }

    public void update() {
        stack.peek().update();
    }

    public void keyPressed(int k) {
        stack.peek().keyPressed(k);
    }

    public void pushToStack(Scene scene) {
        stack.push(scene);
    }
}
