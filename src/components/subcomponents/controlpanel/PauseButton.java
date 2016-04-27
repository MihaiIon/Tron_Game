package components.subcomponents.controlpanel;

import constant.Game;
import mecanism.GameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

/**
 * Created by Mihai-A on 27/04/2016.
 */
public class PauseButton extends JButton{

    private boolean activated;
    private boolean paused;

    // Constructor
    public PauseButton(){

        // JButton
        setFocusable(false);
        setPreferredSize(new Dimension(56, 50));
        setBackground(Game.PAUSE_BTN_INACTIVE_BACKGROUND_COLOR);
        activated = false;
        paused = false;

        // OnClick
        addActionListener(
            e -> {

                if(GameManager.getGameState().equals(Game.IN_PROGRESS))
                {
                    pause(true);
                    GameManager.pause();
                }

                else if (GameManager.getGameState().equals(Game.PAUSED))
                {
                    pause(false);
                    GameManager.resume();
                }
            }
        );
    }

    /**
     * Draws the pause and play shapes.
     * @param g : **COMPLETE THIS**
     */
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw
        if(paused)
        {
            // Outer shape
            g2.setColor(Game.PAUSE_BTN_PAUSED_FORGROUND_COLOR_1);
            GeneralPath _shape = createPlayShape(14,10);
            g2.fill(_shape);

            // Inner Shape
            g2.setColor(Game.PAUSE_BTN_PAUSED_FORGROUND_COLOR_2);
            _shape = createPlayShape(16,14);
            g2.fill(_shape);
        }

        else
        {
            if(activated) g2.setColor(Game.PAUSE_BTN_DEFAULT_FORGROUND_COLOR);
            else g2.setColor(Game.PAUSE_BTN_INACTIVE_FORGROUND_COLOR);

            // Draw pause symbol
            g2.fillRect(16, 12, 8, 26);
            g2.fillRect(32, 12, 8, 26);
        }
    }

    /**
     * **COMPLETE THIS**
     * @param x : **COMPLETE THIS**
     * @param y : **COMPLETE THIS**
     * @return : **COMPLETE THIS**
     */
    private GeneralPath createPlayShape(int x, int y){

        int _x1 = x;
        int _x2 = getWidth()-_x1;
        int _y1 = y;
        int _y2 = getHeight()-_y1;

        GeneralPath _ps = new GeneralPath();
        _ps.moveTo(_x1, _y1);
        _ps.lineTo(_x2, getHeight()/2);
        _ps.lineTo(_x1, _y2);
        _ps.lineTo(_x1, _y1);
        _ps.closePath();

        return _ps;
    }

    // Setters
    public void activate()
    {
        setBackground(Game.PAUSE_BTN_DEFAULT_BACKGROUND_COLOR);
        activated = true;
        repaint();
    }
    public void pause(boolean value)
    {
        if (value == true) setBackground(Game.PAUSE_BTN_PAUSED_BACKGROUND_COLOR);
        else setBackground(Game.PAUSE_BTN_DEFAULT_BACKGROUND_COLOR);
        paused = value;
        repaint();
    }

    // Getter
    public boolean isActivated() { return activated; }
    public boolean isPaused() { return paused; }
}
