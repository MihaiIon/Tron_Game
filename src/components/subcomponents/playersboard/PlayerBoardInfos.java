package components.subcomponents.playersboard;

import constant.Game;
import players.Joueur;

import javax.swing.*;
import java.awt.*;

public class PlayerBoardInfos extends JPanel {

    // Player Attributes
    private Color color;
    private String name;
    private String status;
    private int wins;

    // JComponents
    private JPanel color_cell;
    private JPanel color_container;
    private JLabel name_cell;
    private JLabel status_cell;
    private JPanel boosts_cell;
    private JLabel wins_cell;

    //boosts
    private JPanel boost_1;
    private JPanel boost_2;
    private JPanel boost_3;


    // Constructor
    public PlayerBoardInfos(Color background_color, Color separators_color)
    {
        //
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        ((FlowLayout)getLayout()).setVgap(0);
        setPreferredSize(new Dimension(
            Game.PLAYERS_BOARD_WIDTH,
            30
        ));

        // Initialize cells
        initializeCells(background_color, separators_color);
    }

    /**
     * **COMPLETE THIS**
     * @return : **COMPLETE THIS**
     */
    public static PlayerBoardInfos createTopSection()
    {
        PlayerBoardInfos _top_section =  new PlayerBoardInfos(
            new Color(18, 18, 18),
            new Color(25, 25, 25)
        );

        // Set color_container
        _top_section.color_container.setBackground(Color.WHITE);
        _top_section.color_container.setOpaque(true);
        _top_section.color_container.setBorder(BorderFactory.createLineBorder(
            new Color(18, 18, 18), 8
        ));

        // Set labels

            // Name
            _top_section.name_cell.setText("Name");

            // Status
            _top_section.status_cell.setText("Status");

            // Boosts
            _top_section.boosts_cell.removeAll();
            JLabel _boost_label = new JLabel("Boosts");
            _boost_label.setForeground(Color.WHITE);
            _top_section.boosts_cell.add(_boost_label);

            // Wins
            _top_section.wins_cell.setText("Wins");

        // End - set

        return _top_section;
    }

    // Methods
    /**
     * ** COMPLETE THIS **
     * @param background_color : ** COMPLETE THIS **
     * @param separators_color : ** COMPLETE THIS **
     */
    private void initializeCells(Color background_color, Color separators_color)
    {
        createColorCell(background_color, separators_color);
        createNameCell(background_color, separators_color);
        createStatusCell(background_color, separators_color);
        createBoostsCell(background_color, separators_color);
        createWinsCell(background_color, separators_color);
    }

    /**
     * ** COMPLETE THIS **
     * @param background_color : ** COMPLETE THIS **
     * @param separators_color : ** COMPLETE THIS **
     */
    private void createColorCell(Color background_color, Color separators_color)
    {
        // Color cell
        color_cell = new JPanel();
        ((FlowLayout)color_cell.getLayout()).setHgap(0);
        color_cell.setPreferredSize(new Dimension(30,30));
        color_cell.setBackground(background_color);
        color_cell.setBorder(BorderFactory.createMatteBorder(
            0, 0, 0, 1, separators_color
        ));

        // > color_cell > color_container
        color_container = new JPanel();
        color_container.setOpaque(false);
        color_container.setPreferredSize(new Dimension(20,20));
        color_container.setBorder(BorderFactory.createLineBorder(
            background_color, 2
        ));

        color_cell.add(color_container);
        add(color_cell);
    }

    /**
     * ** COMPLETE THIS **
     * @param background_color : ** COMPLETE THIS **
     * @param separators_color : ** COMPLETE THIS **
     */
    private void createNameCell(Color background_color, Color separators_color)
    {
        JPanel _name_container = new JPanel();
        _name_container.setPreferredSize(new Dimension(140,30));
        _name_container.setBackground(background_color);
        _name_container.setBorder(BorderFactory.createMatteBorder(
            0, 0, 0, 1, separators_color
        ));

        name_cell = new JLabel();
        name_cell.setBorder(BorderFactory.createEmptyBorder(1, 0, 0, 0));
        name_cell.setForeground(Color.white);

        _name_container.add(name_cell);
        add(_name_container);


    }

