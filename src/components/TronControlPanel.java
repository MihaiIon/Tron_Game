package components;

import com.sun.deploy.panel.ControlPanel;
import constant.Game;
import jdk.nashorn.internal.scripts.JO;
import mecanism.GameManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;

/**
 * Created by farlyprj on 16-04-06.
 */
public class TronControlPanel extends JPanel {

    private JPanel title_panel;
    private JPanel parametersPane;
    private BorderLayout tron_control_panel_layout;

    public TronControlPanel() {

        //Caracteristique
        setPreferredSize(Game.TRON_CONTROL_PANEL_DIMESIONS);
        setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        setLayout(new BorderLayout());
        tron_control_panel_layout = (BorderLayout)getLayout();

        //Features
        initializeTitlePanel();
        add(title_panel,BorderLayout.NORTH);
        try {
            parametersPane = initializeCenter();
            add(parametersPane,BorderLayout.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
        add(initializeSouth(),BorderLayout.SOUTH);
    }

    /**
     * Initialize the tron Logo
     * @return : **COMPLETE THIS**
     */
    public void initializeTitlePanel()
    {
        JPanel _title_panel = new JPanel();
        _title_panel.setPreferredSize(new Dimension(450,183));
        _title_panel.setBorder(BorderFactory.createMatteBorder(
                50, 0,
                50, 0,
                Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR
        ));
        try
        {
            BufferedImage Player1Control = ImageIO.read(new File("res/tron_Logo.png"));
            JLabel picLabel1 = new JLabel(new ImageIcon(Player1Control.getScaledInstance(290, 83, Image.SCALE_DEFAULT)));
            _title_panel.add(picLabel1);
        }
        catch(IOException e){System.out.println(e);}
        _title_panel. setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);

        title_panel = _title_panel;
    }

    public JPanel initializeCenter() throws IOException
    {
        JPanel _center = new JPanel();
        _center.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        _center.setPreferredSize(new Dimension(225,210));
        _center.setLayout(new FlowLayout());

        //ADD
        _center.add(initializeParameters());
        _center.add(initializeButtons());


        //return
        return _center;
    }
    /*
    * @initializeParameters
     */

    public JPanel initializeParameters()
    {
        JPanel _parameters = new JPanel();
        _parameters.setPreferredSize(new Dimension(450,120));
        _parameters.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);

        /*
        *      @GameType list
         */
        JPanel _gameType_list = new JPanel();
        _gameType_list.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        _gameType_list.setPreferredSize(Game.TRON_PARAMETERS_DIMENSIONS);

        //GAMETYPE

        JLabel _gameTypeTitle = new JLabel("Game Type");
        _gameTypeTitle.setForeground(Color.white);
        _gameTypeTitle.setPreferredSize(Game.TRON_LIST_DIMENSIONS);

        //GameType content
        JComboBox _gameType = new JComboBox(new String[]{
                "Human vs Human","Human vs Computer", "H vs H vs Computer"});
        _gameType.setPreferredSize(new Dimension(200,20));
        _gameType.setBackground(Color.white);
        _gameType.setForeground(Color.lightGray);
        _gameType.setPreferredSize(Game.TRON_LIST_DIMENSIONS);
        
        //Add Gametype
        _gameType_list.add(_gameTypeTitle);
        _gameType_list.add(_gameType);

        /*
        *      @Player Speed list
         */
        JPanel _speed_list = new JPanel();
        _speed_list.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        _speed_list.setPreferredSize(Game.TRON_PARAMETERS_DIMENSIONS);

        //Player Speed
        JLabel _playerSpeedTitle = new JLabel("Players speed");
        _playerSpeedTitle.setForeground(Color.white);
        _playerSpeedTitle.setPreferredSize(Game.TRON_LIST_DIMENSIONS);

        //Player Speed content
        JComboBox _playerSpeed = new JComboBox(new String[]{
                "             1","             2", "             3"});
        _playerSpeed.setPreferredSize(new Dimension(112,20));
        _playerSpeed.setBackground(Color.white);
        _playerSpeed.setForeground(Color.lightGray);
        _playerSpeed.setPreferredSize(Game.TRON_LIST_DIMENSIONS);

        //Speed add
        _speed_list.add(_playerSpeedTitle);
        _speed_list.add(_playerSpeed);
        /*
        *      @Arena list
         */
        JPanel _arena_list = new JPanel();
        _arena_list.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        _arena_list.setPreferredSize(Game.TRON_PARAMETERS_DIMENSIONS);

        //Arena Size text
        JLabel _arenaSizeTitle = new JLabel("Arena Size");
        _arenaSizeTitle.setForeground(Color.white);
        _arenaSizeTitle.setPreferredSize(Game.TRON_LIST_DIMENSIONS);

        //List content
        JComboBox _arenaSize = new JComboBox(new String[]{
                "Small","Medium", "Big"});
        _arenaSize.setPreferredSize(new Dimension(132,20));
        _arenaSize.setBackground(Color.white);
        _arenaSize.setForeground(Color.lightGray);
        _arenaSize.setPreferredSize(Game.TRON_LIST_DIMENSIONS);
        //arena add
        _arena_list.add(_arenaSizeTitle);
        _arena_list.add(_arenaSize);

        //ADD
        _parameters.add(_gameType_list);
        _parameters.add(_arena_list);
        _parameters.add(_speed_list);

        //return
        return _parameters;
    }

