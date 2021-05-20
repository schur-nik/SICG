package client.Models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocalTasks {
    private static Map<String, Task> listTask = new HashMap<String, Task>();
    private static final String imagesURLPath = "/Users/Shyr_NS/IdeaProjects/SECG/src/projectClient/resources/TaskRes/Images/";

    public void addLocalTasks() {
        Task taskKR1 = new Task("KR1");
        ImageView[] imagePath = new ImageView[] {
                new ImageView(new Image(getClass().getResourceAsStream(imagesURLPath+"LocalTask1/Answer1.png"))),
                new ImageView(new Image(getClass().getResourceAsStream(imagesURLPath+"LocalTask1/Answer2.png")))
        };
        taskKR1.addLevelInTask(new TaskLevelModel("LOCAL TASK ONE","DESCRIPTION LOCAL TASK 1", 4, 2));
        taskKR1.addLevelInTask(new TaskLevelModel("LOCAL TASK TWO","DESCRIPTION LOCAL TASK 2", 2, 1, imagePath, null));
        taskKR1.addLevelInTask(new TaskLevelModel("LOCAL TASK THREE","DESCRIPTION LOCAL TASK 3"));
        listTask.put("KR1", taskKR1);
    }

    public LocalTasks() {
        addLocalTasks();
    };

    public static Task getTask(String nameTask) {
        return listTask.get(nameTask);
    }
}
