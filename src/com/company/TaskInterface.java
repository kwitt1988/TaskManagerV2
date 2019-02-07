package com.company;

import java.util.ArrayList;

// Interface so both controllers has easy access to the taskArrayList
// Also make sure that both backend and frontend tasklists can be updated.

public interface TaskInterface {
    ArrayList<TaskModel> taskArrayList = new ArrayList<TaskModel>(10);
    void updateTaskList();
}
