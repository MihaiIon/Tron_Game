package components.subcomponents.controlpanel;

import com.company.Tron;
import constant.Game;
import mecanism.GameManager;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mihai-A on 27/04/2016.
 */
public class StartButton extends JButton {

    private PauseButton pause_button;
    private boolean display_start;
    private Font loaded;

    public StartButton(PauseButton pause_btn){

        // JButton
        setBackground(Game.START_BTN_DEFAULT_BACKGROUND_COLOR);
        setPreferredSize(new Dimension(170,55));

        // Attributes
        pause_button = pause_btn;
        display_start = true;

        // Font
        try {
            loaded = Font.createFont(Font.TRUETYPE_FONT, new File("res/loaded.ttf")).deriveFont(28f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(loaded);
        } catch (IOException|FontFormatException e) { System.out.println("No such font."); }

        repaint();

        // OnClick
        addActionListener(
            e -> {

                if (display_start)
                {
                    display_start = false;
                    repaint();
                }

                if (!pause_button.isActivated()) pause_button.activate();
                else if (pause_button.isPaused()) pause_button.pause(false);
                Tron.window.requestFocusInWindow();

                    /*Puts focus on game to allow player control
                    (TronControlPanel.getControls()).setFocusable(false);
                    (ParametersPanel.get_arenaSize()).setFocusable(false);
                    (ParametersPanel.get_playerSpeed()).setFocusable(false);
                    (ParametersPanel.get_gameType()).setFocusable(false); */

                GameManager.replay();
            }
        );
    }


    /**
     * **COMPLETE THIS**
     * @param g : Graphics
     */
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw
        if (loaded != null) g.setFont(new Font("Loaded", Font.PLAIN, 29));
        g2.setColor(new Color(125, 202, 228));
        g2.drawString((display_start?"Start":"RESET"),38,36);

        if (loaded != null) g.setFont(new Font("Loaded", Font.PLAIN, 28));
        g2.setColor(new Color(20,20,20));
        g2.drawString((display_start?"Start":"RESET"),40,36);
    }

    // Setter
    public void setDisplayStart(boolean boolean_value)
    {
        display_start = boolean_value;
        repaint();
    }
}
