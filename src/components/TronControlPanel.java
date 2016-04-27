package components;

import components.subcomponents.controlpanel.ButtonsPanel;
import components.subcomponents.controlpanel.OptionsPanel;
import components.subcomponents.playerboard.PlayersBoard;
import components.subcomponents.playerboard.PlayersBoardContainer;
import constant.Game;
import players.Joueur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by farlyprj on 16-04-06.
 */
public class TronControlPanel extends JPanel {

    // Main Layout
    private BorderLayout tron_control_panel_layout;

    // Panels
    private JPanel title_panel;
    private JPanel main_panel;
    private boolean main_panel_displayed;

    // J-Complexe-Panels
    private OptionsPanel options_panel;
    private ButtonsPanel buttons_panel;
    private PlayersBoardContainer players_board_container; // Contains players informations
    private JPanel controls_panel; // Contains players controls

    // J-Components
    private JLabel title_container;
    private BufferedImage tron_logo;
    private JButton show_controls_btn;

    // Show winner
    private Font roboto_thin;
    private Timer winner_display_timer;
    private boolean winner_displayed;


    /**
     * **COMPLETE THIS**
     */
    public TronControlPanel() {

        // Caracteristique
        setPreferredSize(Game.TRON_CONTROL_PANEL_DIMESIONS);
        setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        setLayout(new BorderLayout());
        tron_control_panel_layout = (BorderLayout)getLayout();

        // Title panel
        initializeTitlePanel();
        initializeMainPanel();
        add(title_panel,BorderLayout.NORTH);
        add(main_panel,BorderLayout.CENTER);
        main_panel_displayed = true;

        // Add bottom pane
        add(InitializeSouthPanel(),BorderLayout.SOUTH);

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
     * Initialize the main panel of the BorderLayout. Contains : game options controllers , buttons and players board.
     */
    public void initializeMainPanel()
    {
        // JPanel
        main_panel = new JPanel();
        main_panel.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        main_panel.setLayout(new FlowLayout());

        // Add sub components
        options_panel = new OptionsPanel();  // components > subcomponents > OptionsPanel.java.
        buttons_panel = new ButtonsPanel();  // components > subcomponents > ButtonsPanel.java.
        main_panel.add(options_panel);
        main_panel.add(buttons_panel);

        // Add Players board panel
        players_board_container = new PlayersBoardContainer();
        main_panel.add(players_board_container, BorderLayout.CENTER);
    }


    /**
     * //COMPLETE THIS**
     * @return : **COMPLETE THIS**
     */
    public void initializeOptions()
    {
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

                1.) Quand tu crées une classe par exemple OptionsPanel.java, cette classe peux avoir des propriétés spécifiques
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
     * Initialize and returns the bottom pane of the BorderLayout. Contains : Show-Controls JButton
     * @return : **COMPLETE THIS**
     */
    public JPanel InitializeSouthPanel()
    {
        JPanel _south = new JPanel();
        _south.setLayout(new FlowLayout(FlowLayout.RIGHT));
        _south.setBorder(BorderFactory.createEmptyBorder(0,0,5,5));
        _south.setOpaque(false);

        // Show controls - Button
        show_controls_btn = new JButton("");
        show_controls_btn.setFocusable(false);
        show_controls_btn.addActionListener(
            e ->{
                remove(tron_control_panel_layout.getLayoutComponent(BorderLayout.CENTER));
                if (!main_panel_displayed) add(main_panel, BorderLayout.CENTER);
                else add(new JButton("YOLO"), BorderLayout.CENTER);
                main_panel_displayed = !main_panel_displayed;
                revalidate();
                repaint();
            }
        );
        show_controls_btn.setText("<HTML><FONT color=\"#39A39D\"><U>Show Controls</U></FONT></HTML>");
        show_controls_btn.setBorderPainted(false);
        show_controls_btn.setOpaque(false);
        show_controls_btn.setBackground(Color.WHITE);

        // ADD
        _south.add(show_controls_btn);
        return _south;
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
    public Object[] getOptions() { return options_panel.getOptions(); }
    public ButtonsPanel getButtons() { return buttons_panel; }
}