package components;

import constant.Direction;
import liste.Liste;
import liste.ListeChainee;
import liste.Noeud;

/**
 * Created by farlyprj on 16-04-06.
 */
public class Trace {

    // Attributs
    private Liste segments;
    private String current_direction;

    // Constructor
    public Trace()
    {
        this.segments = new ListeChainee();
    }

    /**
     * Stretches the current segment in the received direction. If the current_direction is different then
     * the direction passed in parameter, a new segment is created : starting at the same coordinates ( +direction )
     * then the ending coordinates of last segment.
     * @param direction
     */
    public void allonge(String direction)
    {
        Point head = tete();
        if (!current_direction.equals(direction)){
            segments.append(
                    new Segment(
                        new Point(head.getX(),head.getY()),
                        new Point(head.getX(),head.getY())
                ));
            head = tete();
        }

        switch(direction){
            case Direction.UP:
                head.setY(head.getY()+1);
                break;
            case Direction.RIGHT:
                head.setX(head.getX()+1);
                break;
            case Direction.DOWN:
                head.setY(head.getY()-1);
                break;
            case Direction.LEFT:
            default:
                head.setX(head.getX()-1);
        }
    }

    /**
     * Provides the coordinate ( Point ) corresponding to the player's current position.
     * @return
     */
    private Point tete() { return ((Segment)((Noeud)segments.getLast()).content).getFin(); }

    /**
     *
     * @param p
     * @return
     */
    public boolean contient(Point p)
    {
        Segment segment;
        for (int i=0; i<segments.size();i++){
            segment = (Segment)((Noeud)segments.get(i)).content;
            if (segment.getDebut().getX() == segment.getFin().getX()){  // ... if segment is vertical
                if (p.getX() == segment.getDebut().getX() && (
                        p.getY() <= Math.max(segment.getDebut().getY(), segment.getFin().getY()) &&
                        p.getY() >= Math.min(segment.getDebut().getY(), segment.getFin().getY())
                        )) return true;

                else continue;
            }
            else{                                                       // ... if segment is horizontal
                if (p.getY() == segment.getDebut().getY() && (
                        p.getX() <= Math.max(segment.getDebut().getX(), segment.getFin().getX()) &&
                        p.getY() >= Math.min(segment.getDebut().getX(), segment.getFin().getX())
                )) return true;

                else continue;
            }
        }

        return false;
    }

    // Getters
    public Liste getSegments() { return segments;  }
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
