package client.Models;

import java.util.HashMap;
import java.util.Map;

public class User {
    private static String userName = null;
    private static String token = null;
    private static Integer role = null;
    private static Map<String, Boolean> listCompletedTasks = new HashMap<String, Boolean>();

    public static void setUserData(String userName, Integer role, Map<String, Boolean> listCompletedTasks) {
        User.userName = userName;
        User.role = role;
        User.listCompletedTasks = listCompletedTasks;
    }

    public static void setToken(String token) {
        User.token = token;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getToken() {
        return token;
    }

    public static Integer getRole() {
        return role;
    }

    public static Map<String, Boolean> getListCompletedTasks() {
        return listCompletedTasks;
    }
}
