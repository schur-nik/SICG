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
        ImageView[] masImage = new ImageView[] {
                getImageView("Answer1"),
                getImageView("Answer2")
        };
        String[] masText = new String[] {
                "Answer One is here!",
                "Answer Two is here!",
                "Answer Three is here!",
                "Answer Four is here!",
                "Answer Five is here!"
        };
        String[] masText2 = new String[] {
                "Answer One is here!",
                "Answer Two is here!",
                "Answer Three is here!",
                "Answer Four is here!",
                "Answer Five is here!",
                "Answer Six is here!",
                "Answer Seven is here!"
        };
        taskKR1.addLevelInTask(new TaskLevelModel("LOCAL TASK ONE","DESCRIPTION LOCAL TASK 1", 5, 2, null , masText, null,1));
        taskKR1.addLevelInTask(new TaskLevelModel("LOCAL TASK TWO","DESCRIPTION LOCAL TASK 2", 2, 1, masImage, null, null, 2));
        taskKR1.addLevelInTask(new TaskLevelModel("LOCAL TASK THREE","DESCRIPTION LOCAL TASK 3", 7, 5, null, masText2, null, 1));
        listTask.put("KR1", taskKR1);
    }

    public LocalTasks() {
        addLocalTasks();
    };

    public static Task getTaskFromLocal(String nameTask) {
        return listTask.get(nameTask);
    }

    public static Boolean checkNameInTaskList(String nameTask) {
        return listTask.containsKey(nameTask);
    }

    private ImageView getImageView(String nameImage) {
        return new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(imagesURLPath+nameImage+".png")));
    }

    @Override
    public void run() {
        new LocalTasks();
    }
}
