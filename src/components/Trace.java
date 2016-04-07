package components;

import liste.Liste;

/**
 * Created by farlyprj on 16-04-06.
 */
public class Trace {

    private Liste segments;

    public Trace(Liste segments) {
        this.segments = segments;
    }


    public void allonge(char direction){}

    /**
     * Retourne la position du joueur.
     * @return
     */
    public Point tete(){
        Point tete = new Point();
        return tete;};

    /**
     *
     * @param p
     * @return
     */

    public boolean contient(Point p){
        boolean isInTrace;
        Noeud currentNode = ((Noeud)segments).premier;
        while(currentNode!=segments.size()){
            isInTrace = ((currentNode.content.debut.x == p.x && currentNode.content.debut.y == p.y)
                    ||(currentNode.content.fin.y == p.y && currentNode.content.fin.x == p.x));

        }

        return isInTrace;}
}

//((debut.x  <= p.x && p.x <= fin.x) && (debut.y <= p.y && p.y <= fin.y))||((debut.x  >= p.x && p.x <= fin.x) && (debut.y >= p.y && p.y <= fin.y))