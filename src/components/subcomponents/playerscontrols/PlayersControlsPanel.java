package components.subcomponents.playerscontrols;

import com.company.Tron;
import constant.Direction;
import constant.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mihai-A on 27/04/2016.
 */
public class PlayersControlsPanel extends JPanel {

    /**
     * Provides a panel with all Keyboard controls in the Game.
     */
    public PlayersControlsPanel()
    {
        // JPanel properties
        ((FlowLayout)getLayout()).setVgap(0);
        setOpaque(false);

        //--------------------------------------------------------------------------------------------

        /*
         *  JLabels
         */

        JLabel _label_player1, _label_player2, _label_general;

        // Player 1
        _label_player1 = new JLabel("Player 1 : Controls", JLabel.CENTER);
        _label_player1.setOpaque(false);
        _label_player1.setForeground(new Color(152, 116, 42));
        _label_player1.setFont(Tron.roboto_thin.deriveFont(35f));
        _label_player1.setPreferredSize(new Dimension(Game.TRON_CONTROL_PANEL_WIDTH, 75));

        // Player 2
        _label_player2 = new JLabel("Player 2 : Controls", JLabel.CENTER);
        _label_player2.setOpaque(false);
        _label_player2.setForeground(new Color(69, 137, 152));
        _label_player2.setFont(Tron.roboto_thin.deriveFont(35f));
        _label_player2.setPreferredSize(new Dimension(Game.TRON_CONTROL_PANEL_WIDTH, 75));

        // General
        _label_general = new JLabel("General Controls", JLabel.CENTER);
        _label_general.setOpaque(false);
        _label_general.setForeground(new Color(152, 70, 95));
        _label_general.setFont(Tron.roboto_thin.deriveFont(35f));
        _label_general.setPreferredSize(new Dimension(Game.TRON_CONTROL_PANEL_WIDTH, 75));




        //--------------------------------------------------------------------------------------------

        /*
         *  Controls
         */

        JPanel _controls_player1, _controls_player2, _controls_general;

        // Player 1
        _controls_player1 = new JPanel();
        _controls_player1.setOpaque(false);
        _controls_player1.add(new Control("W", Direction.UP));
        _controls_player1.add(new Control("D", Direction.RIGHT));
        _controls_player1.add(new Control("S", Direction.DOWN));
        _controls_player1.add(new Control("A", Direction.LEFT));
        _controls_player1.add(new Control("SPACE", "BOOST"));
        _controls_player1.setPreferredSize(new Dimension(Game.TRON_CONTROL_PANEL_WIDTH-20, 140));


        // Player 2
        _controls_player2 = new JPanel();
        _controls_player2.setOpaque(false);
        _controls_player2.add(new Control("up", Direction.UP));
        _controls_player2.add(new Control("right", Direction.RIGHT));
        _controls_player2.add(new Control("down", Direction.DOWN));
        _controls_player2.add(new Control("left", Direction.LEFT));
        _controls_player2.add(new Control("NUM_0", "BOOST"));
        _controls_player2.setPreferredSize(new Dimension(Game.TRON_CONTROL_PANEL_WIDTH-20, 160));



        //--------------------------------------------------------------------------------------------

        /*
         *  Add all
         */

        add(_label_player1);
        add(_controls_player1);
        add(_label_player2);
        add(_controls_player2);
    }
}
