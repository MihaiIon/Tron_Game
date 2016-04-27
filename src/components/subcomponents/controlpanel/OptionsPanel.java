package components.subcomponents.controlpanel;

import constant.Game;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Mihai-A on 19/04/2016.
 */
public class OptionsPanel extends JPanel {

    //*****************************
    //NOTE: DONT KNOW WHY THE GETS IN TRONCONTROLPANEL IS NOT WORKING
    //SO THE ELEMTS HERE WILL BE STATIC UNTIL SOLUTION IS FOUND
    //**********************

    //*****************************
    //
    //  OK - fixed
    //
    //**********************

    private JComboBox arena_size;
    private JComboBox game_type;
    private JComboBox player_speed;

    public OptionsPanel() {

        setPreferredSize(new Dimension(450,120));
        setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);

        /*
        *      @GameType list
         */
        JPanel _gameType_list = new JPanel();
        _gameType_list.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        _gameType_list.setPreferredSize(Game.TRON_PARAMETERS_DIMENSIONS);

        // GAMETYPE

        JLabel _gameTypeTitle = new JLabel("Game Type");
        _gameTypeTitle.setForeground(Color.white);
        _gameTypeTitle.setPreferredSize(Game.TRON_LIST_DIMENSIONS);

        // GameType content
        game_type = new JComboBox(new String[]{
                "Human vs Human","Human vs Computer", "H vs H vs Computer"});
        game_type.setPreferredSize(new Dimension(200,20));
        game_type.setBackground(Color.white);
        game_type.setForeground(Game.TRON_PARAMETERS_TEXT_COLOR);
        game_type.setPreferredSize(Game.TRON_LIST_DIMENSIONS);
        game_type.setFocusable(false);

        // Add Gametype
        _gameType_list.add(_gameTypeTitle);
        _gameType_list.add(game_type);

        /*
        *      @Player Speed list
         */
        JPanel _speed_list = new JPanel();
        _speed_list.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        _speed_list.setPreferredSize(Game.TRON_PARAMETERS_DIMENSIONS);

        // Player Speed
        JLabel _playerSpeedTitle = new JLabel("Players speed");
        _playerSpeedTitle.setForeground(Color.white);
        _playerSpeedTitle.setPreferredSize(Game.TRON_LIST_DIMENSIONS);

        // Player Speed content
        player_speed = new JComboBox(new String[]{
                "             1","             2", "             3"});
        player_speed.setPreferredSize(new Dimension(112,20));
        player_speed.setBackground(Color.white);
        player_speed.setForeground(Game.TRON_PARAMETERS_TEXT_COLOR);
        player_speed.setPreferredSize(Game.TRON_LIST_DIMENSIONS);
        player_speed.setFocusable(false);

        // Speed add
        _speed_list.add(_playerSpeedTitle);
        _speed_list.add(player_speed);
        /*
        *      @Arena list
         */
        JPanel _arena_list = new JPanel();
        _arena_list.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        _arena_list.setPreferredSize(Game.TRON_PARAMETERS_DIMENSIONS);

        // Arena Size text
        JLabel _arenaSizeTitle = new JLabel("Arena Size");
        _arenaSizeTitle.setForeground(Color.white);
        _arenaSizeTitle.setPreferredSize(Game.TRON_LIST_DIMENSIONS);

        // List content
        arena_size = new JComboBox(new String[]{
                "Small","Medium", "Big"});
        arena_size.setPreferredSize(new Dimension(132,20));
        arena_size.setBackground(Color.white);
        arena_size.setForeground(Game.TRON_PARAMETERS_TEXT_COLOR);
        arena_size.setPreferredSize(Game.TRON_LIST_DIMENSIONS);
        arena_size.setFocusable(false);
        // arena add
        _arena_list.add(_arenaSizeTitle);
        _arena_list.add(arena_size);

        // ADD
        add(_gameType_list);
        add(_arena_list);
        add(_speed_list);
    }

    /**
     * **COMPLETE THIS**
     * @return : **COMPLETE THIS**
     */
    public Object[] getOptions(){
        return new Object[]{
            getArenaDimensions().width,
            getArenaDimensions().height,
            isPlayer2Playing(),
            isComputerPlaying()
        };
    }

    /**
     * **COMPLETE THIS**
     * @return : **COMPLETE THIS**
     */
    private Dimension getArenaDimensions()
    {
        switch(arena_size.getSelectedIndex())
        {
            case 0: return new Dimension(400, 400);
            case 2: return new Dimension(750, 750);
            default: return new Dimension(500, 500);
        }
    }

    /**
     * Verifies if the selection is on the 1st or 3rd postion and returns the value found
     * @return : **COMPLETE THIS**
     */
    private Object isPlayer2Playing()
    {
        return (game_type.getSelectedIndex() == 0 || game_type.getSelectedIndex() == 2);
    }

    /**
     * Verifies if the selection is on the 1st or 3rd postion and returns the value found
     * @return : **COMPLETE THIS**
     */
    private Object isComputerPlaying()
    {
        return (game_type.getSelectedIndex() == 1 || game_type.getSelectedIndex() == 2);
    }

}
