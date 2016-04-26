package components.subcomponents;

import constant.Game;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Mihai-A on 19/04/2016.
 */
public class ParametersPanel extends JPanel {

    //*****************************
    //NOTE: DONT KNOW WHY THE GETS IN TRONCONTROLPANEL IS NOT WORKING
    //SO THE ELEMTS HERE WILL BE STATIC UNTIL SOLUTION IS FOUND
    //**********************
    private static JComboBox _arenaSize;
    private static JComboBox _gameType;
    private static JComboBox _playerSpeed;

    public ParametersPanel() {

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
        _gameType = new JComboBox(new String[]{
                "Human vs Human","Human vs Computer", "H vs H vs Computer"});
        _gameType.setPreferredSize(new Dimension(200,20));
        _gameType.setBackground(Color.white);
        _gameType.setForeground(Game.TRON_PARAMETERS_TEXT_COLOR);
        _gameType.setPreferredSize(Game.TRON_LIST_DIMENSIONS);
        _gameType.setFocusable(false);

        // Add Gametype
        _gameType_list.add(_gameTypeTitle);
        _gameType_list.add(_gameType);

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
        _playerSpeed = new JComboBox(new String[]{
                "             1","             2", "             3"});
        _playerSpeed.setPreferredSize(new Dimension(112,20));
        _playerSpeed.setBackground(Color.white);
        _playerSpeed.setForeground(Game.TRON_PARAMETERS_TEXT_COLOR);
        _playerSpeed.setPreferredSize(Game.TRON_LIST_DIMENSIONS);
        _playerSpeed.setFocusable(false);

        // Speed add
        _speed_list.add(_playerSpeedTitle);
        _speed_list.add(_playerSpeed);
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
        _arenaSize = new JComboBox(new String[]{
                "Small","Medium", "Big"});
        _arenaSize.setPreferredSize(new Dimension(132,20));
        _arenaSize.setBackground(Color.white);
        _arenaSize.setForeground(Game.TRON_PARAMETERS_TEXT_COLOR);
        _arenaSize.setPreferredSize(Game.TRON_LIST_DIMENSIONS);
        _arenaSize.setFocusable(false);
        // arena add
        _arena_list.add(_arenaSizeTitle);
        _arena_list.add(_arenaSize);

        // ADD
        add(_gameType_list);
        add(_arena_list);
        add(_speed_list);


    }

    //Getters

    public static JComboBox get_arenaSize() {
        return _arenaSize;
    }

    public static JComboBox get_gameType() {
        return _gameType;
    }

    public static JComboBox get_playerSpeed() {
        return _playerSpeed;
    }

}