    /*
    * @intializeButtons
     */
    public JPanel initializeButtons()
    {
        JPanel _playButtons = new JPanel();
        _playButtons.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);

        //Start Button
        JPanel _startButton = new JPanel();
        _startButton.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        JButton _start = new JButton("START");
        _start.addActionListener(
                e ->{
                    if(GameManager.getGameState() == null)
                    {
                        _start.setText("Replay");
                        GameManager.start();
                    }
                    else {GameManager.replay(500, 500, true, true);}

                } );
        _start.setBackground(new Color (57,163,157));
        _startButton.add(_start);

        //Play/Pause Button
        JPanel _p_Button = new JPanel();
        JButton _pButton = new JButton("PAUSE");
        _pButton.addActionListener(
                e -> {

                    if(GameManager.getGameState().equals(Game.NULL)){_pButton.setText("PAUSE");}

                    else if(GameManager.getGameState().equals(Game.IN_PROGRESS))
                    {
                        System.out.println("Pause pressed");
                        _pButton.setText("PLAY");
                        GameManager.pause();
                        System.out.println(GameManager.getGameState());
                    }
                    else if (GameManager.getGameState().equals(Game.PAUSED))
                    {
                        System.out.println("Play pressed");
                        _pButton.setText("PAUSE");
                        GameManager.resume();
                        System.out.println(GameManager.getGameState());
                    }
                }
        );
        _pButton.setBackground(new Color (57,163,157));
        _p_Button.add(_pButton);
        _p_Button.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);


        //ADD
        _playButtons.add(_startButton);
        _playButtons.add(_p_Button);
        //Return
        return _playButtons;
    }

    public JPanel initializeSouth()
    {
        JPanel _south = new JPanel();
        _south.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        _south.setPreferredSize(new Dimension(450,30));
        JButton controls = new JButton("");
        controls.addActionListener(
                e ->{
                    tron_control_panel_layout.removeLayoutComponent(tron_control_panel_layout.getLayoutComponent(BorderLayout.CENTER));
                    tron_control_panel_layout.addLayoutComponent(new JButton("YOLO"), BorderLayout.CENTER);
                });

        controls.setText("<HTML><FONT color=\"#39A39D\"><U>Voir les Contrôles</U></FONT></HTML>");
        controls.setHorizontalAlignment(SwingConstants.RIGHT);
        controls.setBorderPainted(false);
        controls.setOpaque(false);
        controls.setBackground(Color.WHITE);
        //ADD
        _south.add(controls);
        return _south;
    }
}