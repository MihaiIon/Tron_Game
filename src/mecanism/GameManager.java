package mecanism;

import components.Arene;
import components.TronPanel;
import players.Joueur;

import java.util.Timer;

/**
 * Created by Mihai-A on 12/04/2016.
 */
public class GameManager {

    // Attributs
    private Arene arena;
    private Joueur[] players;
    private TronPanel tron_panel;
    private TronTimer tron_timer;
    private boolean console_info;

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
    }

    // Methods
    /**
     * Starts the game. This method uses a timer to move forward each player ( frame-by-frame ).
     */
    public void start(){ timer.scheduleAtFixedRate(tron_timer, 0, 33); }

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
     * If console_info is set to true, informations about players and the arenas will be printed in the console
     * @param state : True/False
     */
    public void setConsoleInfo(boolean state){
        console_info = state;
        tron_timer.setConsoleInfo(state);
    }
}
