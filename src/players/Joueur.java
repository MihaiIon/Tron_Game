package players; /**
 * Created by farlyprj on 16-04-06.
 */
import java.awt.*;
import components.Trace;

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

    // Getters
    public Trace getTrace() { return trace; }
    public boolean isAlive(){ return isAlive; }
    public Color getColor() { return couleur; }
    public String getDirection() { return direction_courante; }

    // Setters
    public void killPlayer()   { isAlive = false; }
    public void revivePlayer() { isAlive = true;  }
    public void setDirection(String direction) { this.direction_courante = direction; }
}
