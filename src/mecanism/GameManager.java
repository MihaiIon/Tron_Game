package mecanism;

import components.Arene;
import components.TronPanel;
import constant.Direction;
import constant.RefreshRate;
import players.Joueur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.DirectColorModel;
import java.util.Timer;

/**
 * Created by Mihai-A on 12/04/2016.
 */
public class GameManager implements KeyListener {

    // Attributs
    private Arene arena;
    private Joueur[] players;
    private TronPanel tron_panel;
    private TronTimer tron_timer;
    private boolean console_info;
    private int refresh_rate;

    // Static Attributes
    private static final Timer timer = new Timer();

    // Constructor
    /**
     * GameManager manages all aspects of the game.
     * @param tron_panel : JComponent containing all classes related to our Game.
     */
    public GameManager(TronPanel tron_panel) {
        this.tron_panel = tron_panel;
        arena = tron_panel.getArena();
        players = tron_panel.getArena().getPlayers();
        tron_timer = new TronTimer(tron_panel);
        refresh_rate = RefreshRate.FPS_30;
    }

    // Methods
    /**
     * Starts the game. This method uses a timer to move forward each player ( frame-by-frame ).
     */
    public void start(){ timer.scheduleAtFixedRate(tron_timer, 0, refresh_rate); }

    /**
     * Pauses the game. Players movements are stopped.
     */
    public void pause(){ timer.cancel(); }

    /**
     * Creates a new arena with Default settings : < width : 500 > < height : 500 >.
     * Then replaces the main arena.
     */
    public void createNewArena(){
        tron_panel.setArena(new Arene());
        arena = tron_panel.getArena();
        players = tron_panel.getArena().getPlayers();
        tron_timer = new TronTimer(tron_panel);
    }

    /**
     * Creates a new Arena with custom settings.
     * @param width : Width of the arena. < MIN : **COMPLETE THIS**> < MAX : **COMPLETE THIS**>
     * @param height : Height of the arena. < MIN : **COMPLETE THIS**> < MAX : **COMPLETE THIS**>
     * @param multiplayer : Is the game multiplayer ( Two players + Computer ) or not.
     */
    public void createNewArena(int width, int height, boolean multiplayer){
        tron_panel.setArena(new Arene(width, height, multiplayer));
        arena = tron_panel.getArena();
        players = tron_panel.getArena().getPlayers();
        tron_timer = new TronTimer(tron_panel);
    }

    // Getters
    public Arene getArena() { return arena; }
    public Joueur[] getPlayers() { return players; }

    // Setters
    /**
     * If console_info is set to true, informations about players will be printed in the console
     * @param state : True/False
     */
    public void setConsoleInfo(boolean state){
        console_info = state;
        tron_timer.setConsoleInfo(state);
    }

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

    /*
     ************************************************************

        CONTROLS

     ************************************************************
     ************************************************************/
    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                System.out.println("Player_1 : Up");
                break;
            case KeyEvent.VK_D:
                System.out.println("Player_1 : RIGHT");
                break;
            case KeyEvent.VK_S:
                System.out.println("Player_1 : DOWN");
                break;
            case KeyEvent.VK_A:
                System.out.println("Player_1 : LEFT");
                break;
            case KeyEvent.VK_UP:
                System.out.println("Player_2 : Up");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Player_2 : RIGHT");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Player_2 : DOWN");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Player_2 : LEFT");
                break;
            default:
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }
}
