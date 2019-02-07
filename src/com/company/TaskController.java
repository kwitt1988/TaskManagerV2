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

    public void updateTaskList(TaskModel newTask){
        taskArrayList.add(newTask);
        Collections.sort(taskArrayList);
    }

    public void removeTask(int x){
        taskArrayList.remove(x);
    }

    public TaskModel createTask(Date date, String type, String task){
        if(type == "Office"){
            TaskOfficeModel newTask = new TaskOfficeModel(date, type, task);
        } else if(type == "Errands")        {
            TaskErrandsModel newTask = new TaskErrandsModel(date, type, task);
        } TaskHomeModel newTask = new TaskHomeModel(date, type, task);
        return newTask;
    }
}
