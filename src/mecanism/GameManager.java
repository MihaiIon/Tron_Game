package mecanism;

import components.Arene;
import components.TronControlPanel;
import components.TronPanel;
import components.subcomponents.PlayersBoard.PlayersBoard;
import constant.Direction;
import constant.Game;
import constant.RefreshRate;
import players.ComputerPlayer;
import players.HumanPlayer;
import players.Joueur;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

/**
 * Created by Mihai-A on 12/04/2016.
 */
public class GameManager implements KeyListener {

    // Attributs
    private static Arene arena;
    private static TronPanel tron_panel;
    private static TronControlPanel tron_control_panel;
    private static PlayersBoard players_board;
    private boolean console_info;
    private static int refresh_rate;

    // Game flow variables
    private static Timer timer;
    private static String game_state;
    private static int players_alive_count;
    private static Joueur[] players;

    // Constructor
    /**
     * GameManager manages all aspects of the game.
     * @param tron_panel : JComponent containing all classes related to our Game.
     */
    public GameManager(TronPanel tron_panel) {
        GameManager.tron_panel = tron_panel;
        tron_control_panel = tron_panel.getControlPanel();
        players_board = tron_control_panel.getPlayersBoard();
        arena = tron_panel.getArena();
        players = tron_panel.getArena().getPlayers();
        players_alive_count = players.length;
        refresh_rate = RefreshRate.FPS_30;
        game_state = Game.NULL;
    }

