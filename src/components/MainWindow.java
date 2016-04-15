package components;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Mihai-A on 07/04/2016.
 */
public class MainWindow extends JFrame{

    // Attributes
    private BackgroundPanel background;
    private TronPanel main_panel;

    /**
     * Creates the main window of the application/game. It contains the TronPanel.
     * @throws HeadlessException
     */
    public MainWindow() throws HeadlessException
    {
        // Set Basic attributs
        setTitle("Tron Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

                /*// Initialize main_panel and background
                main_panel = new TronPanel();
                setLayout(new GridBagLayout());
                add(main_panel);*/

                // Initialize main_panel and background
                main_panel = new TronPanel();
                background = new BackgroundPanel(main_panel, new ImageIcon("res/background.jpg"));

                // Set background
                setContentPane(background);
                setLayout(new GridBagLayout());
                setBackground(Color.black);

                // Just for refresh : So image can be refreshed before the programs opens
                setSize(399,399);
                setSize(400,400);
                setResizable(false);    // Resize = false


        // KeyLister Section
        setFocusable(true);
        addWindowFocusListener(new WindowAdapter() {
            public void windowGainedFocus(WindowEvent e) {
                main_panel.getArena().requestFocusInWindow();
            }
        });
    }

    // Getters
    public TronPanel getTronPanel() { return main_panel; }
}
