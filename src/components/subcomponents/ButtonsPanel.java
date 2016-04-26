package components.subcomponents;

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

    private int buttons_width;
    private int buttons_height;
    private JButton _pauseButton;
    private JButton _startButton;
    private Object[] selected_Array = new Object[4];

    public ButtonsPanel() {
        this.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        this.setPreferredSize(new Dimension(Game.TRON_CONTROL_PANEL_WIDTH, 50));
        this.add(initialize_StartButton());
        this.add(initialize_PauseButton());
    }

    public JPanel initialize_PauseButton()
    {
        // Play/Pause Button
        JPanel _pauseButton_Panel = new JPanel();
        _pauseButton = new JButton("PAUSE");
        _pauseButton.setFocusable(false);
        _pauseButton.addActionListener(
                e -> {

                    if(GameManager.getGameState().equals(Game.NULL)){ _pauseButton.setText("PAUSE"); }

                    else if(GameManager.getGameState().equals(Game.IN_PROGRESS))
                    {
                        System.out.println("Pause pressed");
                        _pauseButton.setText("PLAY");
                        GameManager.pause();
                        System.out.println(GameManager.getGameState());
                    }

                    else if (GameManager.getGameState().equals(Game.PAUSED))
                    {
                        System.out.println("Play pressed");
                        _pauseButton.setText("PAUSE");
                        GameManager.resume();
                        System.out.println(GameManager.getGameState());
                    }
                }
        );
        _pauseButton.setBackground(Game.TRON_CONTROL_PANEL_BUTTONS_BACKGROUND_COLOR);
        _pauseButton_Panel.add(_pauseButton);
        _pauseButton_Panel.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);

        return _pauseButton_Panel;
    }

    public JPanel initialize_StartButton()
    {
        // Start Button
        JPanel _startButton_Panel = new JPanel();
        _startButton_Panel.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        _startButton = new JButton("START");
        _startButton.setFocusable(false);
        _startButton.addActionListener(
                e -> {

                        _startButton.setText("RESET");
                        System.out.println(_startButton.getText());
                        _pauseButton.setText("PAUSE");
                        initializeSelected();
                        //System.out.println((Integer)selected_Array[0]);
                        //System.out.println((Integer)selected_Array[1]);
                        //System.out.println((Boolean)selected_Array[2]);
                        //System.out.println((Boolean)selected_Array[3]);

                       //Puts focus on game to allow player control

/*
                        (TronControlPanel.getControls()).setFocusable(false);
                        (ParametersPanel.get_arenaSize()).setFocusable(false);
                        (ParametersPanel.get_playerSpeed()).setFocusable(false);
                        (ParametersPanel.get_gameType()).setFocusable(false);
*/
                        GameManager.replay(((Integer)selected_Array[0]), ((Integer)selected_Array[1]),(Boolean)selected_Array[2], (Boolean)selected_Array[3]);

                }
        );
        _startButton.setBackground(Game.TRON_CONTROL_PANEL_BUTTONS_BACKGROUND_COLOR);
        _startButton_Panel.add(_startButton);
        return _startButton_Panel;
    }

    public void initializeSelected()
    {
        selected_Array = TronControlPanel.getSelection();

    }


    //GETTERS

    public JButton get_pauseButton() {
        return _pauseButton;
    }

    public JButton get_startButton() {
        return _startButton;
    }

    public int getButtons_width() {
        return buttons_width;
    }

    public int getButtons_height() {
        return buttons_height;
    }
}