    // Methods
    /**
     * Starts the game. This method uses a timer to move forward each player ( frame-by-frame ).
     */
    public static void start(){
        if (timer != null) timer.cancel();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TronTimer(), 0, refresh_rate);
        game_state = Game.IN_PROGRESS;
    }

    /**
     * Pauses the game. Players movements are stopped.
     */
    public static void pause()
    {
        game_state = Game.PAUSED;
        timer.cancel();
    }

    /**
     * Resumes the game if there'a game in progress ( players are alive ). Players start moving again from current position.
     */
    public static void resume()
    {
        if(game_state.equals(Game.PAUSED)){
            game_state = Game.IN_PROGRESS;
            start();
        }
    }

    /**
     * **COMPLETE THIS**
     * @param winner : **COMPLETE THIS**
     */
    public static void endGame(Joueur winner){

        // End game
        timer.cancel();
        game_state = Game.NULL;

        // Winner
        String _winner = null;
        Color _winner_color = Color.white;

        // Find winner
        int _human_player_counter = 0;
        for (int i=0; i<players.length; i++){
            if (players[i] instanceof HumanPlayer){
                _human_player_counter++;
                if (players[i] == winner) {
                    _winner = "Player " + _human_player_counter;
                    _winner_color = players[i].getColor();
                    players_board.getPlayerInfos(i).addWin();
                    break;
                }
            }
            if (players[i] instanceof ComputerPlayer){
                _human_player_counter++;
                if (players[i] == winner) {
                    _winner = "Computer";
                    _winner_color = players[i].getColor();
                    players_board.getPlayerInfos(i).addWin();
                    break;
                }
            }
        }

        tron_control_panel.displayWinner(_winner, _winner_color);
    }

    /**
     * If the settings are the same on replay, it keeps the same Arena and only resets the players.
     * Else, it creates a whole new Arena.
     */
    public static void replay(int arena_width, int arena_height, boolean multiplayer, boolean computer_player)
    {
        tron_control_panel.stopDisplayingWinner();

        if (arena_width == arena.getLargeur_grille() && arena_height == arena.getHauteur_grille() &&
                multiplayer == arena.isMultiplayer() && computer_player == arena.isComputerPlayer())
        {
            arena.revivePlayers();
            players_board.resetStatus();
            players_alive_count = players.length;
        }

        else createNewArena(arena_width, arena_height, multiplayer, computer_player);

        start();
    }

    /**
     * **COMPLETE THIS**
     * @param multiplayer : **COMPLETE THIS**
     * @param computer_player : **COMPLETE THIS**
     */
    public void reConfigurePlayers(boolean multiplayer, boolean computer_player){
        arena.configurePlayers(multiplayer, computer_player);
        players = arena.getPlayers();
    }

    /**
     * Creates a new Arena with custom settings.
     * @param width : Width of the arena. < MIN : **COMPLETE THIS**> < MAX : **COMPLETE THIS**>
     * @param height : Height of the arena. < MIN : **COMPLETE THIS**> < MAX : **COMPLETE THIS**>
     * @param multiplayer : Is the game multiplayer ( Two players + Computer ) or not.
     */
    public static void createNewArena(int width, int height, boolean multiplayer, boolean computer_player){
        tron_panel.setArena(new Arene(width, height, multiplayer, computer_player));
        arena = tron_panel.getArena();
        players = tron_panel.getArena().getPlayers();
        players_alive_count = players.length;
        players_board.initializePlayers(players);
    }

    // Getters
    public static Arene getArena() { return arena; }
    public boolean isConsoleInfoON() { return console_info; }
    public static String getGameState() { return game_state; }
    public static Joueur[] getPlayers() { return players; }
    public static int getPlayersAliveCount() { return players_alive_count; }
    public static PlayersBoard getPlayersBoard() { return players_board; }

    // Setters
    /**
     * If console_info is set to true, informations about players will be printed in the console
     * @param state : True/False
     */
    public void setConsoleInfo(boolean state){ console_info = state; }

    /**
     * Sets the rate at which the game will refresh it's content. Setting it to SLOWER_DEBUG_MODE
     * will automatically set console_info to true.
     * @param refresh_rate : Refresh rate ( FPS )
     */
    public void setRefreshRate(int refresh_rate){
        this.refresh_rate = refresh_rate;
        if (refresh_rate == RefreshRate.SLOWER_DEBUG_MODE) setConsoleInfo(true);
    }

    /**
     * **COMPLETE THIS**
     * @param default_players_peed : **COMPLETE THIS**
     */
    public void setDefaultPlayersSpeed(int default_players_peed){
        for (Joueur player : players)  player.setSpeed(default_players_peed);
    }

    /**
     * Diminish players_alive by one.
     */
    public static void killPlayer(){ players_alive_count--; }



    /*
     ************************************************************

        CONTROLS

     ************************************************************
     ************************************************************/

    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    public void keyPressed(KeyEvent e) {


        /*
            First Player Controls

        ***************************************************/

        if (players[0].isAlive()){
            switch (e.getKeyCode()){
                case KeyEvent.VK_W:
                    if (!players[0].getDirection().equals( Direction.UP ) && !Direction.isOpposite(players[0].getDirection(), Direction.UP)){
                        players[0].setDirection(Direction.UP); }
                    break;
                case KeyEvent.VK_D:
                    if (!players[0].getDirection().equals( Direction.RIGHT ) && !Direction.isOpposite(players[0].getDirection(), Direction.RIGHT)){
                        players[0].setDirection(Direction.RIGHT); }
                    break;
                case KeyEvent.VK_S:
                    if (!players[0].getDirection().equals( Direction.DOWN ) && !Direction.isOpposite(players[0].getDirection(), Direction.DOWN)){
                        players[0].setDirection(Direction.DOWN); }
                    break;
                case KeyEvent.VK_A:
                    if (!players[0].getDirection().equals( Direction.LEFT ) && !Direction.isOpposite(players[0].getDirection(), Direction.LEFT)){
                        players[0].setDirection(Direction.LEFT); }
                    break;
                case KeyEvent.VK_SPACE:
                    if (!players[0].isBoosting()) players[0].boost();
                    break;
                default:
            }
        }


        /*
            Second Player Controls

         ***************************************************/

        if (arena.isMultiplayer() && players[1].isAlive()){
            switch (e.getKeyCode()){
                case KeyEvent.VK_UP:
                    if (!players[1].getDirection().equals( Direction.UP ) && !Direction.isOpposite(players[1].getDirection(), Direction.UP)){
                        players[1].setDirection(Direction.UP); }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (!players[1].getDirection().equals( Direction.RIGHT ) && !Direction.isOpposite(players[1].getDirection(), Direction.RIGHT)){
                        players[1].setDirection(Direction.RIGHT); }
                    break;
                case KeyEvent.VK_DOWN:
                    if (!players[1].getDirection().equals( Direction.DOWN ) && !Direction.isOpposite(players[1].getDirection(), Direction.DOWN)){
                        players[1].setDirection(Direction.DOWN); }
                    break;
                case KeyEvent.VK_LEFT:
                    if (!players[1].getDirection().equals( Direction.LEFT ) && !Direction.isOpposite(players[1].getDirection(), Direction.LEFT)){
                        players[1].setDirection(Direction.LEFT); }
                    break;
                case KeyEvent.VK_NUMPAD0:
                    if (!players[1].isBoosting())  players[1].boost();
                    break;
                default:
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        /*
            General Controls

        ***************************************************/

        switch (e.getKeyCode()){
            case KeyEvent.VK_R:                                     // Reset Game

                replay(arena.getLargeur_grille(), arena.getHauteur_grille(), true, false);
                break;

            case KeyEvent.VK_P:

                if (game_state.equals(Game.IN_PROGRESS)) pause();   // Pause Game
                else if (game_state.equals(Game.PAUSED)) resume();  // Resume Game
                break;

            case KeyEvent.VK_U:

                start();                                            // Start Game
                break;

            default:
        }

    }
}