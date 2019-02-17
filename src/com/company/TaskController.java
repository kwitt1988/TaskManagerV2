package com.company;

import java.util.Date;

// TaskController is a class used to control the Taskmanagers data-flow.
// It implements the TaskInterface which is responsible for holding taskModel-objects.
// Foremost it consists of two constructors. One for adding tasks and one for removing tasks.

public class TaskController implements TaskInterface{

    // Handles the creation of a new task, receiving the necessary parts via its parameters.
    // 1. Calls upon createTask to create an task of the specified type.
    // 2. Adds the created object to an ArrayList, taskObjectList, holding objects of TaskModel (superclass).
    // 3. Invoke the no-arg constructor of GuiController which is used to realize changes made to the taskObjectList.

    TaskController(Date date, String type, String task){
        TaskModel newTask = createTask(date, type, task);
        updateTaskList(newTask);
        System.out.println(taskObjectsList);
    }

    // Handles the removal of an object within the taskObjectsList corresponding with the passed chosen index via its parameters.
    // Passes the object to a new GuiController to handle the adding of a removed object in relation to the view.

    TaskController(int taskID, String GuiTaskListCheck){
        try {
            taskObjectsList.remove(taskID);
        }
        catch (IndexOutOfBoundsException e){
            e.getMessage();
        }
    }

    @Override
    public void updateTaskList() {
    }

    // Add a new task object into the taskObject ArrayList and then sorts it.
    // Here we apply polymorphism when we add objects of a subclass in an array holding superclass type.

    private void updateTaskList(TaskModel newTask){
        taskObjectsList.add(newTask);
    }

    // Creates a new object of a specific type based on the receiving String part of the incomplete object.

    private TaskModel createTask(Date date, String type, String task){
        if(type.equals("Office")){
            return new TaskOfficeModel(date, type, task);
        } else if(type.equals("Errands")){
            return new TaskErrandsModel(date, type, task);
        } else return new TaskHomeModel(date, type, task);
    }
}
