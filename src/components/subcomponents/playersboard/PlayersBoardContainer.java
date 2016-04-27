package components.subcomponents.playersboard;

import constant.Game;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PlayersBoardContainer extends JPanel {

    // Attributes
    private PlayersBoard players_board;

    public PlayersBoardContainer() {

        // JPanel
        setPreferredSize(new Dimension(
            Game.PLAYERS_BOARD_CONTAINER_WIDTH,
            Game.PLAYERS_BOARD_CONTAINER_HEIGHT
        ));
        setBorder(new TitledBorder(new LineBorder(new Color(150, 150, 150)), "Players", 1, 2, new Font(null), Color.white));
        setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);

        // Players Board
        players_board = new PlayersBoard();
        add(players_board);
    }

    //public void initialize

    // Getters
    public PlayersBoard getPlayersBoard() { return players_board; }
}
