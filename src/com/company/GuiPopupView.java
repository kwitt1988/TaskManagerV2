package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class GuiPopupView extends GuiView {
    private JFrame mainFrame = new JFrame();
    private JPanel mainPanel = new JPanel();
    private JButton addTaskButton = new JButton("Add");
    private JButton cancelButton = new JButton("Cancel");
    private JButton calenderButton = new JButton("KUK");
    private JTextField inputTaskField = new JTextField();
    private DateTextField calender = new DateTextField();
    private GridBagConstraints gbc = new GridBagConstraints();
    private String taskType;

    GuiPopupView(String taskType){
        mainPanel();
        this.taskType = taskType;
        frameSettings(mainFrame, mainPanel, 400, 200);
    }

    @Override
    void mainPanel() {
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        JLabel label = new JLabel("Add " + " Task:");
        gbc.weightx = 0.5;
        gbc.gridx = 3;
        gbc.gridy = 0;
        mainPanel.add(label, gbc);
        gbc.weightx = 0.5;
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Adds the JtextField of which purpose is to receive the users task
        mainPanel.add(inputTaskField, gbc);
        gbc.weightx = 0.5;
        gbc.gridx = 3;
        gbc.gridy = 1;
        // Adds the calender which by the user can chose a date from
        mainPanel.add(calender, gbc);
        gbc.weightx = 4.0;
        gbc.gridx = 5;
        gbc.gridy = 4;
        // Adds the button that the user uses to complete new added task
        mainPanel.add(cancelButton, gbc);
        gbc.weightx = 0.5;
        gbc.gridx = 3;
        gbc.gridy = 4;
        // Add the button which by the user can cancel the chosen task adding panel
        mainPanel.add(addTaskButton, gbc);
        gbc.weightx = 0.5;
        gbc.gridx = 5;
        gbc.gridy = 1;
        // Add the button which by the user can access the calender
        mainPanel.add(calenderButton, gbc);
        mainFrame.add(mainPanel);

    }

    void listeners() {
        calenderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calender.DateChoserPanel();
            }
        });
        addTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ADD NEW TASK
                // 1. Retrieves the content from the JtextField displaying the inputted chosen date from the calender or manually by the user in the type format Date
                // 2. Converts into Default Format and then sets it equal to a String
                // 3. Date retrievedDate = calender.getDate();
                // 4. Retrieves content of the JtextField displaying inputted task
                // 5. Creates a new task which contains chosen date, type of task, e.i. "Office" , "Home" , "Errands", and then finally the inputted task by the user
                Date retrievedDate = calender.getDate();
                String textTask = inputTaskField.getText();
                new TaskController(retrievedDate, taskType, textTask);
                mainFrame.dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
            }
        });
    }
}
