package components;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mihai-A on 08/04/2016.
 */
public class TronPanel extends JPanel{

    // Attributes
    private Arene arena;
    private TronControlPanel control_panel;

    // Constructor
    public TronPanel() {

        // Initialize main_panel and background
        setLayout(new BorderLayout());
        setOpaque(false);               // Transparent

        // Initialize to default size and add it to the main_panel center pane
        arena = new Arene();
        add(arena, BorderLayout.CENTER);

        // Add TronControlePanel to Top pane
        control_panel = new TronControlPanel();
        add(control_panel, BorderLayout.EAST);

        setFocusable(true);
    }

    // Getters
    public Arene getArena() { return arena; }
    public TronControlPanel getControlPanel(){ return control_panel; }

    // Setters
    /**
     * **COMPLETE THIS**
     * @param newArena : **COMPLETE THIS**
     */
    public void setArena(Arene newArena){

        remove(arena);      // Remove current arena
        arena = newArena;   // **COMPLETE THIS**

        // Adds new arena to Layout
        add(arena, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}
