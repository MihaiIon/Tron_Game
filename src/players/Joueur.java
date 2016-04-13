package players; /**
 * Created by farlyprj on 16-04-06.
 */
import java.awt.*;

import liste.Liste;
import players.attributes.*;
import players.attributes.Point;

public abstract class Joueur {

    // Attributs
    private Trace trace;
    private boolean isAlive;
    private Color couleur;
    private String direction_courante;
    private String nouvelle_direction; // WHY

    // Constructors
    public Joueur(Color color)
    {
        couleur = color;
        isAlive = true;
        trace   = new Trace();
    }

    public Joueur(int r, int g, int b)
    {
        couleur = new Color(r, g, b);
        isAlive = true;
        trace   = new Trace();
    }

    // Methods

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
    public void addSegment(int starting_x, int starting_y, int ending_x, int ending_y){
        trace.getSegments().append(
            new Segment(
                    new Point(starting_x, starting_y),
                    new Point(ending_x, ending_y)
            ));
    }

    // Getters
    public Trace getTrace() { return trace; }
    public Liste getSegments() { return trace.getSegments(); }
    public boolean isAlive(){ return isAlive; }
    public Color getColor() { return couleur; }
    public String getDirection() { return direction_courante; }

    // Setters
    public void killPlayer()   { isAlive = false; }
    public void revivePlayer() { isAlive = true;  }
    public void setDirection(String direction) { this.direction_courante = direction; }
}
