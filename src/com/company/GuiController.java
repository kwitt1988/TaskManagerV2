package com.company;

// This class is responsible for setting removed/added tasks to the GUI.
// To realize this it implements the two interfaces TaskInterface and GuiInterface.
// If invoked with no args it checks the last added task in TaskInterface and updates the components inside GuiInterface.
// If invoked with an int, taskID, it removes the corresponding taskID from the GuiInterface.

import java.util.Collections;

public class GuiController implements TaskInterface, GuiInterface{

    // Responsible for updating the GUI when a new task has been created.
    // 1. Set the added (last) task.
    // 2. Sort the taskObjectList
    // 3. Run the updateTaskList method for setting the sorted taskObjectList to the guiTaskList.
    // 4. Refresh the GuiMainView.
    GuiController(){
        setLastAction("Added: " + taskObjectsList.get(taskObjectsList.size() - 1).toString());
        Collections.sort(taskObjectsList);
        updateTaskList();
        GuiMainView.refresh();
    }

    // Responsible for updating the GUI when a task has been removed.
    GuiController(int taskID){
        setLastAction("Removed: " + guiTaskList.get(taskID).getText());
        clearGuiTaskList();
        updateTaskList();
        GuiMainView.refresh();
    }

    // The TaskInterface specifies that an updateTaskList needs to be implemented.
    // This is to assure that the class implements a way to update the tasklist within the GUI.
    // 1. Loops through the size of the taskObject if its size exceeds 0.
    // 2. Adds the content of each index within the taskObjectList to the corresponding index in the guiTaskList.
    // 3. Calls upon the updateTaskCount method to update the current number of active tasks.
    // 4. If first condition isn't met then only calls upon the updateTaskCount

    @Override
    public void updateTaskList() {
        if(taskObjectsList.size() > 0) {
            for (int i = 0; i < taskObjectsList.size(); i++) {
                guiTaskList.get(i).setText(taskObjectsList.get(i).toString());
                updateTaskCount();
            }
        } else updateTaskCount();
    }

    // The method updateTaskCount are responsible for updating the taskCount in the GUI.
    private void updateTaskCount(){
        if(taskObjectsList.size() == 0) {
            GuiMainView.taskCount.setText("Currently you have 0 tasks.");
        } else GuiMainView.taskCount.setText("Currently you have " + TaskInterface.taskObjectsList.size() + " tasks.");
    }

    // The method setLastAction are responsible for updating the lastActionText in the GUI.
    private void setLastAction(String lastAction){
        lastActionText.setText(lastAction);
    }

    // The method clearGuiTaskList prepares the GUI for updating by removing -
    // - all elements above the taskObjectList-size.
    private void clearGuiTaskList() {
        for (int i = taskObjectsList.size(); i < 10; i++){
            guiTaskList.get(i).setText("");
        }
    }
}