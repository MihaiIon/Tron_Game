package players.attributes;

/**
 * Created by farlyprj on 16-04-06.
 */
public class Point {

    // Attributes
    private int x;
    private int y;

    // Constructor
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    // Getters
    public int getX() { return x; }
    public int getY() { return y; }

    // Setters
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public String toString(){
        return "(" + x + "," + y + ")";
    }
}
