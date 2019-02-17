package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

// The GuiPopupView is a class responsible for the popup-frame used in the Taskmanager.
// It is a subclass of GuiView which means it needs to implement a listeners-method and can use the frameSettings-method.

class GuiPopupView extends GuiView {
    private JFrame mainFrame = new JFrame();
    private JPanel mainPanel = new JPanel(new GridBagLayout());
    private JButton addTaskButton = new JButton("Add");
    private JButton cancelButton = new JButton("Cancel");
    private JButton calenderButton = new JButton("Calendar");
    private JTextField inputTaskField = new JTextField();
    private DateTextField calender = new DateTextField();
    private String taskType;



    // 1. Calls upon the mainPanel method to set the mainPanel.
    // 2. Initiate the taskType variable depending on which button was used to open the window.
    // 3. Uses the superclass-method frameSettings to set the relevant settings for the frame.

    GuiPopupView(String taskType){
        mainPanel();
        this.taskType = taskType;
        frameSettings(mainFrame, mainPanel, 400, 200);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // Panel housing buttons, JTextField, Calender for the pop up window.
    private void mainPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
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

    private boolean checkDateAfter(Date taskDate){
        boolean validDate = false;
        LocalDate currentDay = LocalDate.now();
        LocalDate checkTaskDate = taskDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if(checkTaskDate.isAfter(currentDay) || checkTaskDate.equals(currentDay)){
            validDate = true;
        }
        return validDate;
    }

    @Override
    void listeners() {
        calenderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calender.DateChoserPanel();
            }
        });
        addTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // ADD NEW TASK
                // 1. Retrieves the content from the JTextField displaying the inputted chosen date from the calender or manually by the user in the type format Date.
                // 2. Converts into Default Format and then sets it equal to a String.
                // 3. Date retrievedDate = calender.getDate().
                // 4. Retrieves content of the JTextField displaying inputted task.
                // 5. Invokes the TaskController with the retrieved data.

                Date retrievedDate = calender.getDate();
                String textTask = inputTaskField.getText();
                if(checkDateAfter(retrievedDate)) {
                    new TaskController(retrievedDate, taskType, textTask);
                    new GuiController();
                    mainFrame.dispose();
                } else JOptionPane.showMessageDialog(mainFrame,
                        "Date is old, try a new one.");

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
            }
        });
    }
}
