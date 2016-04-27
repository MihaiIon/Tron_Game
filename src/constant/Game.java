package constant;

import java.awt.*;

/**
 * Created by Mihai-A on 15/04/2016.
 */
public class Game {

    /**
     * Game status
     */
    public static final String NULL = "NULL";
    public static final String IN_PROGRESS = "IN PROGRESS";
    public static final String PAUSED = "PAUSED";

    /**
     * TronControlPanel Properties
     */
    public static final Dimension TRON_CONTROL_PANEL_DIMESIONS = new Dimension(500, 700);
    public static final int TRON_CONTROL_PANEL_WIDTH = TRON_CONTROL_PANEL_DIMESIONS.width;
    public static final int TRON_CONTROL_PANEL_HEIGHT = TRON_CONTROL_PANEL_DIMESIONS.height;

    public static final Color TRON_CONTROL_PANEL_BACKGROUND_COLOR = new Color(15,15,15);
    public static final Color TRON_OPTIONS_LABELS_COLOR = new Color(180,180,180);
    public static final Color TRON_OPTIONS_BOXES_TEXT_COLOR = new Color(60,60,60);
    public static final Color START_BTN_DEFAULT_BACKGROUND_COLOR = new Color (57,163,157);
    public static final Color PAUSE_BTN_DEFAULT_BACKGROUND_COLOR = new Color (201, 171, 52);
    public static final Color PAUSE_BTN_DEFAULT_FORGROUND_COLOR = new Color (151, 121, 48);
    public static final Color PAUSE_BTN_INACTIVE_BACKGROUND_COLOR = new Color (71, 71, 70);
    public static final Color PAUSE_BTN_INACTIVE_FORGROUND_COLOR = new Color (55, 55, 54);
    public static final Color PAUSE_BTN_PAUSED_BACKGROUND_COLOR = new Color (44, 158, 77);
    public static final Color PAUSE_BTN_PAUSED_FORGROUND_COLOR_1 = new Color (71, 184, 92);
    public static final Color PAUSE_BTN_PAUSED_FORGROUND_COLOR_2 = new Color (41, 113, 57);

    public static final Dimension TRON_JLABELS_CONTAINER_DIMENSIONS = new Dimension(140, 120);
    public static final Dimension TRON_JCOMPONENTS_CONTAINER_DIMENSIONS = new Dimension(220, 120);
    public static final Dimension TRON_JCOMBOBOXES_CONTAINER_DIMENSIONS = new Dimension(220, 40);

    public static final Dimension TRON_OPTIONS_DIMENSIONS = new Dimension(220, 30);

    /**
     * PlayerBoard
     */
    public static final int PLAYERS_BOARD_CONTAINER_WIDTH = TRON_CONTROL_PANEL_WIDTH-50;
    public static final int PLAYERS_BOARD_CONTAINER_HEIGHT = 160;
    public static final int PLAYERS_BOARD_WIDTH = PLAYERS_BOARD_CONTAINER_WIDTH-22;
    public static final int PLAYERS_BOARD_HEIGHT = PLAYERS_BOARD_CONTAINER_HEIGHT-40;

    /**
     * Players
     */
    public static final int PLAYERS_DEFAULT_SPEED = 3;
    public static final int PLAYERS_BOOST_SPEED = 10;
    public static final int PLAYERS_BOOST_DURATION = 400;
    public static final Color PLAYER_1_COLOR = new Color(251, 158, 17);
    public static final Color PLAYER_2_COLOR = new Color(96, 197, 226);
    public static final Color COMPUTER_COLOR = new Color(255, 35, 65);
    public static final String PLAYER_STATUS_ALIVE = "ALIVE";
    public static final String PLAYER_STATUS_DEAD = "DEAD";
}
