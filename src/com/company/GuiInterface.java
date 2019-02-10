package com.company;

// A constant defined in an interface can be accessed using the syntax
// InterfaceName.CONSTANT_NAME (e.g., T.K). It is a good practice to define common
// constants that are shared by many classes in an interface.
// Page 572 - Liang 9th edition.

import javax.swing.*;
import java.util.ArrayList;

public interface GuiInterface {
    ArrayList<JTextField> guiTaskList = new ArrayList<>(10);
    JTextField lastActionText = new JTextField();
    JTextField taskCount = new JTextField("Currently you have 0 tasks.");
}