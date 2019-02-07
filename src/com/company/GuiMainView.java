package com.company;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class GuiMainView extends GuiView {
    private JFrame mainFrame = new JFrame();
    private JPanel mainPanel = new JPanel();
    private JPanel todoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 3));
    private JPanel taskPanel = new JPanel(new GridLayout(10, 2));
    private JLabel addNewTaskText = new JLabel("Add new task:");
    private JButton homeTaskButton = new JButton("Home");
    private JButton officeTaskButton = new JButton("Office");
    private JButton errandsTaskButton = new JButton("Errands");
    private ArrayList<JButton> clearTaskButton = new ArrayList<>(10);
    static ArrayList<JTextField> taskTextField = new ArrayList<>(10);
    static JTextField lastActionJText = new JTextField();

    GuiMainView(){
        mainPanel();
        frameSettings(mainFrame, mainPanel, 600, 800);
    }

    @Override
    void mainPanel() {
        mainPanel.setLayout(new BorderLayout(5, 10));
        mainPanel.add(todoPanel(), BorderLayout.NORTH);
        mainPanel.add(taskPanel(), BorderLayout.CENTER);
        mainPanel.add(lastActionPanel(), BorderLayout.SOUTH);
    }

    private JPanel todoPanel(){
        todoPanel.add(addNewTaskText);
        todoPanel.add(officeTaskButton);
        todoPanel.add(homeTaskButton);
        todoPanel.add(errandsTaskButton);
        return todoPanel;
    }

    private JPanel taskPanel(){
        for (int i = 0; i < 10; i++) {
            taskTextField.add(new JTextField(" "));
            clearTaskButton.add(new JButton("Clear TaskObject"));
            taskPanel.add(taskTextField.get(i));
            taskPanel.add(clearTaskButton.get(i));
            taskTextField.get(i).setEditable(false);
            taskTextField.get(i).setBorder(new TitledBorder(("TaskObject: ")));
        }
        return taskPanel;
    }

    private JPanel lastActionPanel() {
        JPanel lastActionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 3));
        lastActionJText.setSize(400, 50);
        lastActionJText.setEditable(false);
        lastActionPanel.add(lastActionJText);
        return lastActionPanel;
    }

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

        for (int i = 0; i < 10; i++) {
            final int current = i;
            clearTaskButton.get(current).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new TaskController().removeTask(current);
                    new GuiController(current);
                    mainFrame.revalidate();
                }
            });
        }
    }
}
