package client.Models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocalTasks extends Thread{
    private static Map<String, Task> listTask = new HashMap<String, Task>();
    private static final String imagesURLPath = "TaskRes/Images/LocalTask1/";

    public void addLocalTasks() {
        Task taskKR1 = new Task("KR1");
        ImageView[] imagePath = new ImageView[] {
                getImageView("Answer1"),
                getImageView("Answer2")
        };
        taskKR1.addLevelInTask(new TaskLevelModel("LOCAL TASK ONE","DESCRIPTION LOCAL TASK 1", 4, 2));
        taskKR1.addLevelInTask(new TaskLevelModel("LOCAL TASK TWO","DESCRIPTION LOCAL TASK 2", 2, 1, imagePath, null));
        taskKR1.addLevelInTask(new TaskLevelModel("LOCAL TASK THREE","DESCRIPTION LOCAL TASK 3", 9, 5));
        listTask.put("KR1", taskKR1);
    }

    public LocalTasks() {
        addLocalTasks();
    };

    public static Task getTask(String nameTask) {
        return listTask.get(nameTask);
    }

    private ImageView getImageView(String nameImage) {
        return new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(imagesURLPath+nameImage+".png")));
    }

    @Override
    public void run() {
        new LocalTasks();
    }
}
