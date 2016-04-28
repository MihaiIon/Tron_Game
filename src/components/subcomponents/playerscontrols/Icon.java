package components.subcomponents.playerscontrols;

import com.company.Tron;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Mihai-A on 27/04/2016.
 */
public class Icon extends JPanel {

    public Icon(String key){

        // JPanel properties
        setOpaque(false);
        setPreferredSize(new Dimension(38 + 12*(key.length()-1), 36 ));
        ((FlowLayout)getLayout()).setVgap(2);

        // Magic happens here
        JLabel _label = new JLabel(key);
        _label.setOpaque(false);
        _label.setForeground(new Color(100, 100, 100));
        _label.setFont(Tron.roboto_thin.deriveFont(23f));
        add(_label);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Set anti-aliasing
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Draw container
        g2.setColor(new Color(82, 82, 82));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 18, 18);
        g2.setColor(new Color(23, 23, 23));
        g2.fillRoundRect(1, 1, getWidth()-2, getHeight()-2, 18, 18);
    }
}
