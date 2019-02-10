package com.company;

public class GuiController implements TaskInterface, GuiInterface{

    GuiController(TaskModel newTask){
        setLastAction("Added: " + newTask.toString());
        updateTaskList();
        GuiMainView.refresh();
    }

    GuiController(int taskID){
        setLastAction("Removed: " + guiTaskList.get(taskID).getText());
        clearGuiTaskList();
        updateTaskList();
        GuiMainView.refresh();
    }

    @Override
    public void updateTaskList() {
        if(taskObjectsList.size() > 0) {
            for (int i = 0; i < taskObjectsList.size(); i++) {
                guiTaskList.get(i).setText(taskObjectsList.get(i).toString());
                updateTaskCount();
            }
        } else updateTaskCount();
    }

    private void updateTaskCount(){
        if(taskObjectsList.size() == 0) {
            GuiMainView.taskCount.setText("Currently you have 0 tasks.");
        } else GuiMainView.taskCount.setText("Currently you have " + TaskInterface.taskObjectsList.size() + " tasks.");
    }

    private void setLastAction(String lastAction){
        lastActionText.setText(lastAction);
    }

    private void clearGuiTaskList(){
        for (int i = taskObjectsList.size(); i < 10; i++){
            guiTaskList.get(i).setText("");
        }
    }
}