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
    private String nouvelle_direction;

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
    public boolean isAlive()  { return isAlive; }
    public Color getCouleur() { return couleur; }
    public String getDirection_courante() { return direction_courante; }
    public String getNouvelle_direction() { return nouvelle_direction; }

    // Setters
    public void setAlive(boolean alive) { isAlive = alive; }
    public void setDirection_courante(String direction_courante) { this.direction_courante = direction_courante; }
    public void setNouvelle_direction(String nouvelle_direction) { this.nouvelle_direction = nouvelle_direction; }
}
