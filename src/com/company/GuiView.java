package com.company;

import javax.swing.*;

public abstract class GuiView extends JFrame {
    abstract void mainPanel();
    abstract void listeners();

    void frameSettings(JFrame frame, JPanel mainPanel, int x, int y){
        frame.add(mainPanel);
        frame.setSize(x, y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        listeners();
        frame.setVisible(true);
    }
}
