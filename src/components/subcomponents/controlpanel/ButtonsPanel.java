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

    private JButton pause_button;
    private JButton start_button;

    public ButtonsPanel() {

        // JPanel settings
        /*setBorder(BorderFactory.createEmptyBorder(
                50,0,0,50
        ));*/

        setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        setPreferredSize(new Dimension(Game.TRON_BUTTONS_DIMENSIONS));

        pause_button = new PauseButton();
        start_button = new StartButton(pause_button);

        add(start_button);
        add(pause_button);
    }

    // Getters
    public JButton getPauseButton() { return pause_button; }
    public JButton getStartButton() { return start_button; }
}
