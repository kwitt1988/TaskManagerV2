package com.company;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

// GuiMainView is a class for handling the Taskmanagers main GUI.
// The class extends the superclass GuiView for easy implementation of standard JFrame settings.
// The class also implements the interface GuiInterface which holds some components that the class displays -
// - but are being manipulated by another class.

class GuiMainView extends GuiView implements GuiInterface {
    private static JFrame mainFrame = new JFrame();
    private JPanel mainPanel = new JPanel();
    private JButton homeTaskButton = new JButton("Home");
    private JButton officeTaskButton = new JButton("Office");
    private JButton errandsTaskButton = new JButton("Errands");
    private ArrayList<JButton> clearTaskButton = new ArrayList<>(10);

    // First method to get called during program startup via the Main.
    // 1. Calls upon the mainPanel-method to paint the mainPanel.
    // 2. Passes the mainPanel to the superclass's frameSettings-method to set the mainFrame.
    GuiMainView(){
        mainPanel();
        frameSettings(mainFrame, mainPanel, 600, 800);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Adds the relevant panels for the mainView to the mainPanel using an BorderLayout.
    private void mainPanel() {
        mainPanel.setLayout(new BorderLayout(5, 10));
        mainPanel.add(topPanel(), BorderLayout.NORTH);
        mainPanel.add(taskPanel(), BorderLayout.CENTER);
        mainPanel.add(lastActionPanel(), BorderLayout.SOUTH);
    }

    // Topmost panel including the taskCount which show the number of active tasks and the todoPanel which supplies a row of task buttons.
    private JPanel topPanel(){
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout(5, 10));
        topPanel.add(taskCount, BorderLayout.SOUTH);
        topPanel.add(todoPanel(), BorderLayout.NORTH);
        return topPanel;
    }

    // Panel supplying the row of task type buttons .
    private JPanel todoPanel(){
        JPanel todoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 3));
        JLabel addNewTaskText = new JLabel("Add new task:");
        todoPanel.add(addNewTaskText);
        todoPanel.add(officeTaskButton);
        todoPanel.add(homeTaskButton);
        todoPanel.add(errandsTaskButton);
        return todoPanel;
    }

    // Middle panel including the 10 JTextFields and corresponding button to clear those fields, added one by one to their ArrayLists by the help of a loop.
    private JPanel taskPanel(){
        JPanel taskPanel = new JPanel(new GridLayout(10, 2));
        for (int i = 0; i < 10; i++) {
            guiTaskList.add(new JTextField(" "));
            clearTaskButton.add(new JButton("Clear TaskObject"));
            taskPanel.add(guiTaskList.get(i));
            taskPanel.add(clearTaskButton.get(i));
            guiTaskList.get(i).setEditable(false);
            guiTaskList.get(i).setBorder(new TitledBorder(("TaskObject: ")));
        }
        return taskPanel;
    }

    // Bottom panel which consists of a JTextField that is reached through the GuiInterface.
    private JPanel lastActionPanel() {
        JPanel lastActionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 3));
        lastActionText.setSize(400, 50);
        lastActionText.setEditable(false);
        lastActionText.setText("");
        lastActionPanel.add(lastActionText);
        return lastActionPanel;
    }

    // A static function used to refresh the mainView after changes to the content has been made from another class.
    static void refresh(){
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    // Listeners for all buttons comprised within GuiMainView.
    @Override
    void listeners() {officeTaskButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new GuiPopupView("Office");
        }
    });

        homeTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GuiPopupView("Home");
            }
        });

        errandsTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GuiPopupView("Errands");
            }
        });

        // A loop that uses the fact that each of the ten rows holding tasks and clearTaskButtons
        // are created during one iteration of a loop. This means that they both reside
        // in the same index in their respective ArrayList. So if the user presses clearTaskButton(7),
        // guiTaskList(7) gets cleared using the TaskController class.

        for (int i = 0; i < 10; i++) {
            final int current = i;
            clearTaskButton.get(current).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new TaskController(current, guiTaskList.get(current).getText());
                    new GuiController(current);
                    refresh();
                }
            });
        }
    }
}
