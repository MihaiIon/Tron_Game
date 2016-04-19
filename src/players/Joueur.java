package players; /**
 * Created by farlyprj on 16-04-06.
 */
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import components.Arene;
import constant.Direction;
import constant.Game;
import liste.Liste;
import mecanism.GameManager;
import players.attributes.*;
import players.attributes.Point;
import players.attributes.Segment;

public abstract class Joueur {

    // Attributs
    private Trace trace;
    private boolean boost;
    private boolean alive;
    private Color couleur;
    private String direction_courante;
    private String nouvelle_direction; // WHY
    //private int nb_of_boost;

    // Constructors
    public Joueur(Color color)
    {
        couleur = color;
        alive = true;
        boost = false;
    }

    public Joueur(int r, int g, int b)
    {
        couleur = new Color(r, g, b);
        alive = true;
    }

    // Methods
    /**
     * Generates random starting coordinates and direction for the player. This method then
     * initializes the player's Trace at that coordinate ( Point ). The direction is chosed
     * based on the player' starting coordinate : if the player is on the right-hand side of
     * the arena, it's direction will be LEFT, vice versa for the left-hand side.
     * @param arena_width : Arena's width
     * @param arena_height : Arena's height
     */
    public void initializeTrace(int arena_width, int arena_height)
    {
        int _player_x_position  = (int)(Math.random()*(arena_width - 2*Arene.ARENA_BORDER_WIDTH))
                                + Arene.ARENA_BORDER_WIDTH;
        direction_courante      = _player_x_position < arena_width/2
                                ? Direction.RIGHT
                                : Direction.LEFT;

        trace = new Trace(
            new Point(
                _player_x_position,
                (int)(Math.random()*(arena_height - 2*Arene.ARENA_BORDER_WIDTH)) + Arene.ARENA_BORDER_WIDTH
            ),
            direction_courante
        );
    }

    /**
     * **COMPLETE THIS**
     * @param starting_x : **COMPLETE THIS**
     * @param starting_y : **COMPLETE THIS**
     */
    public void addSegment(int starting_x, int starting_y){
        trace.getSegments().append(new Segment(new Point(starting_x, starting_y)));
    }

    /**
     * **COMPLETE THIS**
     * @param starting_x : **COMPLETE THIS**
     * @param starting_y : **COMPLETE THIS**
     * @param ending_x : **COMPLETE THIS**
     * @param ending_y : **COMPLETE THIS**
     */
    public void addSegment(int starting_x, int starting_y, int ending_x, int ending_y)
    {
        trace.getSegments().append(
            new Segment(
                new Point(starting_x, starting_y),
                new Point(ending_x, ending_y)
            )
        );
    }

    /**
     * Activates the boost and calls boostDuration() which sets a Timer to cancel the boost process after
     * a certain amount of time.
     */
    public void boost(){
        boost = true;
        setSpeed(Game.PLAYERS_BOOST_SPEED);
        boostDuration(this);
    }

    /**
     * Cancel the boost after a certain amount of time.
     * @param player : The current player using the boost.
     */
    private static void boostDuration(Joueur player){
        new Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                player.setBoost(false);
            }
        }, Game.PLAYERS_BOOST_DURATION);

    }

    /**
     * Prints object in console.
     */
    public void print(){ System.out.println(this); }

    /**
     * Returns players status <Player color> <Position> <Direction>
     * @return : Player status.
     */
    @Override
    public String toString() {
        return  "Player[" + couleur.toString() + "]" +
                "\n\t - Position (x,y) : (" + getCurrentPosition().getX() +
                "," + getCurrentPosition().getY() + ")" +
                "\n\t - Direction : " + direction_courante;
    }

    // Getters
    public boolean isAlive(){ return alive; }
    public boolean isBoosting() { return boost; }
    public Trace getTrace() { return trace; }
    public Liste getSegments() { return trace.getSegments(); }
    public Color getColor() { return couleur; }
    public Color getPathColor() { return new Color(couleur.getRed(), couleur.getGreen(), couleur.getBlue(), 200);}
    public Color getPathColor2(){
        return new Color(
            couleur.getRed()+120   > 255 ? 255 : couleur.getRed()+120,
            couleur.getGreen()+120 > 255 ? 255 : couleur.getGreen()+120,
            couleur.getBlue()+120  > 255 ? 255 : couleur.getBlue()+120,
            200
        );
    }
    public String getDirection() { return direction_courante; }
    public Point getCurrentPosition(){
        return ((Segment)getTrace().getSegments().getLast().content).getFin();
    }

    // Setters
    public void setDirection(String direction) { this.direction_courante = direction; }
    public void setSpeed(int default_players_peed) { trace.setSpeed(default_players_peed); }
    public void setBoost(boolean isBoosting) {
        boost = isBoosting;
        setSpeed(Game.PLAYERS_DEFAULT_SPEED);
    }
    public void revive() { alive = true;  }
    public void kill(){
        alive = false;
        GameManager.killPlayer();
    }
}
