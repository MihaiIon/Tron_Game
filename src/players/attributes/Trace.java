package players.attributes;

import constant.Direction;
import constant.Game;
import liste.Liste;
import liste.ListeChainee;

/**
 * Created by farlyprj on 16-04-06.
 */
public class Trace {

    // Attributs
    private Liste segments;
    private String current_direction;
    private int movement_speed;

    // Constructor
    /**
     * Contains the player's path and current direction. Initialized in Joueur.java.
     * @param starting_point : Starting coordinates of the player.
     */
    public Trace(Point starting_point, String current_direction)
    {
        segments = new ListeChainee();
        segments.append(new Segment(starting_point));
        this.current_direction = current_direction;
        this.movement_speed = Game.PLAYERS_DEFAULT_SPEED;
    }

    /**
     * Stretches the current segment in the received direction. If the current_direction is different then
     * the direction passed in parameter, a new segment is created : starting at the same coordinates ( +direction )
     * then the ending coordinates of last segment.
     * @param direction : UP, RIGHT, DOWN, LEFT
     */
    public void allonge(String direction)
    {
        Point _head = tete();

        if (!current_direction.equals(direction)){
            segments.append(
                new Segment( new Point(_head.getX(),_head.getY()))
            );
            _head = tete();
        }

        switch(direction){
            case Direction.UP:
                current_direction = Direction.UP;
                _head.setY(_head.getY()-movement_speed);
                break;
            case Direction.RIGHT:
                current_direction = Direction.RIGHT;
                _head.setX(_head.getX()+movement_speed);
                break;
            case Direction.DOWN:
                current_direction = Direction.DOWN;
                _head.setY(_head.getY()+movement_speed);
                break;
            case Direction.LEFT:
                current_direction = Direction.LEFT;
                _head.setX(_head.getX()-movement_speed);
            default:
        }
    }

    /**
     * Provides the coordinate ( Point ) corresponding to the player's current position.
     * @return : **COMPLETE THIS**
     */
    private Point tete() { return ((Segment)segments.getLast().content).getFin(); }

    /**
     * Checks if the Point p is on a segment by comparing it's coordinates to each segments. If the Point p
     * matches a coordinate on a segments, this means that the player, at the Point p, hit a segment.
     * Therefore, this method returns true.
     * @param p : A coordinate in the Arena.
     * @return : **COMPLETE THIS**
     */
    public boolean contient(Point p, Point last_position)
    {

        Segment _segment;

        for (int i = 0; i < segments.size(); i++) {

            _segment = (Segment) segments.get(i).content;

            // If segment is the current segment, don't proceed. Reason => collision with it's self
            if (p == _segment.getFin()) continue;

            if (_segment.getDebut().getX() == _segment.getFin().getX()) {  // ... if _segment is vertical

                if (isTargetValueInBetween(p.getX(), _segment.getDebut().getX(), last_position.getX()) &&
                    isTargetValueInBetween(_segment.getDebut().getY(), p.getY(), _segment.getFin().getY())){

                    if((p == ((Segment)segments.getLast().content).getFin())){
                        if (i != segments.size()-2){
                            p.setX(_segment.getDebut().getX());
                            return true;}

                        else return false;

                    }

                    else{
                        p.setX(_segment.getDebut().getX());
                        return true;
                    }
                }

            } else {                                                       // ... else : _segment is horizontal

                if (isTargetValueInBetween(p.getY(), _segment.getDebut().getY(), last_position.getY()) &&
                    isTargetValueInBetween(_segment.getDebut().getX(), p.getX(), _segment.getFin().getX())) {

                    if((p == ((Segment)segments.getLast().content).getFin())){

                        if (i != segments.size()-2){
                            p.setY(_segment.getDebut().getY());
                            return true;
                        }

                        else return false;
                    }

                    else {
                        p.setY(_segment.getDebut().getY());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * **COMPLETE THIS**
     * @param value1 : **COMPLETE THIS**
     * @param target_value : **COMPLETE THIS**
     * @param value2 : **COMPLETE THIS**
     * @return : **COMPLETE THIS**
     */
    private boolean isTargetValueInBetween(int value1, int target_value, int value2 ){
        if (Math.max(value1, value2) >= target_value &&
            Math.min(value1, value2) <= target_value)
                return true;

        else return false;
    }

    // Getters
    public Liste getSegments() { return segments; }
    public String getCurrent_direction() { return current_direction; }
    public int getSpeed() {  return movement_speed; }

    // Setters
    public void setSpeed(int speed) { movement_speed = speed; }
}
