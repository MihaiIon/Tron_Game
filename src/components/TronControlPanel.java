package components;

import jdk.nashorn.internal.scripts.JO;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;

/**
 * Created by farlyprj on 16-04-06.
 */
public class TronControlPanel extends JPanel {

    private static final Color backgroundColor = new Color(14,14,14);
    public TronControlPanel() {

        //Caracteristique
        setPreferredSize(new Dimension(420,500));
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
        JLabel _title = new JLabel("Tron");
        _north.add(_title);
        _north. setBackground(backgroundColor);
        return _north;
    }
    public JPanel initializeEast() throws IOException {
        JPanel _east = new JPanel();
        _east.setBackground(backgroundColor);
        _east.setPreferredSize(new Dimension(210,250));
        //Image 1
        BufferedImage Player1Control = ImageIO.read(new File("res/controls.jpg"));
        JLabel picLabel1 = new JLabel(new ImageIcon(Player1Control.getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
        _east.add(picLabel1);

        //return
        return _east;
    }
    public JPanel initializeWest()
    {
        JPanel _west = new JPanel();
        _west.setBackground(backgroundColor);
        _west.setPreferredSize(new Dimension(210,250));

        //GAMETYPE
        JLabel _gameTypeTitle = new JLabel("Game Type");
        JComboBox _gameType = new JComboBox(new String[]{
                "Human vs Human","Human vs Computer", "H vs H vs Computer"
        });
        _gameType.setBackground(backgroundColor);

        //Player Speed
        JLabel _playerSpeedTitle = new JLabel("Players speed");
        JComboBox _playerSpeed = new JComboBox(new String[]{
                "1","2", "3"
        });
        _playerSpeed.setBackground(backgroundColor);

        //Arena Size
        JLabel _arenaSizeTitle = new JLabel("Arena Size");
        JComboBox _arenaSize = new JComboBox(new String[]{
                "Small","Medium", "Big"
        });
        _arenaSize.setBackground(backgroundColor);

        //ADDS
        _west.add(_gameTypeTitle);
        _west.add(_gameType);
        _west.add(_playerSpeedTitle);
        _west.add(_playerSpeed);
        _west.add(_arenaSizeTitle);
        _west.add(_arenaSize);

        //return
        return _west;

    }
    public JPanel initializeSouth()
    {
        JPanel _south = new JPanel();
        return _south;
    }
}
