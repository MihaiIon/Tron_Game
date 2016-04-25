package components;

import components.subcomponents.ButtonsPanel;
import components.subcomponents.ParametersPanel;
import components.subcomponents.PlayersBoard.PlayersBoard;
import components.subcomponents.PlayersBoard.PlayersBoardContainer;
import constant.Game;
import mecanism.GameManager;
import players.Joueur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by farlyprj on 16-04-06.
 */
public class TronControlPanel extends JPanel {

    // Panels
    private JPanel title_panel;
    private JPanel parameters_panel;
    private JPanel buttons_panel;
    private PlayersBoardContainer players_board_container; // Contains players informations

    // Main Layout
    private BorderLayout tron_control_panel_layout;

    // J-components
    private JLabel title_container;
    private BufferedImage tron_logo;

    //JButtons
    private JButton _start;
    private static JButton controls;

    // Show winner
    private Font roboto_thin;
    private Timer winner_display_timer;
    private boolean winner_displayed;


    /**
     * **COMPLETE THIS**
     */
    public TronControlPanel(Joueur[] players) {

        // Caracteristique
        setPreferredSize(Game.TRON_CONTROL_PANEL_DIMESIONS);
        setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        setLayout(new BorderLayout());
        tron_control_panel_layout = (BorderLayout)getLayout();

        // Title panel
        initializeTitlePanel();
        add(title_panel,BorderLayout.NORTH);
        add(getCenterPanel(players),BorderLayout.CENTER);

        // Add bottom pane
        add(getSouthPanel(),BorderLayout.SOUTH);

        // set winner_displayed
        winner_displayed = false;
    }

