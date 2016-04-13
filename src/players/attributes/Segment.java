package players.attributes;

/**
 * Created by farlyprj on 16-04-06.
 */

public class Segment {

    // Attributs
    private Point debut;
    private Point fin;

    // Constructor

    /**
     * **COMPLETE THIS**
     * @param starting_point : **COMPLETE THIS**
     */
    public Segment(Point starting_point)
    {
        this.debut = starting_point;
        this.fin = starting_point;
    }

    /**
     * **COMPLETE THIS**
     * @param starting_point : **COMPLETE THIS**
     * @param ending_point : **COMPLETE THIS**
     */
    public Segment(Point starting_point, Point ending_point)
    {
        this.debut = starting_point;
        this.fin = ending_point;
    }

    // Getters
    /**
     * Provides a Point representing the starting Point of the segment. This Point can be modified,
     * but it will not affect the x and y values related to the true starting Point.
     * @return
     */
    public Point getDebut() { return new Point(debut.getX(), debut.getY()); }

    /**
     * Provides the Point ending the segment. Changing the values of x and y will change the original
     * segment ending Point.
     * @return
     */
    public Point getFin()   { return fin; }
}
