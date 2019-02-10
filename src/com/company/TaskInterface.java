package com.company;

import java.util.ArrayList;

// Interface so both controllers has easy access to the taskObjectsList
// Also make sure that both backend and frontend tasklists can be updated.

interface TaskInterface {
    ArrayList<TaskModel> taskObjectsList = new ArrayList<>(10);
    void updateTaskList();
}