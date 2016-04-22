package components.subcomponents;

import components.Arene;
import constant.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mihai-A on 15/04/2016.
 */
public class ArenaContainer extends JPanel{

    // Attributes
    private Arene arena;
    private int borders_width;

    // Constructor
    public ArenaContainer(Arene arena)
    {
        // Set JPanel
        setOpaque(false);
        reCalculateBorders(arena.getHauteur_grille());
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        // Initialize Arena and add it to this container
        this.arena = arena;
        add(arena);
    }

    // Methods
    /**
     * Removes current arena from container
     */
    public void removeArena(){ remove(this.arena); }

    /**
     * **COMPLETE THIS**
     * @param arena_height : **COMPLETE THIS**
     */
    public void calculateBordersWidth(int arena_height)
    {
        borders_width   = (Game.TRON_CONTROL_PANEL_HEIGHT
                        - arena_height)/2;

        if (borders_width < 0) borders_width = 0;
    }

    /**
     * **COMPLETE THIS**
     * @param arena_height : **COMPLETE THIS**
     */
    public void reCalculateBorders(int arena_height)
    {
        calculateBordersWidth(arena_height);
        setBorder(BorderFactory.createMatteBorder(
            borders_width, 0,
            borders_width, 0,
            new Color(0,0,0,220)
        ));
    }

    // Getters
    public Arene getArena() { return arena; }

    // Setters
    public void setArena(Arene new_arena){
        arena = new_arena;
        add(arena);
        reCalculateBorders(arena.getHauteur_grille());
        revalidate();
        repaint();
    }
}
