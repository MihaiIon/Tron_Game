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
    public static final Dimension TRON_CONTROL_PANEL_DIMESIONS = new Dimension(500, 500);
    public static final int TRON_CONTROL_PANEL_WIDTH = 500;
    public static final int TRON_CONTROL_PANEL_HEIGHT = 500;
    public static final Color TRON_CONTROL_PANEL_BACKGROUND_COLOR = new Color(15,15,15);

    // Players
    public static final int PLAYERS_DEFAULT_SPEED = 3;
    public static final int PLAYERS_BOOST_SPEED = 10;
    public static final int PLAYERS_BOOST_DURATION = 400;
}
