package com.company;

import javax.swing.*;

// The GuiView is an abstract superclass which extends JFrame.
// It specifies that its children needs to implement a method called listeners().
// This method is then used in the method frameSettings which are being used to -
// - quickly implement standard JFrame settings in the subclasses.

abstract class GuiView extends JFrame {
    abstract void listeners();
    void frameSettings(JFrame frame, JPanel mainPanel, int x, int y){
        frame.add(mainPanel);
        frame.setSize(x, y);
        frame.setLocationRelativeTo(null);
        listeners();
        frame.setVisible(true);
    }
}