    /**
     * Initialize the top pane of the BorderLayout. Contains : Tron logo.
     */
    public void initializeTitlePanel()
    {
        title_panel = new JPanel();
        title_panel.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        title_panel.setPreferredSize(new Dimension(450,183));
        title_panel.setBorder(BorderFactory.createMatteBorder(
            50, 0,
            50, 0,
            Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR
        ));

        // Load Logo
        try
        {
            tron_logo = ImageIO.read(new File("res/tron_Logo.png"));
            title_container = new JLabel(new ImageIcon(tron_logo.getScaledInstance(290, 83, Image.SCALE_DEFAULT)));
            title_panel.add(title_container);
        }
        catch(IOException e){System.out.println(e);}

        // Load Roboto thin font
        try {
            roboto_thin = Font.createFont(Font.TRUETYPE_FONT, new File("res/Roboto-Thin.ttf")).deriveFont(40f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(roboto_thin);

        } catch (IOException | FontFormatException e) {
            System.out.println("No such Font");
        }
    }

    /**
     * Initialize and returns the center pane of the BorderLayout. Contains : game parameters or controls
     * (switches between with the button located in tron_control_panel_layout bottom pane).
     * @return : Center Pane.
     */
    public JPanel getCenterPanel(Joueur[] players)
    {
        JPanel _center = new JPanel();
        _center.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        _center.setPreferredSize(new Dimension(225,210));
        _center.setLayout(new FlowLayout());

        //ADD
        initializeParameters();
        initializeButtons();
        _center.add(parameters_panel);
        _center.add(buttons_panel);

        // Players board panel
        initializePlayersBoard(players);
        _center.add(players_board_container, BorderLayout.CENTER);

        //return
        return _center;
    }


    /**
     * //COMPLETE THIS**
     * @return : **COMPLETE THIS**
     */
    public void initializeParameters()
    {
        parameters_panel = new ParametersPanel(); // components > subccmponents > ParametersPanel.java.

        /*
            Fais la même chose pour initializeButtons. Comme ça les methods n'ont pas
            80 - 120 lignes de codes.

            Tu peux créer aussi des classes comme PlayButton, pour faire new PlayButton() pour découper
            ton code encore plus.

            Comme le prof disait, si ta methode à trop de lignes (20+) ça veux dire que t'aurais pu faire beaucoup
            mieux.



            Autre chose, tes noms de variables pourrait être beaucoup plus verbeux et utiliser une structure plus constante,
            genre plus bas il y a : _p_Button, pButton, play_Button.

                1.) si tu utilises cette écriture _quelque_chose, mets pas de majuscules : _quelque_Chose
                2.) si tu utilises cette écriture _quelque_chose, utilise pas _quelqueChose. garde toujours tes _ et pas de majuscules.
                3.) _p_Button, pButton, play_Button, c'est tous la même affaire. J'ai dû lire toutes les 80 lignes de code avant de comprendre.
                4.) Decoupe plus ton code, crées d'autres classes.



            Si tu te demandes quand créer des classes ou comment savoir qu'il faut que tu crées des classes, il y a quelque
            trucs qu'il ne faut pas oublier.

                1.) Quand tu crées une classe par exemple ParametersPanel.java, cette classe peux avoir des propriétés spécifiques
                    à elle! Elle peux avoir des methodes aussi, des getters, des setters. Tu n'auras jamais ça en faisant
                    un JPanel parameters_panel = new JPanel();

                2.) Donc en créant un nouvel objet, tu crées un entité solide :
                    parameters_panel = new ParemetersPanel(tu_peux_même_passer_des_parametres).

                    Ainsi tu vas pouvoir créer tes propres methodes indispensable :

                        parameters_panel.getArenaSelectedOption()
                        parameters_panel.getPlayersSelectedOption()
                        parameters_panel.getJumboBox1blablabla();
                        parameters_panel.changeColorBecauseIWantItMethod();
                        etc.

                    Tout ça tu ne peux pas le faire si tu instancie des truca par défault.

                3.) Quand tu veux plus de contrôle sur un objet, crées une classe.


         */
    }


    /**
     * intitializes this section's buttons panel with the class ButtonsPanel
     * @return : **COMPLETE THIS**
     */
   public void initializeButtons() {
       buttons_panel = new ButtonsPanel();  // components > subccmponents > ButtonsPanel.java.
   }

   public static Object[] getSelection()
    {
        Object[] returned_Objects = new Object[4];

           returned_Objects[0] = getArenaSize();
           returned_Objects[1] = getArenaSize();
           returned_Objects[2] = isPlayer2Playing();
           returned_Objects[3] = isComputerPlaying();

        return returned_Objects;

    }

    public static Object getArenaSize()
    {
        int dimensions;

        if ((ParametersPanel.get_arenaSize()).getSelectedIndex() == 0) dimensions = 400;
        else if ((ParametersPanel.get_arenaSize()).getSelectedIndex() == 1) dimensions = 500;
        else if ((ParametersPanel.get_arenaSize()).getSelectedIndex() == 2) dimensions = 750;
        else{dimensions = 500;}

        Integer size = new Integer(dimensions);
        return size;
    }

    public static Object isPlayer2Playing()
    {
        //Verifies if the selection is on the 1st or 3rd postion and returns the value found
        Boolean isPlayer2Playing = new Boolean(((ParametersPanel.get_gameType()).getSelectedIndex() == 0) || ((ParametersPanel.get_gameType()).getSelectedIndex() == 2));

        return isPlayer2Playing;
    }

    public static Object isComputerPlaying()
    {
        //Verifies if the selection is on the 1st or 3rd postion and returns the value found
        Boolean isComputerPlaying = new Boolean((ParametersPanel.get_gameType()).getSelectedIndex() == 1 || (ParametersPanel.get_gameType()).getSelectedIndex() == 2);

        return isComputerPlaying;

    }


    /**
     * Initialize and returns the bottom pane of the BorderLayout. Contains : Show-Controls JButton
     * @return : **COMPLETE THIS**
     */
    public JPanel getSouthPanel()
    {
        JPanel _south = new JPanel();
        _south.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        _south.setPreferredSize(new Dimension(450,30));
        controls = new JButton("");
        controls.addActionListener(
                e ->{
                    tron_control_panel_layout.removeLayoutComponent(tron_control_panel_layout.getLayoutComponent(BorderLayout.CENTER));
                    tron_control_panel_layout.addLayoutComponent(new JButton("YOLO"), BorderLayout.CENTER);
                }
        );

        controls.setText("<HTML><FONT color=\"#39A39D\"><U>Show Controls</U></FONT></HTML>");
        controls.setHorizontalAlignment(SwingConstants.RIGHT);
        controls.setBorderPainted(false);
        controls.setOpaque(false);
        controls.setBackground(Color.WHITE);
        // ADD
        _south.add(controls);
        return _south;
    }

    /**
     * **COMPLETE THIS**
     * @param players : **COMPLETE THIS**
     */
    private void initializePlayersBoard(Joueur[] players)
    {
        players_board_container = new PlayersBoardContainer(players);
    }

    /**
     * **COMPLETE THIS**
     * @param winner : **COMPLETE THIS**
     */
    public void displayWinner(String winner, Color winner_color)
    {
        if (winner_display_timer != null) winner_display_timer.cancel();
        winner_display_timer = new Timer();
        winner_display_timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                title_panel.remove(title_container);

                if (winner_displayed) displayLogo();
                else
                {
                    title_container = new JLabel(winner + " HAS WON!");
                    title_container.setFont(roboto_thin);
                    title_container.setForeground(winner_color);
                    title_container.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));
                    title_panel.revalidate();
                    title_panel.repaint();
                }

                title_panel.add(title_container);
                winner_displayed = !winner_displayed;
            }
            }, 0, 1000
        );
    }

    /**
     * Stops title blinking and reverts to tron logo.
     */
    public void stopDisplayingWinner(){
        if (winner_display_timer != null) {
            winner_display_timer.cancel();
            title_panel.remove(title_container);
            displayLogo();
            title_panel.add(title_container);
        }
    }

    /**
     * Displays the logo in the title panel.
     */
    private void displayLogo(){
        title_container = new JLabel(
            new ImageIcon(tron_logo.getScaledInstance(290, 83, Image.SCALE_DEFAULT))
        );
        title_panel.revalidate();
        title_panel.repaint();
    }

    // Getters
    public PlayersBoard getPlayersBoard() { return players_board_container.getPlayersBoard(); }

    public static JButton getControls() { return controls; }
}