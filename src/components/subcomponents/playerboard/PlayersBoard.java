package components.subcomponents.playerboard;

import constant.Game;
import players.HumanPlayer;
import players.Joueur;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Mihai-A on 21/04/2016.
 */
public class PlayersBoard extends JPanel {

    private PlayerBoardInfos[] players_infos;

    // Contructor
    /**
     * Sets up the players_board. The players_board contains all the informations related to each players : name,
     * color, status, boost remainers, total wins.
     */
    public PlayersBoard()
    {
        // JPanel
        ((FlowLayout)getLayout()).setVgap(0);
        setBackground(Color.red);
        setPreferredSize(new Dimension(
            Game.PLAYERS_BOARD_WIDTH,
            Game.PLAYERS_BOARD_HEIGHT
        ));

        initializePlayers(new Joueur[4]);
    }

    // Methods
    /**
     * Initialize players infos cells in the player_board.
     * @param players : current players
     */
    public void initializePlayers(Joueur[] players)
    {
        removeAll();
        players_infos = new PlayerBoardInfos[4];
        int _players_counter = 0;
        int _computer_counter = 0;

        // Create the top section
        players_infos[0] = PlayerBoardInfos.createTopSection();
        add(players_infos[0]);

        // Create remaining rows : player or empty
        for (int i=1; i<4; i++){

            if (i%2 == 0) players_infos[i] = new PlayerBoardInfos(
                new Color(22, 22, 22),
                new Color(18, 18, 18)
            );

            else players_infos[i] = new PlayerBoardInfos(
                new Color(30, 30, 30),
                new Color(18, 18, 18)
            );

            if (i-1 < players.length && players[0] != null) {
                players_infos[i].initializePlayerInfos();
                players_infos[i].setName(
                    players[i-1] instanceof HumanPlayer
                        ? "HUMAN[" + ++_players_counter + "]"
                        : "COMPUTER[" + ++_computer_counter + "]"
                );
                players_infos[i].setColor(players[i-1].getColor());
                players_infos[i].setStatus(Game.PLAYER_STATUS_ALIVE);
            }

            add(players_infos[i]);
        }
    }

    /**
     *
     */
    public void resetStatus()
    {
        for (int i=1; i<players_infos.length; i++){
            if (players_infos[i].getStatus() != null)
                players_infos[i].setStatus(Game.PLAYER_STATUS_ALIVE);
        }
    }

    // Getters
    public PlayerBoardInfos getPlayerInfos(int i) { return players_infos[i+1]; }
}
