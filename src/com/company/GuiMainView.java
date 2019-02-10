package com.company;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

class GuiMainView extends GuiView {
    public static JFrame mainFrame = new JFrame();
    private JPanel mainPanel = new JPanel();
    private JButton homeTaskButton = new JButton("Home");
    private JButton officeTaskButton = new JButton("Office");
    private JButton errandsTaskButton = new JButton("Errands");
    private ArrayList<JButton> clearTaskButton = new ArrayList<>(10);

    GuiMainView(){
        mainPanel();
        frameSettings(mainFrame, mainPanel, 600, 800);

    }

    @Override
    void mainPanel() {
        mainPanel.setLayout(new BorderLayout(5, 10));
        mainPanel.add(topPanel(), BorderLayout.NORTH);
        mainPanel.add(taskPanel(), BorderLayout.CENTER);
        mainPanel.add(lastActionPanel(), BorderLayout.SOUTH);
    }

    private JPanel topPanel(){
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout(5, 10));
        topPanel.add(taskCount, BorderLayout.SOUTH);
        topPanel.add(todoPanel(), BorderLayout.NORTH);
        return topPanel;
    }

    private JPanel todoPanel(){
        JPanel todoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 3));
        JLabel addNewTaskText = new JLabel("Add new task:");
        todoPanel.add(addNewTaskText);
        todoPanel.add(officeTaskButton);
        todoPanel.add(homeTaskButton);
        todoPanel.add(errandsTaskButton);
        return todoPanel;
    }

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

    private JPanel lastActionPanel() {
        JPanel lastActionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 3));
        lastActionText.setSize(400, 50);
        lastActionText.setEditable(false);
        lastActionText.setText("");
        lastActionPanel.add(lastActionText);
        return lastActionPanel;
    }

    static void refresh(){
        mainFrame.revalidate();
        mainFrame.repaint();
    }

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

        for (int i = 0; i < 10; i++) {
            final int current = i;
            clearTaskButton.get(current).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new TaskController().removeTask(current);
                    refresh();
                }
            });
        }
    }
}
