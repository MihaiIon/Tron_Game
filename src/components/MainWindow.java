package components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Mihai-A on 07/04/2016.
 */
public class MainWindow extends JFrame{

    //
    //private
    private JLabel background;
    private JPanel main_panel;
    private Arene arena;

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
        main_panel = new JPanel(new BorderLayout());
        main_panel.setBackground(new Color(0, 0, 0, 0));    // Transparent
        background = new JLabel(new ImageIcon("res/background.jpg"));
        background.setLayout(new BorderLayout());
        background.add(main_panel);

        // Set background
        setLayout(new BorderLayout());  // image full size
        setContentPane(background);
        setLayout(new FlowLayout());
        setBackground(Color.black);

        // Initialize to default size and add it to the main_panel center pane
        arena = new Arene();
        main_panel.add(arena, BorderLayout.CENTER);

        //
        //main_panel.add(new Button("allo"), BorderLayout.NORTH);

        // Just for refresh : So image can be refreshed before the programs opens
        setSize(399,399);
        setSize(400,400);
    }

    // Getters
    public Arene getArena() { return arena; }
}
