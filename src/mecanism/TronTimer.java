package mecanism;

import com.company.Tron;
import constant.Game;
import players.Joueur;
import players.attributes.Point;

import java.util.TimerTask;

/**
 * Created by Mihai-A on 12/04/2016.
 */
public class TronTimer extends TimerTask {

    private Point last_position;

    // Constructor
    public TronTimer(){}

    @Override
    public void run() {
        for (int i=0; i<GameManager.getPlayers().length; i++){
            if (GameManager.getPlayers()[i].isAlive()) {

                if (GameManager.getPlayersAliveCount() == 1) GameManager.endGame(GameManager.getPlayers()[i]);

                last_position = new Point(
                    GameManager.getPlayers()[i].getCurrentPosition().getX(),
                    GameManager.getPlayers()[i].getCurrentPosition().getY()
                );

                GameManager.getPlayers()[i].getTrace().allonge(GameManager.getPlayers()[i].getDirection());

                if (Tron.GM.getArena().isPlayerInCollisionWithArenaWalls(GameManager.getPlayers()[i].getCurrentPosition()) ||
                    Tron.GM.getArena().isPlayerInCollisionWithPath(GameManager.getPlayers()[i].getCurrentPosition(), last_position))
                {
                    GameManager.getPlayers()[i].kill();
                    GameManager.getPlayersBoard().getPlayerInfos(i).setStatus(Game.PLAYER_STATUS_DEAD);
                }
            }
        }

        if (Tron.GM.isConsoleInfoON() && GameManager.getPlayers()[0].isAlive()) {
            System.out.println();
            GameManager.getPlayers()[0].print();
        }

        refresh();      // Refresh Arena
    }

    // Methods
    /**
     * Redraws the current...**COMPLETE THIS**
     */
    private void refresh(){
        //tron_panel.revalidate();
        //tron_panel.repaint();
        Tron.GM.getArena().repaint();
    }
}
