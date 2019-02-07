package com.company;

import java.util.Date;

public class TaskModel implements Comparable<TaskModel>{
    Date date;
    String type;
    String task;

    TaskModel(Date newDate, String newType, String newTask){
        this.date = newDate;
        this.type = newType;
        this.task = newTask;
    }

    public String toString(){

        return "[" + date + ": " + type + "]"+ " "  + task;

    }

    @Override
    public int compareTo(TaskModel x) {
        return date.compareTo(x.date);
    }
}
