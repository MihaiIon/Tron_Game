package com.company;

import components.MainWindow;
import constant.Direction;
import constant.RefreshRate;
import mecanism.GameManager;
import mecanism.TronTimer;
import players.Joueur;

import java.util.Timer;

public class Tron {

    public static GameManager GM;

    public static void main(String[] args)
    {
        MainWindow window = new MainWindow();
        GM = new GameManager(window.getTronPanel());
        window.addKeyListener(GM);
        window.pack();

        GM.getArena().print();

        // TESTS NEW ARENA + multiplayer
        GM.createNewArena(500, 500, true, false);

        // TEST SPEED
        GM.setDefaultPlayersSpeed(3);

        // TESTS SLOWER_DEBUG_MODE
        //GM.setRefreshRate(RefreshRate.FPS);

        // TEST START
        GM.start();
    }
}
