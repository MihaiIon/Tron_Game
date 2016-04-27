package components.subcomponents.controlpanel;

import constant.Game;
import mecanism.GameManager;

import javax.swing.*;

/**
 * Created by Mihai-A on 27/04/2016.
 */
public class StartButton extends JButton {

    private JButton pause_button;

    public StartButton(JButton pause_btn){

        // JButton
        setText("START");
        setFocusable(false);
        setBackground(Game.TRON_CONTROL_PANEL_BUTTONS_BACKGROUND_COLOR);

        // Attributes
        pause_button = pause_btn;

        // OnClick
        addActionListener(
            e -> {

                setText("RESET");
                pause_button.setText("PAUSE");
                /*  System.out.println((Integer)selected_Array[0]);
                    System.out.println((Integer)selected_Array[1]);
                    System.out.println((Boolean)selected_Array[2]);
                    System.out.println((Boolean)selected_Array[3]);

                    Puts focus on game to allow player control


                    (TronControlPanel.getControls()).setFocusable(false);
                    (ParametersPanel.get_arenaSize()).setFocusable(false);
                    (ParametersPanel.get_playerSpeed()).setFocusable(false);
                    (ParametersPanel.get_gameType()).setFocusable(false); */

                GameManager.replay();
            }
        );
    }
}
