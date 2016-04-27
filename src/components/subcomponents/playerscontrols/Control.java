package components.subcomponents.playerscontrols;

import com.company.Tron;
import constant.Game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Mihai-A on 27/04/2016.
 */
public class Control extends JPanel {

    /**
     * Provides a JPanel containing graphical control icon and it's associated meaning : W => UP
     * @param key : Key pressed
     * @param result : Action resulting
     */
    public Control(String key, String result)
    {
        // JPanel properties
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(0,5,5,5));

        // Create and add Icon
        add(new Icon(key));

        // Create and add Label
        JLabel _label_result = new JLabel(result);
        _label_result.setForeground(Game.TRON_CONTROLS_LABELS_COLOR);
        _label_result.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        _label_result.setFont(Tron.roboto_thin.deriveFont(20f));
        _label_result.setOpaque(false);
        add(_label_result);
    }
}
