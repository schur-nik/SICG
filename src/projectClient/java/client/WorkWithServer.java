package client;

import client.Models.TaskModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkWithServer {

    public static ArrayList<TaskModel> getTasksForLevel(int i) {
        ArrayList<TaskModel> res = null;
        try {
            Main.coos.writeObject("getTasksForLevel");
            res = (ArrayList<TaskModel>) Main.cois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }
}
