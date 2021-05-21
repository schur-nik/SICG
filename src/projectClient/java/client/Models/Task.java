package client.Models;

import java.util.ArrayList;

public class Task {
    private String nameTask = null;
    private ArrayList<TaskLevelModel> listLevelsOfTask = null;

    public Task(String nameTask) {
        this.nameTask = nameTask;
        this.listLevelsOfTask = new ArrayList<>();
    }

    public Task(String nameTask, ArrayList<TaskLevelModel> listLevelsOfTask) {
        this.nameTask = nameTask;
        this.listLevelsOfTask = listLevelsOfTask;
    }

    public void addLevelInTask(TaskLevelModel task) {
        this.listLevelsOfTask.add(task);
    }

    public String getNameTask() {
        return nameTask;
    }

    public ArrayList<TaskLevelModel> getListLevelsOfTask() {
        return listLevelsOfTask;
    }
}
