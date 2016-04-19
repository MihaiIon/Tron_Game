package components;

import components.subcomponents.ParametersPanel;
import constant.Game;
import mecanism.GameManager;
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

    // Panels
    private JPanel title_panel;
    private JPanel parameters_panel;

    // Main Layout
    private BorderLayout tron_control_panel_layout;

    // J-components
    private JLabel title_container;
    private BufferedImage tron_logo;

    // Show winner
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

        // Add top pane
        initializeTitlePanel();
        add(title_panel,BorderLayout.NORTH);
        add(getCenterPanel(),BorderLayout.CENTER);

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
        try
        {
            tron_logo = ImageIO.read(new File("res/tron_Logo.png"));
            title_container = new JLabel(new ImageIcon(tron_logo.getScaledInstance(290, 83, Image.SCALE_DEFAULT)));
            title_panel.add(title_container);
        }
        catch(IOException e){System.out.println(e);}
    }

    /**
     * Initialize and returns the center pane of the BorderLayout. Contains : game parameters or controls
     * (switches between with the button located in tron_control_panel_layout bottom pane).
     * @return : Center Pane.
     */
    public JPanel getCenterPanel()
    {
        JPanel _center = new JPanel();
        _center.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        _center.setPreferredSize(new Dimension(225,210));
        _center.setLayout(new FlowLayout());

        //ADD
        initializeParameters();
        _center.add(parameters_panel);
        _center.add(initializeButtons());

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

                3.) Quand tu veux plus de contrôl sur un objet, crées une classe.


         */
    }


    /**
     * **COMPLETE THIS**
     * @return : **COMPLETE THIS**
     */
    public JPanel initializeButtons()
    {
        JPanel _playButtons = new JPanel();
        _playButtons.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);

        // Start Button
        JPanel _startButton = new JPanel();
        _startButton.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        JButton _start = new JButton("START");
        _start.addActionListener(
            e -> {
                if(GameManager.getGameState() == null){
                    _start.setText("Replay");
                    GameManager.start();
                }
                else { GameManager.replay(500, 500, true, true); }
            }
        );
        _start.setBackground(new Color (57,163,157));
        _startButton.add(_start);

        // Play/Pause Button
        JPanel _p_Button = new JPanel();
        JButton _pButton = new JButton("PAUSE");
        _pButton.addActionListener(
            e -> {

                if(GameManager.getGameState().equals(Game.NULL)){ _pButton.setText("PAUSE"); }

                else if(GameManager.getGameState().equals(Game.IN_PROGRESS))
                {
                    System.out.println("Pause pressed");
                    _pButton.setText("PLAY");
                    GameManager.pause();
                    System.out.println(GameManager.getGameState());
                }

                else if (GameManager.getGameState().equals(Game.PAUSED))
                {
                    System.out.println("Play pressed");
                    _pButton.setText("PAUSE");
                    GameManager.resume();
                    System.out.println(GameManager.getGameState());
                }
            }
        );
        _pButton.setBackground(new Color (57,163,157));
        _p_Button.add(_pButton);
        _p_Button.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);


        // ADD
        _playButtons.add(_startButton);
        _playButtons.add(_p_Button);
        // Return
        return _playButtons;
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
        JButton controls = new JButton("");
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

    public void displayWinner(String winner)
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
                    title_container = new JLabel(winner + " has won!");
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
}