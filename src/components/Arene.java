package components;

import liste.Liste;
import liste.Noeud;
import players.ComputerPlayer;
import players.HumanPlayer;
import players.Joueur;
import players.attributes.Segment;
import players.controls.Controls;

import javax.swing.*;
import java.awt.*;

/**
 * Created by farlyprj on 16-04-06.
 */
public class Arene extends JComponent{

    // Attributs
    private int largeur_grille;
    private int hauteur_grille;
    private boolean multiplayer;
    private Joueur[] joueurs;

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

        // Players
        joueurs = new Joueur[]{
            new HumanPlayer(251, 118, 6),       // Custom Orange : rgb(251, 118, 6)
            new ComputerPlayer(Color.red)
        };

        addKeyListener(new Controls());
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

        // Players
        if (multiplayer)
            joueurs = new Joueur[]{
                new HumanPlayer(251, 118, 6),   // Custom Orange : rgb(251, 118, 6)
                new HumanPlayer(26, 199, 226),  // Custom Cyan   : rgb(26, 199, 226)
                new ComputerPlayer(Color.red)
            };
        else
            joueurs = new Joueur[]{
                new HumanPlayer(251, 118, 6),   // Custom Orange : rgb(251, 118, 6)
                new ComputerPlayer(Color.red)
            };

        addKeyListener(new Controls());
    }

    // Methods
    /**
     * On paint, this methods draws all segments related to all players.
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0, 0, 0, 220));
        g.fillRect(0, 0, getWidth(), getHeight());
        for (Joueur joueur : joueurs){

            g.setColor(joueur.getColor());    // Sets segments color;
            Liste segments = joueur.getTrace().getSegments();

            for (int i = 0; i < joueur.getTrace().getSegments().size(); i++) {
                g.drawLine(
                    ((Segment)((Noeud)segments.get(i)).content).getDebut().getX(),
                    ((Segment)((Noeud)segments.get(i)).content).getDebut().getY(),
                    ((Segment)((Noeud)segments.get(i)).content).getFin().getX(),
                    ((Segment)((Noeud)segments.get(i)).content).getFin().getY()
                );
            }
        }
    }

    /**
     * Sets the arena dimensions and adds borders to it.
     * @return
     */
    private void setBackgroundAndBorders(){
        setPreferredSize(new Dimension(largeur_grille, hauteur_grille));
        setBorder(BorderFactory.createLineBorder(Color.white, 8));
    }

    // Getters
    public int getLargeur_grille() { return largeur_grille; }
    public int getHauteur_grille() { return hauteur_grille; }
    public boolean isMultiplayer() { return multiplayer;    }
    public Joueur[] getPlayers()   { return joueurs;        }
}
