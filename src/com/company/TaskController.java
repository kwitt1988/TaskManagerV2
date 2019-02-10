package com.company;

import java.util.Collections;
import java.util.Date;

public class TaskController implements TaskInterface{

    TaskController(Date date, String type, String task){
        TaskModel newTask = createTask(date, type, task);
        updateTaskList(newTask);
        new GuiController(newTask);
    }

    TaskController(){}

    @Override
    public void updateTaskList() {
    }

    public void removeTask(int taskID){
        taskObjectsList.remove(taskID);
        new GuiController(taskID);
    }

    private void updateTaskList(TaskModel newTask){
            taskObjectsList.add(newTask);
            Collections.sort(taskObjectsList);
        }

    private TaskModel createTask(Date date, String type, String task){
        if(type.equals("Office")){
            TaskOfficeModel newTask = new TaskOfficeModel(date, type, task);
            return newTask;
        } else if(type.equals("Errands")){
            TaskErrandsModel newTask = new TaskErrandsModel(date, type, task);
            return newTask;
        } TaskHomeModel newTask = new TaskHomeModel(date, type, task);
            return newTask;
    }
}
