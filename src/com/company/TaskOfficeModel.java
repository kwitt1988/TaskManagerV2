package com.company;

import java.util.Date;

// Subclass used to create Office-tasks.

class TaskOfficeModel extends TaskModel{
    TaskOfficeModel(Date date, String type, String task){
        super(date, type, task);
    }
}
