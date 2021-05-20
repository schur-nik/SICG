package client.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocalTasks {
    private static Map<String, Task> listTask = new HashMap<String, Task>();

    public void addLocalTasks() {
        Task taskKR1 = new Task("KR1");
        taskKR1.addLevelInTask(new TaskLevelModel("LOCAL TASK ONE","DESCRIPTION LOCAL TASK 1"));
        taskKR1.addLevelInTask(new TaskLevelModel("LOCAL TASK TWO","DESCRIPTION LOCAL TASK 2"));
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
