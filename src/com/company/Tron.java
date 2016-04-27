package com.company;

import components.MainWindow;
import mecanism.GameManager;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Tron {

    public static GameManager GM;
    public static MainWindow window;
    public static Font roboto_medium;
    public static Font roboto_thin;

    public static void main(String[] args)
    {
        // Initialize Font
        initializeRobotoFont();

        // Initialize Game Window
        window = new MainWindow();
        GM = new GameManager(window.getTronPanel());
        window.addKeyListener(GM);
        window.pack();
    }

    private static void initializeRobotoFont()
    {
        try {
            roboto_medium = Font.createFont(Font.TRUETYPE_FONT, new File("res/Roboto-Regular.ttf")).deriveFont(12f);
            roboto_thin = Font.createFont(Font.TRUETYPE_FONT, new File("res/Roboto-Thin.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(roboto_medium);
            ge.registerFont(roboto_thin);

            UIManager.put("Button.font", roboto_medium);
            UIManager.put("ToggleButton.font", roboto_medium);
            UIManager.put("RadioButton.font", roboto_medium);
            UIManager.put("CheckBox.font", roboto_medium);
            UIManager.put("ColorChooser.font", roboto_medium);
            UIManager.put("ComboBox.font", roboto_medium);
            UIManager.put("Label.font", roboto_medium);
            UIManager.put("List.font", roboto_medium);

        } catch (IOException | FontFormatException e) {
            System.out.println("No such Font");
        }
    }
}
