package components.subcomponents.controlpanel;

import constant.Game;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Mihai-A on 19/04/2016.
 */
public class OptionsPanel extends JPanel {

    //*****************************
    //NOTE: DONT KNOW WHY THE GETS IN TRONCONTROLPANEL ARE NOT WORKING
    //SO THE ELEMENTS HERE WILL BE STATIC UNTIL SOLUTION IS FOUND
    //**********************

    //*****************************
    //
    //  OK - fixed
    //
    //**********************

    private JComboBox arena_size;
    private JComboBox game_type;
    private JTextField player_speed;

    public OptionsPanel()
    {
        // JPanel properties
        setLayout(new BorderLayout(0, 0));
        setOpaque(false);

        // Add columns
        add(initializeLabelsColumn(), BorderLayout.WEST);
        add(initializeJComboBoxsColumn(), BorderLayout.EAST);
    }

    /**
     * **COMPLETE THIS**
     * @return : **COMPLETE THIS**
     */
    private JPanel initializeJComboBoxsColumn()
    {
        // JPanel properties
        JPanel _boxes_col = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 2));
        _boxes_col.setPreferredSize(Game.TRON_JCOMPONENTS_CONTAINER_DIMENSIONS);
        _boxes_col.setOpaque(false);


        // ***********************************************************************
        // JComponents...


        // Game Type JComboBox
        game_type = new JComboBox(new String[]{ "Human vs Human","Human vs Computer", "H vs H vs Computer" });
        game_type.setFocusable(false);
        game_type.setBackground(Color.white);
        game_type.setForeground(Game.TRON_OPTIONS_BOXES_TEXT_COLOR);
        game_type.setPreferredSize(Game.TRON_OPTIONS_DIMENSIONS);

        JPanel _game_type_contaier = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        _game_type_contaier.setOpaque(false);
        _game_type_contaier.add(game_type);
        _game_type_contaier.setPreferredSize(Game.TRON_JCOMBOBOXES_CONTAINER_DIMENSIONS);


        // Arena Size JComboBox
        arena_size = new JComboBox(new String[]{ "Small","Medium  [Default(500x500)]", "Large"} );
        arena_size.setSelectedIndex(1);
        arena_size.setFocusable(false);
        arena_size.setBackground(Color.white);
        arena_size.setForeground(Game.TRON_OPTIONS_BOXES_TEXT_COLOR);
        arena_size.setPreferredSize(Game.TRON_OPTIONS_DIMENSIONS);

        JPanel _arena_size_contaier = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        _arena_size_contaier.setOpaque(false);
        _arena_size_contaier.add(arena_size);
        _arena_size_contaier.setPreferredSize(Game.TRON_JCOMBOBOXES_CONTAINER_DIMENSIONS);


        // Players Speed
        player_speed = new JTextField("Enter numbers between [1-10]");
        player_speed.setBackground(Color.white);
        player_speed.setForeground(Game.TRON_OPTIONS_BOXES_TEXT_COLOR);
        player_speed.setPreferredSize(Game.TRON_OPTIONS_DIMENSIONS);

        JPanel _players_speed_contaier = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        _players_speed_contaier.setOpaque(false);
        _players_speed_contaier.add(player_speed);
        _players_speed_contaier.setPreferredSize(Game.TRON_JCOMBOBOXES_CONTAINER_DIMENSIONS);


        // ..End labels
        // ************************************************************************

        _boxes_col.add(_game_type_contaier);
        _boxes_col.add(_arena_size_contaier);
        _boxes_col.add(_players_speed_contaier);

        return _boxes_col;
    }

    /**
     * **COMPLETE THIS**
     * @return : **COMPLETE THIS**
     */
    private JPanel initializeLabelsColumn()
    {
        // JPanel properties
        JPanel _labels_col = new JPanel(new FlowLayout(FlowLayout.LEFT));
        _labels_col.setPreferredSize(Game.TRON_JLABELS_CONTAINER_DIMENSIONS);
        _labels_col.setOpaque(false);


        // ***********************************************************************
        // Labels...


        int _bottom_border = 15;

        // Game Type
        JLabel _label_type = new JLabel("Game Type");
        _label_type.setForeground(Game.TRON_OPTIONS_LABELS_COLOR);
        _label_type.setFont(new Font(_label_type.getName(), Font.PLAIN, 17));
        _label_type.setBorder(BorderFactory.createEmptyBorder(0,0,_bottom_border,0));


        // Arena Size
        JLabel _label_arena = new JLabel("Arena Size");
        _label_arena.setForeground(Game.TRON_OPTIONS_LABELS_COLOR);
        _label_arena.setFont(new Font(_label_arena.getName(), Font.PLAIN, 17));
        _label_arena.setBorder(BorderFactory.createEmptyBorder(0,0,_bottom_border,0));


        // Players Speed
        JLabel _label_speed = new JLabel("Players Speed");
        _label_speed.setForeground(Game.TRON_OPTIONS_LABELS_COLOR);
        _label_speed.setFont(new Font(_label_speed.getName(), Font.PLAIN, 17));


        // ..End labels
        // ************************************************************************


        // Add all
        _labels_col.add(_label_type);
        _labels_col.add(_label_arena);
        _labels_col.add(_label_speed);

        return _labels_col;
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
