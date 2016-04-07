package com.company;

import components.MainWindow;
import components.Point;
import components.Segment;

public class Tron {

    public static void main(String[] args)
    {
        MainWindow window = new MainWindow();
        window.getArena().getJoueurs()[0].getTrace().getSegments().append(new Segment(new Point(20, 50), new Point(2000, 50)));
        window.getArena().getJoueurs()[0].getTrace().getSegments().append(new Segment(new Point(20, 100), new Point(2000, 100)));
        window.getArena().getJoueurs()[0].getTrace().getSegments().append(new Segment(new Point(20, 200), new Point(2000, 200)));
        window.getArena().getJoueurs()[0].getTrace().getSegments().append(new Segment(new Point(20, 300), new Point(2000, 300)));
        window.getArena().getJoueurs()[0].getTrace().getSegments().append(new Segment(new Point(20, 400), new Point(2000, 400)));
        window.pack();
    }
}
