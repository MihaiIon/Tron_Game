package components;

import players.controls.Controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
        setBackground(new Color(0, 0, 0, 0));    // Transparent

        // Initialize to default size and add it to the main_panel center pane
        arena = new Arene();
        add(arena, BorderLayout.CENTER);

        // Add TronControlePanel to Top pane
        control_panel = new TronControlPanel();
        add(control_panel, BorderLayout.NORTH);

        addKeyListener(new Controls());
        setFocusable(true);
    }

    // Getters
    public Arene getArena() { return arena; }
    public TronControlPanel getControlPanel(){ return control_panel; }
}