    /**
     * ** COMPLETE THIS **
     * @param background_color : ** COMPLETE THIS **
     * @param separators_color : ** COMPLETE THIS **
     */
    private void createStatusCell(Color background_color, Color separators_color)
    {
        JPanel _status_container = new JPanel();
        _status_container.setPreferredSize(new Dimension(90,30));
        _status_container.setBackground(background_color);
        _status_container.setBorder(BorderFactory.createMatteBorder(
                0, 0, 0, 1, separators_color
        ));

        status_cell = new JLabel();
        status_cell.setBorder(BorderFactory.createEmptyBorder(1,0,0,0));
        status_cell.setForeground(Color.white);
        _status_container.add(status_cell);
        add(_status_container);
    }

    /**
     * ** COMPLETE THIS **
     * @param background_color : ** COMPLETE THIS **
     * @param separators_color : ** COMPLETE THIS **
     */
    private void createBoostsCell(Color background_color, Color separators_color)
    {
        boosts_cell = new JPanel();
        boosts_cell.setPreferredSize(new Dimension(108,30));
        boosts_cell.setBackground(background_color);
        boosts_cell.setBorder(BorderFactory.createMatteBorder(
                0, 0, 0, 1, separators_color
        ));

        /*
                ADD BOOSTS
         */

        //Boost 1
        boost_1 = new JPanel();
        boost_1.setPreferredSize(new Dimension(20,10));
        boost_1.setOpaque(false);
        boost_1.setBorder(BorderFactory.createLineBorder(
                background_color, 2
        ));

        //Boost 2
        boost_2 = new JPanel();
        boost_2.setPreferredSize(new Dimension(20,10));
        boost_2.setOpaque(false);
        boost_2.setBorder(BorderFactory.createLineBorder(
                background_color, 2
        ));

        //Bosst 3
        boost_3 = new JPanel();
        boost_3.setPreferredSize(new Dimension(20,10));
        boost_3.setOpaque(false);
        boost_3.setBorder(BorderFactory.createLineBorder(
                background_color, 2
        ));

        //ADDS
        boosts_cell.add(boost_1);
        boosts_cell.add(boost_2);
        boosts_cell.add(boost_3);
        add(boosts_cell);
    }

    /**
     * ** COMPLETE THIS **
     * @param background_color : ** COMPLETE THIS **
     * @param separators_color : ** COMPLETE THIS **
     */
    private void createWinsCell(Color background_color, Color separators_color)
    {
        JPanel _wins_container = new JPanel();
        _wins_container.setPreferredSize(new Dimension(60,30));
        _wins_container.setBackground(background_color);
        _wins_container.setBorder(BorderFactory.createMatteBorder(
                0, 0, 0, 1, separators_color
        ));

        wins_cell = new JLabel();
        wins_cell.setBorder(BorderFactory.createEmptyBorder(1,0,0,0));
        wins_cell.setForeground(Color.white);
        _wins_container.add(wins_cell);
        add(_wins_container);
    }

    /**
     *
     */
    public void initializePlayerInfos(){
        // Initialize attributes
        status = Game.PLAYER_STATUS_ALIVE;
        wins = 0;
        wins_cell.setText("0");
    }


    public void addWin(){
        wins++;
        wins_cell.setText(""+wins);
    }

    // Getters
    public Color getColor()         { return color; }
    public String getName()         { return name;  }
    public String getStatus()       { return status;}
    public int getTotalWins()       { return wins;  }

    // Setters
    public void setColor(Color color)
    {
        this.color = color;
        name_cell.setForeground(color);
        color_container.setBackground(color);
        color_container.setOpaque(true);
        boost_1.setBackground(color);
        boost_1.setOpaque(true);
        boost_2.setBackground(color);
        boost_2.setOpaque(true);
        boost_3.setBackground(color);
        boost_3.setOpaque(true);

    }
    public void useBoost(int index)
    {

        switch (index){
            case 0:
                boost_1.setBackground(Game.BOOST_INACTIVE_BACKGROUND_COLOR);
                break;
            case 1:
                boost_2.setBackground(Game.BOOST_INACTIVE_BACKGROUND_COLOR);
                break;
            case 2:
                boost_3.setBackground(Game.BOOST_INACTIVE_BACKGROUND_COLOR);
                break;
        }
    }
    public void resetBoost(Color color)
    {
        boost_1.setBackground(color);
        boost_2.setBackground(color);
        boost_3.setBackground(color);
    }

    public void setName(String name)
    {
        this.name = name;
        name_cell.setText(name);
    }

    public void setStatus(String status)
    {
        this.status = status;
        status_cell.setText(status);
        if (status.equals(Game.PLAYER_STATUS_ALIVE)) status_cell.setForeground(new Color(32, 192, 50));
        else status_cell.setForeground(new Color(255, 44, 47));
    }
}
