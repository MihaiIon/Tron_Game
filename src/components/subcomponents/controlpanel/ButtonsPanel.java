package components.subcomponents.controlpanel;

import components.Arene;
import components.TronControlPanel;
import constant.Game;
import mecanism.GameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Jeffery on 2016-04-24.
 */
public class ButtonsPanel extends JPanel{

    private PauseButton pause_button;
    private StartButton start_button;

    public ButtonsPanel() {

        // JPanel settings
        setBorder(BorderFactory.createEmptyBorder(50,0,50,0));
        setOpaque(false);

        // JComponents
        pause_button = new PauseButton();
        start_button = new StartButton(pause_button);
        JPanel _space_panel = new JPanel();
        _space_panel.setPreferredSize(new Dimension(10, 20));
        _space_panel.setOpaque(false);


        // Add all
        add(start_button);
        add(_space_panel);
        add(pause_button);
    }

    // Getters
    public PauseButton getPause() { return pause_button; }
    public StartButton getStart() { return start_button; }
}
