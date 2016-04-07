package players; /**
 * Created by farlyprj on 16-04-06.
 */
import java.awt.*;
import components.Trace;

public abstract class Joueur {

    // Attributs
    private Trace t;
    private boolean isAlive;
    private Color couleur;

    // Constructors
    public Joueur(Color color){
        couleur = color;
        isAlive = true;
        //t = new Trace();
    }

    public Joueur(int r, int g, int b){
        couleur = new Color(r, g, b);
        isAlive = true;
        //t = new Trace();
    }

    // Getters
    public Trace getT() { return t; }
    public boolean isAlive()  { return isAlive; }
    public Color getCouleur() { return couleur; }

    // Setters
    public void setAlive(boolean alive) { isAlive = alive; }
}
