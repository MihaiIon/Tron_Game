package mecanism;

/**
 * Created by Mihai-A on 27/04/2016.
 */
public class Options {

    // Attributes
    private int arena_width;
    private int arena_height;
    private int player_speed;
    private boolean multiplayer;
    private boolean computer_player;

    // Constructor
    public Options(Object[] raw_options)
    {
        arena_width = (int)raw_options[0];
        arena_height = (int)raw_options[1];
        multiplayer = (boolean)raw_options[2];
        computer_player = (boolean)raw_options[3];
        player_speed = (int)raw_options[4];
    }

    // Getters
    public int getArenaWidth()  { return arena_width; }
    public int getArenaHeight() { return arena_height; }
    public int getPlayerSpeed() { return player_speed; }
    public boolean isMultiplayer() { return multiplayer; }
    public boolean isComputerPlayer() { return computer_player; }
}
