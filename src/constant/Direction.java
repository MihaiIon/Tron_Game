package constant;

/**
 * Created by Mihai-A on 06/04/2016.
 */
public class Direction {

    /*
     * Players possible directions
     */
    public static final String UP = "UP";
    public static final String RIGHT = "RIGHT";
    public static final String DOWN = "DOWN";
    public static final String LEFT = "LEFT";

    public static boolean isOpposite(String current_direction, String opposite_direction){

        switch(current_direction){
            case UP:
                return opposite_direction.equals(DOWN);
            case RIGHT:
                return opposite_direction.equals(LEFT);
            case DOWN:
                return opposite_direction.equals(UP);
            case LEFT:
                return opposite_direction.equals(RIGHT);
            default:
                return false;
        }
    }

}
