package components;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mihai-A on 12/04/2016.
 */
public class BackgroundPanel extends JLabel {

    /**
     * Creates a component with a backgroundImage
     */
    public BackgroundPanel(JPanel content, Icon backgroundImage) {
        add(content);
        setIcon(backgroundImage);
        setLayout(new BorderLayout());
    }

    public void setImage(Icon backgroundImage){
        setIcon(backgroundImage);
    }
}
