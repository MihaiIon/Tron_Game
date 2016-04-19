package constant;

import java.awt.*;

/**
 * Created by Mihai-A on 15/04/2016.
 */
public class Game {

    // Game Status
    public static final String NULL = "NULL";
    public static final String IN_PROGRESS = "IN PROGRESS";
    public static final String PAUSED = "PAUSED";

    // TronControlPanel Properties
    public static final Dimension TRON_CONTROL_PANEL_DIMESIONS = new Dimension(500, 600);
    public static final int TRON_CONTROL_PANEL_WIDTH = 500;
    public static final int TRON_CONTROL_PANEL_HEIGHT = 600;
    public static final Color TRON_CONTROL_PANEL_BACKGROUND_COLOR = new Color(15,15,15);
    public static final Dimension TRON_PARAMETERS_DIMENSIONS = new Dimension(450, 30);
    public static final Dimension TRON_LIST_DIMENSIONS = new Dimension(200, 30);

    // Players
    public static final int PLAYERS_DEFAULT_SPEED = 3;
    public static final int PLAYERS_BOOST_SPEED = 10;
    public static final int PLAYERS_BOOST_DURATION = 400;
    public static final Color PLAYER_1_COLOR = new Color(251, 158, 17);
    public static final Color PLAYER_2_COLOR = new Color(96, 197, 226);
    public static final Color COMPUTER_COLOR = new Color(255, 35, 65);
}
