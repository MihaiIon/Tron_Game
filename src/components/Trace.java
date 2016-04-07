package components;

import liste.Liste;
import liste.ListeChainee;
import liste.Noeud;

/**
 * Created by farlyprj on 16-04-06.
 */
public class Trace {

    // Attributs
    private Liste segments;

    // Constructor
    public Trace()
    {
        this.segments = new ListeChainee();
    }

    /**
     *
     * @param direction
     */
    public void allonge(char direction)
    {

    }

    /**
     * Provides the coordinate ( Point ) corresponding to the player's current position
     * @return
     */
    public Point tete()
    {
        return ((Segment)segments.getLast()).getFin();
    }

    /**
     *
     * @param p
     * @return
     */
    /*public boolean contient(Point p)
    {
        boolean isInTrace;
        Noeud currentNode = ((Noeud)segments).premier;
        while(currentNode!=segments.size()){
            isInTrace = ((currentNode.content.debut.x == p.x && currentNode.content.debut.y == p.y)
                    ||(currentNode.content.fin.y == p.y && currentNode.content.fin.x == p.x));

        }

        return isInTrace;
    }*/

    // Getters
    public Liste getSegments() { return segments;  }
}

//((debut.x  <= p.x && p.x <= fin.x) && (debut.y <= p.y && p.y <= fin.y))||((debut.x  >= p.x && p.x <= fin.x) && (debut.y >= p.y && p.y <= fin.y))