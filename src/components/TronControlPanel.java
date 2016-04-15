package components;

import jdk.nashorn.internal.scripts.JO;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;

/**
 * Created by farlyprj on 16-04-06.
 */
public class TronControlPanel extends JPanel {

    private static final Color backgroundColor = new Color(15,15,15);
    public TronControlPanel() {

        //Caracteristique
        setPreferredSize(new Dimension(450,500));
        setBackground(backgroundColor);
        setLayout(new BorderLayout());

        //Features
        add(initializeNorth(),BorderLayout.NORTH);
        try {
            add(initializeEast(),BorderLayout.EAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
        add(initializeWest(),BorderLayout.WEST);
        add(initializeSouth(),BorderLayout.SOUTH);
    }
    public JPanel initializeNorth()
    {
        JPanel _north = new JPanel();
        _north.setPreferredSize(new Dimension(450,120));
        JLabel _title = new JLabel("Tron");
        _north.add(_title);
        _north. setBackground(backgroundColor);
        return _north;
    }
    public JPanel initializeEast() throws IOException {
        JPanel _east = new JPanel();
        _east.setBackground(backgroundColor);
        _east.setPreferredSize(new Dimension(225,210));
        //Image 1
        BufferedImage Player1Control = ImageIO.read(new File("res/controls.png"));
        JLabel picLabel1 = new JLabel(new ImageIcon(Player1Control.getScaledInstance(210, 195, Image.SCALE_DEFAULT)));
        _east.add(picLabel1);

        //return
        return _east;
    }
    public JPanel initializeWest()
    {
        JPanel _west = new JPanel();
        _west.setBackground(backgroundColor);
        _west.setPreferredSize(new Dimension(225,210));

        //GAMETYPE
        JLabel _gameTypeTitle = new JLabel("Game Type");
        _gameTypeTitle.setForeground(Color.white);
        JComboBox _gameType = new JComboBox(new String[]{
                "Human vs Human","Human vs Computer", "H vs H vs Computer"
        });
        _gameType.setPreferredSize(new Dimension(200,20));
        _gameType.setBackground(Color.white);

        //Player Speed
        JLabel _playerSpeedTitle = new JLabel("Players speed");
        _playerSpeedTitle.setForeground(Color.white);
        JComboBox _playerSpeed = new JComboBox(new String[]{
                "             1","             2", "             3"
        });
        _playerSpeed.setPreferredSize(new Dimension(112,20));
        _playerSpeed.setBackground(Color.white);

        //Arena Size
        JLabel _arenaSizeTitle = new JLabel("Arena Size");
        _arenaSizeTitle.setForeground(Color.white);
        JComboBox _arenaSize = new JComboBox(new String[]{
                "Small","Medium", "Big"
        });
        _arenaSize.setPreferredSize(new Dimension(132,20));
        _arenaSize.setBackground(Color.white);

/*
        //Start button
        JButton _start =  new JButton("START");
        _start.setBackground(new Color(57,163,157));
        _start.setPreferredSize(new Dimension(220,50));
        _start.setForeground(Color.white);
*/
        //ADDS
        _west.add(_gameTypeTitle);
        _west.add(_gameType);
        _west.add(_playerSpeedTitle);
        _west.add(_playerSpeed);
        _west.add(_arenaSizeTitle);
        _west.add(_arenaSize);
        //_west.add(_start);

        //return
        return _west;

    }
    public JPanel initializeSouth()
    {
        JPanel _south = new JPanel();
        _south.setBackground(backgroundColor);
        _south.setPreferredSize(new Dimension(450,170));
        return _south;
    }
}
