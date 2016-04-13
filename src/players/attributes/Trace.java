package players.attributes;

import constant.Direction;
import liste.Liste;
import liste.ListeChainee;

/**
 * Created by farlyprj on 16-04-06.
 */
public class Trace {

    // Attributs
    private Liste segments;
    private String current_direction;
    private int speed;

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
        this.speed = 1;
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
                _head.setY(_head.getY()-speed);
                break;
            case Direction.RIGHT:
                current_direction = Direction.RIGHT;
                _head.setX(_head.getX()+speed);
                break;
            case Direction.DOWN:
                current_direction = Direction.DOWN;
                _head.setY(_head.getY()+speed);
                break;
            case Direction.LEFT:
                current_direction = Direction.LEFT;
                _head.setX(_head.getX()-speed);
            default:

        }
    }

    /**
     * Provides the coordinate ( Point ) corresponding to the player's current position.
     * @return
     */
    private Point tete() { return ((Segment)segments.getLast().content).getFin(); }

    /**
     * Checks if the Point p is on a segment by comparing it's coordinates to each segments. If the Point p
     * matches a coordinate on a segments, this means that the player, at the Point p, hit a segment.
     * Therefore, this method returns true.
     * @param p : A coordinate in the Arena.
     * @return
     */
    public boolean contient(Point p)
    {
        Segment _segment;
        for (int i=0; i<segments.size();i++){
            _segment = (Segment)segments.get(i).content;
            if (_segment.getDebut().getX() == _segment.getFin().getX()){  // ... if _segment is vertical
                if (p.getX() == _segment.getDebut().getX() && (
                        p.getY() <= Math.max(_segment.getDebut().getY(), _segment.getFin().getY()) &&
                        p.getY() >= Math.min(_segment.getDebut().getY(), _segment.getFin().getY())
                        )) return true;

                else continue;
            }
            else{                                                       // ... else : _segment is horizontal
                if (p.getY() == _segment.getDebut().getY() && (
                        p.getX() <= Math.max(_segment.getDebut().getX(), _segment.getFin().getX()) &&
                        p.getY() >= Math.min(_segment.getDebut().getX(), _segment.getFin().getX())
                )) return true;

                else continue;
            }
        }
        return false;
    }

    // Getters
    public Liste getSegments() { return segments; }
    public String getCurrent_direction() { return current_direction; }
    public int getSpeed() {  return speed; }

    // Setters
    public void setSpeed(int speed) { this.speed = speed; }
}

/*
public boolean contient(Point p)
    {
        boolean isInTrace;
        Noeud currentNode = ((Noeud)segments).premier;
        while(currentNode!=segments.size()){
            isInTrace = ((currentNode.content.debut.x == p.x && currentNode.content.debut.y == p.y)
                    ||(currentNode.content.fin.y == p.y && currentNode.content.fin.x == p.x));

        }

        return isInTrace;
    }

    //((debut.x  <= p.x && p.x <= fin.x) && (debut.y <= p.y && p.y <= fin.y))||((debut.x  >= p.x && p.x <= fin.x) && (debut.y >= p.y && p.y <= fin.y))
 */
