package client.Models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.HashMap;
import java.util.Map;

public class LocalTasks extends Thread{
    private static Map<String, Task> listTask = new HashMap<String, Task>();
    private static final String imagesURLPath = "TaskRes/Images/LocalTask1/";

    public void addLocalTasks() {
        task1();
        task2();
    }

    public LocalTasks() {
        addLocalTasks();
    };

    public static Task getTaskFromLocal(String nameTask) {
        return listTask.get(nameTask);
    }

    public static Map<String, Task> getListTask() { return listTask; }

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

    private void task1() {
        Task taskKR1 = new Task("Задание 1. Пересчение плоскостей.");
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
        taskKR1.addLevelInTask(new TaskLevelModel("LOCAL TASK ONE","DESCRIPTION LOCAL TASK 1", 5, 2, null , masText, "Task1.jpg",1));
        taskKR1.addLevelInTask(new TaskLevelModel("LOCAL TASK TWO","DESCRIPTION LOCAL TASK 2", 2, 1, masImage, null, "Task1.jpg", 2));
        taskKR1.addLevelInTask(new TaskLevelModel("LOCAL TASK THREE","DESCRIPTION LOCAL TASK 3", 7, 5, null, masText2, "Task1.jpg", 1));
        listTask.put("KR1", taskKR1);
    }

    private void task2() {
        Task taskKR1 = new Task("Задание 2. Кривая в пространстве.");
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
        taskKR1.addLevelInTask(new TaskLevelModel("LOCAL TASK ONE","DESCRIPTION LOCAL TASK 1", 5, 2, null , masText, "Task1.jpg",1));
        taskKR1.addLevelInTask(new TaskLevelModel("LOCAL TASK TWO","DESCRIPTION LOCAL TASK 2", 2, 1, masImage, null, "Task1.jpg", 2));
        taskKR1.addLevelInTask(new TaskLevelModel("LOCAL TASK THREE","DESCRIPTION LOCAL TASK 3", 7, 5, null, masText2, "Task1.jpg", 1));
        listTask.put("KR2", taskKR1);
    }

}
