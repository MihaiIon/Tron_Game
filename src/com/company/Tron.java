package com.company;

import components.Arene;

import javax.swing.*;
import java.awt.*;

public class Tron {

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Tron Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Label("allo"), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
