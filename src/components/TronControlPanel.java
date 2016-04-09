package components;

import players.controls.Controls;

import javax.swing.*;

/**
 * Created by farlyprj on 16-04-06.
 */
public class TronControlPanel extends JPanel {

    public TronControlPanel() {
        addKeyListener(new Controls());
    }
}
