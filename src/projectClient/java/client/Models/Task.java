package client.Models;

import java.util.ArrayList;

public class Task {
    private String nameTask = null;
    private ArrayList<TaskLevelModel> task = null;

    public Task(String nameTask) {
        this.nameTask = nameTask;
        this.task = new ArrayList<>();
    }

    public Task(String nameTask, ArrayList<TaskLevelModel> task) {
        this.nameTask = nameTask;
        this.task = task;
    }

    public void addLevelInTask(TaskLevelModel task) {
        this.task.add(task);
    }

    public String getNameTask() {
        return nameTask;
    }

    public ArrayList<TaskLevelModel> getTask() {
        return task;
    }
}
