package com.company;

import components.MainWindow;
import constant.Direction;
import constant.RefreshRate;
import mecanism.GameManager;
import mecanism.TronTimer;
import players.Joueur;

import java.util.Timer;

public class Tron {

    public static void main(String[] args)
    {
        MainWindow window = new MainWindow();
        GameManager GM = new GameManager(window.getTronPanel());
        window.addKeyListener(GM);
        window.pack();

        GM.getArena().print();

        // TESTS NEW ARENA + multiplayer
        //GM.createNewArena(600, 600, true);

        // TEST SPEED
        GM.setDefaultPlayersSpeed(3);

        // TESTS SLOWER_DEBUG_MODE
        GM.setRefreshRate(RefreshRate.FPS_30);

        // TEST START
        GM.start();
    }
}
