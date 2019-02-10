package com.company;

import javax.swing.*;

abstract class GuiView extends JFrame implements GuiInterface {
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
