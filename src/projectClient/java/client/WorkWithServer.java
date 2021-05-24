package client;

import client.Models.Task;
import java.io.IOException;

public class WorkWithServer {

    public static Task getTaskFromBd(String nameTask) {
        Task res = null;
        try {
            Main.coos.writeObject("getTaskFromBd");
            Main.coos.writeObject(nameTask);
            res = (Task) Main.cois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }
}
