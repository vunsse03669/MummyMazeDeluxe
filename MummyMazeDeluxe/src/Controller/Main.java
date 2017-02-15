package Controller;

/**
 * Created by Mr Hung on 1/27/2017.
 */
public class Main {

    public static void main(String[] args) {
        GameWindow game = GameWindow.getInstance();
        Thread t = new Thread(game);
        t.start();
    }
}
