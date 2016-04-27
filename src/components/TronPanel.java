package components;

import components.subcomponents.ArenaContainer;
import components.subcomponents.playersboard.PlayersBoard;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mihai-A on 08/04/2016.
 */
public class TronPanel extends JPanel{

    // Attributes
    private Arene arena;
    private ArenaContainer arena_container;
    private TronControlPanel control_panel;

    // Constructor
    public TronPanel() {

        // Initialize main_panel and background
        setBorder(BorderFactory.createLineBorder(Color.black, 10));
        setLayout(new BorderLayout());
        setOpaque(false);    // Transparent

        // Initialize to default size and add it to the main_panel center pane
        arena = new Arene();
        arena_container = new ArenaContainer(arena);
        add(arena_container, BorderLayout.CENTER);

        // Add TronControlePanel to Top pane
        control_panel = new TronControlPanel();
        add(control_panel, BorderLayout.EAST);

        setFocusable(true);
    }

    // Getters
    public Arene getArena() { return arena; }
    public PlayersBoard getPlayersBoard() { return control_panel.getPlayersBoard(); }
    public TronControlPanel getControlPanel(){ return control_panel; }

    // Setters
    /**
     * **COMPLETE THIS**
     * @param new_arena : **COMPLETE THIS**
     */
    public void setArena(Arene new_arena){
        // Remove current arena
        arena_container.removeArena();

        // Set new Arena
        arena_container.setArena(new_arena);
        arena = arena_container.getArena();

        // Adds new arena to Layout
        revalidate();
        repaint();
    }
}
