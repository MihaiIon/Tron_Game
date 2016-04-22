package com.company;

import components.MainWindow;
import mecanism.GameManager;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Tron {

    public static GameManager GM;

    public static void main(String[] args)
    {
        // Initialize Font
        initializeRobotoFont();

        // Initialize Game
        MainWindow window = new MainWindow();
        GM = new GameManager(window.getTronPanel());
        GM.createNewArena(700,700,true, true);
        window.addKeyListener(GM);
        window.pack();
    }

    private static void initializeRobotoFont()
    {
        try {
            Font _roboto_medium = Font.createFont(Font.TRUETYPE_FONT, new File("res/Roboto-Regular.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(_roboto_medium);

            UIManager.put("Button.font", _roboto_medium);
            UIManager.put("ToggleButton.font", _roboto_medium);
            UIManager.put("RadioButton.font", _roboto_medium);
            UIManager.put("CheckBox.font", _roboto_medium);
            UIManager.put("ColorChooser.font", _roboto_medium);
            UIManager.put("ComboBox.font", _roboto_medium);
            UIManager.put("Label.font", _roboto_medium);
            UIManager.put("List.font", _roboto_medium);

        } catch (IOException | FontFormatException e) {
            System.out.println("No such Font");
        }
    }
}
