package com.company;

import components.MainWindow;
import mecanism.GameManager;
import mecanism.TronTimer;
import players.Joueur;

import java.util.Timer;

public class Tron {

    public static void main(String[] args)
    {
        MainWindow window = new MainWindow();
        GameManager GM = new GameManager(window.getTronPanel());
        window.pack();

        // TESTS SEGMENTS
        /*GM.getPlayers()[0].addSegment(20, 50, 100, 50);
        GM.getPlayers()[0].addSegment(20, 100, 400, 100);
        GM.getPlayers()[1].addSegment(20, 200, 150, 200);
        GM.getPlayers()[0].addSegment(20, 300);
        GM.getPlayers()[0].addSegment(20, 400);*/
        GM.getArena().print();

        // TESTS NEW ARENA
        /*
        GM.createNewArena(400, 400, true);
        GM.getArena().print();
        GM.getPlayers()[0].addSegment(20, 50, 100, 50);
        GM.getPlayers()[2].addSegment(20, 100, 400, 100);
        GM.getPlayers()[1].addSegment(20, 200, 150, 200);
        GM.getPlayers()[0].addSegment(20, 300);
        GM.getPlayers()[0].addSegment(20, 400);
        GM.getArena().print();*/

        //GM.createNewArena(200, 200, true);
        GM.start();
    }
}
