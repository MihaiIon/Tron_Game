package mecanism;

import components.Arene;
import components.TronPanel;
import players.Joueur;
import players.attributes.Point;

import java.util.TimerTask;

/**
 * Created by Mihai-A on 12/04/2016.
 */
public class TronTimer extends TimerTask {

    private Arene arena;
    private Joueur[] players;
    private TronPanel tron_panel;
    private boolean console_info;
    private Point last_position;

    // Constructor
    public TronTimer(TronPanel tron_panel) {
        this.tron_panel = tron_panel;
        arena = tron_panel.getArena();
        players = tron_panel.getArena().getPlayers();
    }

    @Override
    public void run() {
        for (Joueur player : players){
            if (player.isAlive()) {

                last_position = new Point(
                    player.getCurrentPosition().getX(),
                    player.getCurrentPosition().getY()
                );

                player.getTrace().allonge(player.getDirection());

                if (arena.isNotInArena(player.getCurrentPosition()) ||
                    arena.isPlayerInCollision(player.getCurrentPosition(), last_position))
                        player.kill();

            }
        }

        if (console_info && players[0].isAlive()) {
            System.out.println();
            players[0].print();
        }

        refresh();      // Refresh
    }

    // Methods
    /**
     * If console_info is set to true, informations about players and the arenas will be printed in the console
     * @param state : True/False
     */
    public void setConsoleInfo(boolean state){ console_info = state; }

    /**
     * Redraws the current...**COMPLETE THIS**
     */
    private void refresh(){
        //tron_panel.revalidate();
        //tron_panel.repaint();
        arena.repaint();
    }
}
