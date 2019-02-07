package com.company;

// This is not the most efficient way. But it's a good excerice in using the super-keyword.

import java.util.Date;

public class TaskOfficeModel extends TaskModel{
    TaskOfficeModel(Date date, String type, String task){
        super(date, type, task);
    }
}
