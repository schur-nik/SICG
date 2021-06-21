package client.Models;

public class TaskStatModel {
    private String keyTask;
    private String nameTask;
    private String ratingTask;

    public TaskStatModel(String keyTask, String nameTask, String ratingTask) {
        this.keyTask = keyTask;
        this.nameTask = nameTask;
        this.ratingTask = ratingTask;
    }

    public String getKeyTask() {
        return keyTask;
    }

    public void setKeyTask(String keyTask) {
        this.keyTask = keyTask;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getRatingTask() {
        return ratingTask;
    }

    public void setRatingTask(String ratingTask) {
        this.ratingTask = ratingTask;
    }
}
