package players.controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Mihai-A on 08/04/2016.
 */
public class Controls implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                System.out.println("Player_1 : Up");
                break;
            case KeyEvent.VK_D:
                System.out.println("Player_1 : RIGHT");
                break;
            case KeyEvent.VK_S:
                System.out.println("Player_1 : DOWN");
                break;
            case KeyEvent.VK_A:
                System.out.println("Player_1 : LEFT");
                break;
            case KeyEvent.VK_UP:
                System.out.println("Player_2 : Up");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Player_2 : RIGHT");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Player_2 : DOWN");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Player_2 : LEFT");
                break;
            default:
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
