package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

// Superclass used to create TaskModel-objects.
// We name it TaskModel because we wanted to stay as close as possible to the MVC-pattern.
// This means that the model-part of our Taskmanager are responsible for the structure of our data, our task-objects.
// The class further implements the Comparable-interface to make objects comparable -
// - this is so we can sort our list containing objects of this type.

public class TaskModel implements Comparable<TaskModel>{
    private Date date;
    private String type;
    private String task;
    private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    // Constructor used to instantiate a new object.
    // This constructor is invoked with the super-keyword in all of the subclasses.
    TaskModel(Date newDate, String newType, String newTask){
        this.date = newDate;
        this.type = newType;
        this.task = newTask;
    }

    // Converts and object to a single String
    public String toString(){
        return "[" + df.format(date) + ": " + type + "]"+ " "  + task;
    }

    @Override
    public int compareTo(TaskModel x) {
        return date.compareTo(x.date);
    }
}
