package com.company;

import components.Arene;
import components.TronPanel;
import players.Joueur;

/**
 * Created by Mihai-A on 12/04/2016.
 */
public class GameManager {

    // Attributs
    private Arene arena;
    private Joueur[] players;
    private TronPanel tron_panel;

    /**
     * GameManager manages all aspects of the game.
     * @param tron_panel : JComponent containing all classes related to our Game.
     */
    public GameManager(TronPanel tron_panel) {
        this.tron_panel = tron_panel;
        arena = tron_panel.getArena();
        players = tron_panel.getArena().getPlayers();
    }

    /**
     * Creates a new arena with Default settings : < width : 500 > < height : 500 >.
     * Then replaces the main arena.
     */
    public void createNewArena(){
        tron_panel.setArena(new Arene());
        arena = tron_panel.getArena();
        players = tron_panel.getArena().getPlayers();
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
    }

    /**
     * Redraws the current...**COMPLETE THIS**
     */
    public void refresh(){
        tron_panel.repaint();
        arena.repaint();
    }

    // Getters
    public Arene getArena() { return arena; }
    public Joueur[] getPlayers() { return players; }
}
