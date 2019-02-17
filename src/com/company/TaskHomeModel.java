package com.company;

import java.util.Date;

// Subclass used to create Home-tasks.

class TaskHomeModel extends TaskModel {
    TaskHomeModel(Date date, String type, String task){
        super(date, type, task);
    }
}
