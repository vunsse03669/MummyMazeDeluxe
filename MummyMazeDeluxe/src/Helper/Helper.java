package Helper;

/**
 * Created by Mr Hung on 1/27/2017.
 */
public class Helper {
    public static final String GAME_TITLE = "Mummy Maze Deluxe";
    public static final int WINDOW_WIDTH = 960;
    public static final int WINDOW_HEIGHT = 720;
    public static final int FPS = 20;
    public static final int FRAME_LOCATION_PX = 200;
    public static final int FRAME_LOCATION_PY = 50;
    public static final String BACKGROUND_SOUND_KEY = "Background_sound";

    public static final int pOX = 320;
    public static final int pOY = 120;

    // Menu
    public static final String MENU_SCENE_START = "START";
    public static final String MENU_SCENE_HIGH_SCORE = "HIGH SCORE";
    public static final String MENU_SCENE_HELP = "HELP";
    public static final String MENU_SCENE_ABOUT = "ABOUT";
    public static final String MENU_SCENE_EXIT = "EXIT";
    public static final int MENU_FONT_SIZE = 40;
    public static final String MENU_FONT_FAMILY = "Arial Black";
    public static final int MENU_DISTANCE_LINE = 60;

    public static final String MENU_BACKGROUND_SRC = "resource/image/title.jpg";
    public static final String GAME_PLAY_BACKGROUND_SRC = "resource/image/lvlEditor.png";
    public static final String PLAYER_SPRITE_SHEET_SRC = "resource/image/player.png";
    public static final String PLAYER_SPRITE_SRC = "resource/image/player_sprite.png";

    public static final String PLAYER_SPRITE_MOVE_LEFT_SRC = "resource/image/move_left.png";
    public static final String PLAYER_SPRITE_MOVE_RIGHT_SRC = "resource/image/move_right.png";
    public static final String PLAYER_SPRITE_MOVE_TOP_SRC = "resource/image/move_top.png";
    public static final String PLAYER_SPRITE_MOVE_BOTTOM_SRC = "resource/image/move_bottom.png";

    public static final String MUMMY_SPRITE_SHEET_SRC = "resource/image/mummy_white.png";
    public static final String MUMMY_SPRITE_SRC = "resource/image/mummy_sprite.png";

    public static final String BACKGROUND_SOUND_SRC = "resource/sound/background.wav";

    public static final int WALL_TOP = 1;
    public static final int WALL_RIGHT = 2;
    public static final int WALL_BOTTOM = 3;
    public static final int WALL_LEFT = 4;
    public static final int WALL_NONE = 0;

    public static final int MOVE_TOP_DIRECTION = 1;
    public static final int MOVE_RIGHT_DIRECTION = 2;
    public static final int MOVE_BOTTOM_DIRECTION = 3;
    public static final int MOVE_LEFT_DIRECTION = 4;
    public static final int STOP = 0;

    public static final int MOVE_UNIT = 1;
    public static final int MOVE_RANGE = 90;


    public static final int SPRITE_PLAYER_WIDTH = 60;
    public static final int SPRITE_PLAYER_HEIGHT = 60;

    public static final int SPRITE_MUMMY_WIDTH = 60;
    public static final int SPRITE_MUMMY_HEIGHT = 60;

    public static final int TURN_OVER_SPEED = 50;

    public static int getPx(int oX){
        return pOX+oX * MOVE_RANGE + MOVE_RANGE/2 - 30;
    }

    public static int getPy(int oY){
        return pOY+oY * MOVE_RANGE + MOVE_RANGE/2 - 30;
    }

    public static int getOx(int px) {
        return (px - pOX) / MOVE_RANGE;
    }

    public static int getOy(int py){
        return (py-pOY)/MOVE_RANGE;
    }


}
