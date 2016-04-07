package components;

import liste.ListeChainee;
import players.ComputerPlayer;
import players.HumanPlayer;
import players.Joueur;

import javax.swing.*;
import java.awt.*;

/**
 * Created by farlyprj on 16-04-06.
 */
public class Arene extends JComponent{

    // Attributs
    private int largeur_grille;
    private int hauteur_grille;
    private Joueur[] joueurs;

    // Contructor
    /**
     * Creates a JComponent representing the game arena. Default constructor generates
     * an Arena of 500 x 500, a Tron HumanPlayer and a Tron ComputerPlayer.
     */
    public Arene()
    {
        // Default dimensions
        largeur_grille = 500;
        hauteur_grille = 500;

        // Players
        joueurs = new Joueur[]{
            new HumanPlayer(251, 118, 6),       // Custom Orange : rgb(251, 118, 6)
            new ComputerPlayer(Color.red)
        };
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
        // Dimensions
        largeur_grille = width;
        hauteur_grille = height;

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
    }

    // Methods
    /**
     * On repaint, this methods draws all segments related to all players.
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        Dimension d = getPreferredSize();
        for (Joueur joueur : joueurs){

            g.setColor(joueur.getCouleur());    // Sets segments color;

            for (int i = 0; i < joueur.getTrace().getSegments().size(); i++) {
                g.drawLine(
                    ((Point)joueur.getTrace().getSegments().getFirst()).getX(),
                    ((Point)joueur.getTrace().getSegments().getFirst()).getY(),
                    ((Point)joueur.getTrace().getSegments().getLast()).getX(),
                    ((Point)joueur.getTrace().getSegments().getLast()).getX()
                );
            }
        }
    }

    // Getters
    public int getLargeur_grille() { return largeur_grille; }
    public int getHauteur_grille() { return hauteur_grille; }
    public Joueur[] getJoueurs() { return joueurs; }
}
