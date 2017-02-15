package Helper;

import Model.Cell;

/**
 * Created by Mr Hung on 1/27/2017.
 */
public class Helper {
    public static final String GAME_TITLE = "Mummy Maze Deluxe";
    public static final int WINDOW_WIDTH = 960;
    public static final int WINDOW_HEIGHT = 720;
    public static final int FPS = 5;
    public static final int FRAME_LOCATION_PX = 200;
    public static final int FRAME_LOCATION_PY = 50;

    public static final String BACKGROUND_SOUND_KEY = "Background_sound";
    public static final String SELECT_SOUND_KEY = "select_sound";
    public static final String LV1_SOUND_KEY = "lv1_sound";
    public static final String LV2_SOUND_KEY = "lv2_sound";
    public static final String LV3_SOUND_KEY = "lv3_sound";

    public static final int pOX = 320;
    public static final int pOY = 120;

    // Menu
    public static final String MENU_SCENE_START = "START";
    public static final String MENU_SCENE_HIGH_SCORE = "HIGH SCORE";
    public static final String MENU_SCENE_HELP = "HELP";
    public static final String MENU_SCENE_ABOUT = "ABOUT";
    public static final String MENU_SCENE_EXIT = "EXIT";

    public static final String PLAY_AGAIN = "PLAY AGAIN";
    public static final String GO_TO_MENU = "GO TO MENU";

    public static final int MENU_FONT_SIZE = 40;
    public static final String MENU_FONT_FAMILY = "Arial Black";
    public static final int MENU_DISTANCE_LINE = 60;

    public static final String MENU_BACKGROUND_SRC = "resource/image/title.jpg";
    public static final String ABOUT_BACKGROUND_SRC = "resource/image/about.png";
    public static final String HELP_BACKGROUND_SRC = "resource/image/help.png";

    public static final String GAME_PLAY_BACKGROUND_SRC = "resource/image/lvlEditor.png";
    public static final String PLAYER_SPRITE_SHEET_SRC = "resource/image/player.png";
    public static final String PLAYER_SPRITE_SRC = "resource/image/player_sprite.png";

    public static final String FLAG_SPRITE_SRC = "resource/image/flag.png";

    public static final String MUMMY_SPRITE_SHEET_SRC = "resource/image/mummy_white.png";
    public static final String MUMMY_SPRITE_SRC = "resource/image/mummy_sprite.png";

    public static final String BACKGROUND_SOUND_SRC = "resource/sound/background.wav";
    public static final String SELECT_SOUND_SRC = "resource/sound/select.wav";
    public static final String LV1_SOUND_SRC = "resource/sound/lv1.wav";
    public static final String LV2_SOUND_SRC = "resource/sound/lv2.wav";
    public static final String LV3_SOUND_SRC = "resource/sound/lv3.wav";

    public static final String WALL_TOP_SRC = "resource/image/wall_top.png";
    public static final String WALL_RIGHT_SRC = "resource/image/wall_right.png";
    public static final String WALL_BOTTOM_SRC = "resource/image/wall_bottom.png";
    public static final String WALL_LEFT_SRC = "resource/image/wall_left.png";

    public static final String GAME_OVER_BACKGROUND = "resource/image/game_over.png";


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

    public static Cell [][] MAP_LV1 =  {
            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(false,false,false,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(false,false,false,true),
                    new Cell(false,false,false,false), new Cell(true,true,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(true,true,false,false), new Cell(false,false,false,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(false,false,false,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(true,false,false,true),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(false,false,false,false),
                    new Cell(false,false,false,false), new Cell(true,false,false,true),  new Cell(false,false,false,false),},
    };

    public static Cell [][] MAP_LV2 =  {
            {new Cell(false,true,false,false), new Cell(false,false,false,false), new Cell(false,true,true,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(false,false,false,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(false,false,false,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(false,false,false,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(false,false,false,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(false,false,true,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},
    };

    public static Cell [][] MAP_LV3 =  {
            {new Cell(false,true,false,false), new Cell(false,false,false,false), new Cell(false,false,false,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(true,true,false,false),
                    new Cell(false,false,false,false), new Cell(true,true,true,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(false,false,true,false),
                    new Cell(false,true,false,false), new Cell(false,false,true,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(true,true,true,false),
                    new Cell(false,true,false,false), new Cell(false,true,true,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(false,false,false,false),
                    new Cell(false,false,true,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(false,false,false,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},
    };

    public static Cell [][] MAP_LV4 =  {
            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(false,false,false,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,true,false), new Cell(false,false,false,false), new Cell(true,true,false,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(false,false,false,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,true,false,false), new Cell(false,true,true,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(false,false,false,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,true,false), new Cell(false,false,false,false),
                    new Cell(false,false,false,true), new Cell(false,false,false,false),  new Cell(false,false,false,false),},
    };

    public static Cell [][] MAP_LV5 =  {
            {new Cell(false,false,false,false), new Cell(false,true,false,false), new Cell(false,false,false,false),
                    new Cell(true,true,false,false), new Cell(false,true,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(false,false,false,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,true,false), new Cell(false,false,false,false), new Cell(false,false,true,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,true),  new Cell(true,true,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(false,false,false,false),
                    new Cell(false,false,true,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,true,false), new Cell(false,false,false,false), new Cell(true,false,true,true),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},

            {new Cell(false,false,false,false), new Cell(false,false,false,false), new Cell(false,false,false,false),
                    new Cell(false,false,false,false), new Cell(false,false,false,false),  new Cell(false,false,false,false),},
    };

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

    public static int abs(int number) {
        if(number > 0)
            return number;
        else if(number < 0)
            return -number;
        else
            return 0;
    }


}
