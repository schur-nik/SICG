package client;

import client.Models.Task;
import client.Models.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class WorkWithServer {
    private static ObjectOutputStream coos;
    private static ObjectInputStream cois;
    private static Socket clientSocket;

    public static void connectToServer() {
        try {
            clientSocket = new Socket("127.0.0.1", 1006);
            coos = new ObjectOutputStream(clientSocket.getOutputStream());
            cois = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void connectClose() {
        try {
            cois.close();
            coos.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String test() {
        connectToServer();
        String res = null;
        try {
            coos.writeObject("test");
            coos.writeObject("test");
            res = (String) cois.readObject();
            coos.writeObject("exit");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            connectClose();
        }
        return res;
    }

    public static Task getTaskFromBd(String nameTask) {
        Task res = null;
        try {
            coos.writeObject("getTaskFromBd");
            coos.writeObject(nameTask);
            res = (Task) cois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static Integer auth(String hashLP) {
        Integer res = null;
/*        try {
            coos.writeObject("auth");
            coos.writeObject(hashLP);
            res = (Integer) cois.readObject();
            if (res == 1) User.setToken((String)cois.readObject());*/
            res = 1;
            User.setToken("666");
/*            coos.writeObject("exit");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Server if offline");
        }*/
        return res;
    }

    public static Object[] getUserData(String token) {
        Object[] res = null;
/*        try {
            coos.writeObject("getUserData");
            coos.writeObject(token);
            res = (Object[]) cois.readObject();
            coos.writeObject("exit");*/
            Map<String, Boolean> map = new HashMap<String, Boolean>();
            map.put("KR1", true);
            res = new Object[]{"Schur", 1, map};
/*        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Server if offline");
        }*/
        return res;
    }
}
