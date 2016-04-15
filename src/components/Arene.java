package components;

import constant.Game;
import liste.Liste;
import players.ComputerPlayer;
import players.HumanPlayer;
import players.Joueur;
import players.attributes.Point;
import players.attributes.Segment;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.geom.Line2D;

/**
 * Created by farlyprj on 16-04-06.
 */
public class Arene extends JComponent{

    // Attributs
    private int largeur_grille;
    private int hauteur_grille;
    private boolean computer_player;
    private boolean multiplayer;
    private Joueur[] joueurs;
    private Segment[] background_grid;

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
        computer_player = true;
        background_grid = generateBackgroundGrid();
        setBackgroundAndBorders();
        setOpaque(false);

        // Players
        joueurs = new Joueur[]{
            new HumanPlayer(Game.PLAYER_1_COLOR),
            new ComputerPlayer(Game.COMPUTER_COLOR)
        };

        initializePlayersTrace();
    }

    /**
     * Creates a JComponent representing the game arena. Width, height and number
     * of HumanPlayers (1 or 2) can be setted via this constructor
     * @param width : **COMPLETE THIS**
     * @param height : **COMPLETE THIS**
     * @param multiplayer : **COMPLETE THIS**
     * @param computer_player : **COMPLETE THIS**
     */
    public Arene(int width, int height, boolean multiplayer, boolean computer_player)
    {
        // Initialize Arene
        largeur_grille = width;
        hauteur_grille = height;
        background_grid = generateBackgroundGrid();
        this.multiplayer = multiplayer;
        this.computer_player = computer_player;
        setBackgroundAndBorders();
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));

        // Players
        configurePlayers(multiplayer, computer_player);
        initializePlayersTrace();
    }

    // Methods
    /**
     * **COMPLETE THIS**
     * @param player_current_coordinates : **COMPLETE THIS**
     * @return : **COMPLETE THIS**
     */
    public boolean isPlayerInCollisionWithArenaWalls(Point player_current_coordinates)
    {
        return  player_current_coordinates.getX() > largeur_grille - ARENA_BORDER_WIDTH  ||
                player_current_coordinates.getY() > hauteur_grille - ARENA_BORDER_WIDTH  ||
                player_current_coordinates.getX() < ARENA_BORDER_WIDTH ||
                player_current_coordinates.getY() < ARENA_BORDER_WIDTH;
    }

    /**
     * **COMPLETE THIS**
     * @param player_current_position : **COMPLETE THIS**
     * @param player_last_position : **COMPLETE THIS**
     * @return : **COMPLETE THIS**
     */
    public boolean isPlayerInCollisionWithPath(Point player_current_position, Point player_last_position)
    {
        for(Joueur player : joueurs)
            if (player.getTrace().contient(player_current_position, player_last_position))
                return true;

        return false;
    }

    /**
     * Initializes every player's Trace.
     */
    private void initializePlayersTrace()
    {
        for (Joueur player : joueurs)
            player.initializeTrace(largeur_grille, hauteur_grille);
    }

    /**
     * Revives each player and initializes with new a starting position and a new Trace.
     */
    public void revivePlayers()
    {
        for (Joueur player : joueurs) {
            player.revive();
            player.initializeTrace(largeur_grille, hauteur_grille);
        }
    }

    /**
     * **COMPLETE THIS**
     * @param multiplayer : **COMPLETE THIS**
     * @param computer_player : **COMPLETE THIS**
     */
    public void configurePlayers(boolean multiplayer, boolean computer_player){
        if (multiplayer && computer_player)
            joueurs = new Joueur[]{
                    new HumanPlayer(Game.PLAYER_1_COLOR),
                    new HumanPlayer(Game.PLAYER_2_COLOR),
                    new ComputerPlayer(Game.COMPUTER_COLOR)
            };
        else if(multiplayer)
            joueurs = new Joueur[]{
                    new HumanPlayer(Game.PLAYER_1_COLOR),
                    new HumanPlayer(Game.PLAYER_2_COLOR)
            };
        else
            joueurs = new Joueur[]{
                    new HumanPlayer(Game.PLAYER_1_COLOR),
                    new ComputerPlayer(Game.COMPUTER_COLOR)
            };
    }

    /**
     * Generate the background grid of the Arena by creating segments that will be called and drawn
     * in paintComponent() method.
     * @return : Array of segments forming the grid.
     */
    private Segment[] generateBackgroundGrid()
    {
        int _vertical_segments   = (int)Math.floor(largeur_grille/20);
        int _horizontal_segments = (int)Math.floor(hauteur_grille/20);
        Segment[] _segments = new Segment[_horizontal_segments+_vertical_segments];

        for (int i=0; i < _vertical_segments; i++)
            _segments[i] = new Segment(
                new Point(20*(i+1), 0),
                new Point(20*(i+1), hauteur_grille)
            );

        for (int i=_vertical_segments; i < _segments.length; i++)
            _segments[i] = new Segment(
                new Point(0, 20*(i+1-_vertical_segments)),
                new Point(largeur_grille, 20*(i+1-_vertical_segments))
            );

        return _segments;
    }

    /**
     * On paint, this methods draws the background grid and all players paths.
     * @param g : Graphics g
     */
    @Override
    public void paintComponent(Graphics g)
    {
        // Fills the background
        super.paintComponent(g);
        g.setColor(new Color(0, 0, 0, 150));
        g.fillRect(0, 0, getWidth(), getHeight());
        Graphics2D line = (Graphics2D) g;

        // Draws grid
        line.setColor(new Color(255, 255, 255, 12));
        line.setStroke(new BasicStroke(2));
        for (Segment _segment : background_grid){
            line.draw(new Line2D.Float(                                  // Draw player Path
                _segment.getDebut().getX(),
                _segment.getDebut().getY(),
                _segment.getFin().getX(),
                _segment.getFin().getY()
            ));
        }

        // Draws paths
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
     * @return : **COMPLETE THIS**
     */
    private void setBackgroundAndBorders(){
        setPreferredSize(new Dimension(largeur_grille, hauteur_grille));
        setBorder(BorderFactory.createLineBorder(Color.white, ARENA_BORDER_WIDTH));
    }

    // Getters
    public int getLargeur_grille()      { return largeur_grille;  }
    public int getHauteur_grille()      { return hauteur_grille;  }
    public boolean isMultiplayer()      { return multiplayer;     }
    public boolean isComputerPlayer()   { return computer_player; }
    public Joueur[] getPlayers()        { return joueurs;         }

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
