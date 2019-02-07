package com.company;

public class GuiController implements TaskInterface{

    GuiController(TaskModel newTask){
        setLastAction(newTask.toString());
        updateTaskList();
    }

    GuiController(int oldTask){
        setLastAction("Removed: " + GuiMainView.taskTextField.get(oldTask).getText());
        clearGuiTaskList();
        updateTaskList();
    }

    @Override
    public void updateTaskList() {
        for(int i = 0; i < taskArrayList.size(); i++) {
            GuiMainView.taskTextField.get(i).setText(taskArrayList.get(i).toString());
        }
    }

    void setLastAction(String lastAction){
        GuiMainView.lastActionJText.setText(lastAction);
    }

    public void clearGuiTaskList(){
        for (int i = taskArrayList.size(); i < 10; i++){
            GuiMainView.taskTextField.get(i).setText("");
        }
    }
}