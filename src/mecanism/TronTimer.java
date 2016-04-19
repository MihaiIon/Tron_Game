package mecanism;

import com.company.Tron;
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
        for (Joueur player : GameManager.getPlayers()){
            if (player.isAlive()) {

                if (GameManager.getPlayersAliveCount() == 1) GameManager.endGame(player);

                last_position = new Point(
                    player.getCurrentPosition().getX(),
                    player.getCurrentPosition().getY()
                );

                player.getTrace().allonge(player.getDirection());

                if (Tron.GM.getArena().isPlayerInCollisionWithArenaWalls(player.getCurrentPosition()) ||
                    Tron.GM.getArena().isPlayerInCollisionWithPath(player.getCurrentPosition(), last_position))
                        player.kill();
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
