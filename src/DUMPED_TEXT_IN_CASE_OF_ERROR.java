/**
 * Created by Jeffery on 2016-04-24.
 */
public class DUMPED_TEXT_IN_CASE_OF_ERROR {


   /*    OLD PAUSE BUTTON CODE
         JPanel _playButtons = new JPanel();
        _playButtons.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        _playButtons.setPreferredSize(new Dimension(Game.TRON_CONTROL_PANEL_WIDTH, 50));

        // Play/Pause Button
        JPanel _p_Button = new JPanel();
        JButton pButton = new JButton("PAUSE");
        pButton.addActionListener(
            e -> {

                if(GameManager.getGameState().equals(Game.NULL)){ pButton.setText("PAUSE"); }

                else if(GameManager.getGameState().equals(Game.IN_PROGRESS))
                {
                    System.out.println("Pause pressed");
                    pButton.setText("PLAY");
                    GameManager.pause();
                    System.out.println(GameManager.getGameState());
                }

                else if (GameManager.getGameState().equals(Game.PAUSED))
                {
                    System.out.println("Play pressed");
                    pButton.setText("PAUSE");
                    GameManager.resume();
                    System.out.println(GameManager.getGameState());
                }
            }
        );
        pButton.setBackground(new Color (57,163,157));
        _p_Button.add(pButton);
        _p_Button.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);

        // Start Button
        JPanel _startButton = new JPanel();
        _startButton.setBackground(Game.TRON_CONTROL_PANEL_BACKGROUND_COLOR);
        _start = new JButton("START");
        _start.addActionListener(
                e -> {
                    if(GameManager.getGameState().equals(Game.NULL)){
                        _start.setText("RESET");
                        System.out.println(_start.getText());
                        GameManager.start();
                    }
                    else {
                        pButton.setText("PAUSE");
                        GameManager.replay(500, 500, true, true);

                    }
                }
        );
        _start.setBackground(new Color (57,163,157));
        _startButton.add(_start);


        // ADD
        _playButtons.add(_startButton);
        _playButtons.add(_p_Button);
        // Return
        return _playButtons;
    }*/

    /* OLD ACTION LISTENER FOR START
    if(GameManager.getGameState().equals(Game.NULL)){
                        _startButton.setText("RESET");
                        System.out.println(_startButton.getText());
                        GameManager.start();
                    }
                    else {
                        _pauseButton.setText("PAUSE");
                        initializeSelected();
                        System.out.println((Integer)selected_Array[0]);
                        System.out.println((Integer)selected_Array[1]);
                        System.out.println((Boolean)selected_Array[2]);
                        System.out.println((Boolean)selected_Array[3]);

                        GameManager.replay(((Integer)selected_Array[0]), ((Integer)selected_Array[1]),(Boolean)selected_Array[2], (Boolean)selected_Array[3]);

                    }
                }
        );
     */
}
