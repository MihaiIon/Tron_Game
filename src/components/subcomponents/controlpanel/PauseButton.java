package components.subcomponents.controlpanel;

import constant.Game;
import mecanism.GameManager;

import javax.swing.*;

/**
 * Created by Mihai-A on 27/04/2016.
 */
public class PauseButton extends JButton{

    public PauseButton(){

        // JButton
        setText("PAUSE");
        setFocusable(false);
        setBackground(Game.TRON_CONTROL_PANEL_BUTTONS_BACKGROUND_COLOR);

        // OnClick
        addActionListener(
            e -> {

                if(GameManager.getGameState().equals(Game.NULL)){ setText("PAUSE"); }

                else if(GameManager.getGameState().equals(Game.IN_PROGRESS))
                {
                    setText("PLAY");
                    GameManager.pause();
                }

                else if (GameManager.getGameState().equals(Game.PAUSED))
                {
                    setText("PAUSE");
                    GameManager.resume();
                }
            }
        );
    }

}
