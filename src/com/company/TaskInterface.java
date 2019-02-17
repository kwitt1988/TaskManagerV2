package com.company;

import java.util.ArrayList;

// Interface so both controllers has easy access to the taskObjectsList
// Also make sure that both controllers implement an updateTaskList -
// which maps to their corresponding taskLists (guiTaskList / taskObjectList)

interface TaskInterface {
    ArrayList<TaskModel> taskObjectsList = new ArrayList<>(10);
    void updateTaskList();
}