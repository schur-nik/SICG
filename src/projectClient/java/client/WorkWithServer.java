package client;

import client.Models.TaskLevelModel;

import java.io.IOException;
import java.util.ArrayList;

public class WorkWithServer {

    public static ArrayList<TaskLevelModel> getTasksForLevel(String nameTask) {
        ArrayList<TaskLevelModel> res = null;
        try {
            Main.coos.writeObject("getTasksForLevel");
            Main.coos.writeObject(nameTask);
            res = (ArrayList<TaskLevelModel>) Main.cois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }
}
