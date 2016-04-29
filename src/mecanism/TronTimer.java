package mecanism;

import com.company.Tron;
import constant.Direction;
import constant.Game;
import players.ComputerPlayer;
import players.Joueur;
import players.attributes.Point;

import java.util.TimerTask;

/**
 * Created by Mihai-A on 12/04/2016.
 */
public class TronTimer extends TimerTask {

    // Constructor
    public TronTimer() {
    }

    /**
     * Each time this method is called, each player ( alive ) advances in their current direction.
     * <p>
     * For collision purpose, a coordinate ( last_point ) is created, containing the current position of
     * the player before it moves forward. Explained below.
     * <p>
     * If only one player remains alive ( GameManager.getPlayersAliveCount() == 1 ), GameManager.endGame() is
     * called with the last player alive ( winner ) and the game ends.
     * <p>
     * A variable _current_player saves the current player in it. This allows to save some computations related
     * to accessing the player each time.
     * <p>
     * <p>
     * ---------COLLISION SYSTEM----------- *
     * <p>
     * Two Checks are made
     * <p>
     * 1. Is player in collision with the Arena walls
     * 2. Is player in collision with a path ( including it's self )
     * <p>
     * ...COMPLETE THIS...
     * <p>
     * <p>
     * -----------Computer IA-------------- *
     * <p>
     * ...COMPLETE THIS...
     */
    @Override
    public void run() {

        Point _last_position;
        Joueur _current_player;

        for (int i = 0; i < GameManager.getPlayers().length; i++) {

            // Saves current player for easy access
            _current_player = GameManager.getPlayers()[i];

            if (_current_player.isAlive()) {
                if (GameManager.getPlayersAliveCount() == 1) GameManager.endGame(_current_player);
                else {
                    // Save current position
                    _last_position = new Point(
                            _current_player.getCurrentPosition().getX(),
                            _current_player.getCurrentPosition().getY()
                    );

                    // Computer IA
                    if (_current_player instanceof ComputerPlayer) {

                        Point _target_position =  new Point(
                                _current_player.getCurrentPosition().getX(),
                                _current_player.getCurrentPosition().getY()
                        );

                        switch (_current_player.getDirection()){

                            case Direction.DOWN:
                                _target_position.setY(_target_position.getY()+5);
                                break;
                            case Direction.UP:
                                _target_position.setY(_target_position.getY()-5);
                                break;
                            case Direction.LEFT:
                                _target_position.setX(_target_position.getX()-5);
                                break;
                            case Direction.RIGHT:
                                _target_position.setX(_target_position.getX()+5);
                                break;
                            default:
                        }

                        if (collisionPredictor(_target_position, _last_position)) {
                            if (_current_player.getDirection().equals(Direction.DOWN) || _current_player.getDirection().equals(Direction.UP))
                                _current_player.setDirection(Math.random() < 0.5? Direction.LEFT: Direction.RIGHT);

                            else if (_current_player.getDirection().equals(Direction.LEFT) || _current_player.getDirection().equals(Direction.RIGHT))
                                _current_player.setDirection(Math.random() < 0.5? Direction.UP: Direction.DOWN);

                        }

                    }

                    // Player advances
                    _current_player.getTrace().allonge(_current_player.getDirection());


                    // Collision checks
                    if (isPlayerInCollision(GameManager.getPlayers()[i], _last_position)) {
                        GameManager.getPlayers()[i].kill();
                        GameManager.getPlayersBoard().getPlayerInfos(i).setStatus(Game.PLAYER_STATUS_DEAD);
                    }
                }
            }
        }

        refreshArena();  // Refresh Arena


        // ***** FOR DEBUG PURPOSE **************************************************
        if (Tron.GM.isConsoleInfoON() && GameManager.getPlayers()[0].isAlive()) {
            System.out.println();
            GameManager.getPlayers()[0].print();
        }
        // ***** FOR DEBUG PURPOSE **************************************************
    }

    /**
     * Checks if the player is in collision with a wall or another player's path ( or it's self ).
     *
     * @param player : Current player.
     * @return : If player is in collision, return true;
     */
    private boolean isPlayerInCollision(Joueur player, Point last_position) {
        return Tron.GM.getArena().isPlayerInCollisionWithArenaWalls(player.getCurrentPosition()) ||
                Tron.GM.getArena().isPlayerInCollisionWithPath(player.getCurrentPosition(), last_position);
    }

    private boolean collisionPredictor(Point target_position, Point current_position)
    {
        return Tron.GM.getArena().isPlayerInCollisionWithArenaWalls(target_position) ||
                Tron.GM.getArena().isPlayerInCollisionWithPath(target_position, current_position);
    }

    /**
     * Redraws the current arena...**COMPLETE THIS**
     */
    private void refreshArena(){
        //tron_panel.revalidate();
        //tron_panel.repaint();
        Tron.GM.getArena().repaint();
    }
}
