package components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Mihai-A on 07/04/2016.
 */
public class MainWindow extends JFrame{

    // Attributes
    private JLabel background;
    private TronPanel main_panel;

    /**
     * Creates the main window of the application.
     * @throws HeadlessException
     */
    public MainWindow() throws HeadlessException
    {
        // Set Basic attributs
        setTitle("Tron Game");
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // Initialize main_panel and background
        main_panel = new TronPanel();
        background = new JLabel(new ImageIcon("res/background.jpg"));
        background.setLayout(new BorderLayout());
        background.add(main_panel);

        // Set background
        setLayout(new BorderLayout());  // image full size
        setContentPane(background);
        setLayout(new FlowLayout());
        setBackground(Color.black);

        // Just for refresh : So image can be refreshed before the programs opens
        setSize(399,399);
        setSize(400,400);
    }

    public void refresh(){ main_panel.getArena().repaint(); }

    // Getters
    public Arene getArena() { return main_panel.getArena(); }
}
