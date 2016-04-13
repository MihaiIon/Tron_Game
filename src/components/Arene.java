package components;

import liste.Liste;
import liste.Noeud;
import players.ComputerPlayer;
import players.HumanPlayer;
import players.Joueur;
import players.attributes.Segment;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by farlyprj on 16-04-06.
 */
public class Arene extends JComponent{

    // Attributs
    private int largeur_grille;
    private int hauteur_grille;
    private boolean multiplayer;
    private Joueur[] joueurs;

    // Static Attributes
    public static final int ARENA_BORDER_WIDTH = 8;
    public static final int PLAYER_PATH_WIDTH  = 3;
    public static final int PLAYER_PATH2_WIDTH = PLAYER_PATH_WIDTH + 2;

    // Contructor
    /**
     * Creates a JComponent representing the game arena. Default constructor generates
     * an Arena of 500 x 500, a Tron HumanPlayer and a Tron ComputerPlayer.
     */
    public Arene()
    {
        // Initialize Arene
        largeur_grille = 500;
        hauteur_grille = 500;
        multiplayer = false;
        setBackgroundAndBorders();
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));

        // Players
        joueurs = new Joueur[]{
            new HumanPlayer(new Color(251, 158, 17)),   // Custom Orange : rgb(251, 158, 17)
            new ComputerPlayer(new Color(255, 35, 65))  // Custom Red : rgb (255, 35, 65)
        };

        initializePlayersTrace();
    }

    /**
     * Creates a JComponent representing the game arena. Width, height and number
     * of HumanPlayers (1 or 2) can be setted via this constructor
     * @param width
     * @param height
     * @param multiplayer
     */
    public Arene(int width, int height, boolean multiplayer)
    {
        // Initialize Arene
        largeur_grille = width;
        hauteur_grille = height;
        this.multiplayer = multiplayer;
        setBackgroundAndBorders();
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));

        // Players
        if (multiplayer)
            joueurs = new Joueur[]{
                new HumanPlayer(new Color(251, 158, 17)),   // Custom Orange : (251, 158, 17)
                new HumanPlayer(new Color(96, 197, 226)),   // Custom Cyan   : rgb(96, 197, 226)
                new ComputerPlayer(Color.red)
            };
        else
            joueurs = new Joueur[]{
                new HumanPlayer(new Color(251, 158, 17)),   // Custom Orange : rgb(251, 158, 17)
                new ComputerPlayer(new Color(255, 35, 65))  // Custom Red : rgb (255, 35, 65)
            };

        initializePlayersTrace();
    }

    // Methods
    /**
     * Initializes every player's Trace.
     */
    private void initializePlayersTrace()
    {
        for (Joueur player : joueurs)
            player.initializeTrace(largeur_grille, hauteur_grille);
    }

    /**
     * On paint, this methods draws all segments related to all players.
     * @param g
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(new Color(0, 0, 0, 200));
        g.fillRect(0, 0, getWidth(), getHeight());
        Graphics2D line = (Graphics2D) g;

        Liste segments;

        for (Joueur player : joueurs){

            segments = player.getSegments();

            for (int i = 0; i < segments.size(); i++) {

                line.setColor(player.getPathColor2());                       // Get player color
                line.setStroke(new BasicStroke(
                    PLAYER_PATH2_WIDTH,                                      // Set stroke width
                    BasicStroke.CAP_ROUND,                                   // Set stroke End-cap style
                    BasicStroke.JOIN_ROUND)                                  // Set stroke Join style
                );
                line.draw(new Line2D.Float(                                  // Draw player Path
                    ((Segment)segments.get(i).content).getDebut().getX(),
                    ((Segment)segments.get(i).content).getDebut().getY(),
                    ((Segment)segments.get(i).content).getFin().getX(),
                    ((Segment)segments.get(i).content).getFin().getY()
                ));
                line.setColor(player.getPathColor());
                line.setStroke(new BasicStroke(
                    PLAYER_PATH_WIDTH,                                      // Set stroke width
                    BasicStroke.CAP_ROUND,                                  // Set stroke End-cap style
                    BasicStroke.JOIN_ROUND)                                 // Set stroke Join style
                );
                line.draw(new Line2D.Float(                                 // Draw player Glow Path
                    ((Segment)segments.get(i).content).getDebut().getX(),
                    ((Segment)segments.get(i).content).getDebut().getY(),
                    ((Segment)segments.get(i).content).getFin().getX(),
                    ((Segment)segments.get(i).content).getFin().getY()
                ));
            }
        }
    }

    /**
     * Prints object to console.
     */
    public void print(){ System.out.println(this); }

    /**
     * Sets the arena dimensions and adds borders to it.
     * @return
     */
    private void setBackgroundAndBorders(){
        setPreferredSize(new Dimension(largeur_grille, hauteur_grille));
        setBorder(BorderFactory.createLineBorder(Color.white, ARENA_BORDER_WIDTH));
    }

    // Getters
    public int getLargeur_grille() { return largeur_grille; }
    public int getHauteur_grille() { return hauteur_grille; }
    public boolean isMultiplayer() { return multiplayer;    }
    public Joueur[] getPlayers()   { return joueurs;        }

    /**
     *  Arena toString override method
     */
    @Override
    public String toString(){
        String _output = "Arena Info :"
                + "\n\tWidth : " + largeur_grille
                + "\n\tHeight : " + hauteur_grille;
        return _output + "\n\tNumber of Players : " + getPlayers().length;
    }
}
