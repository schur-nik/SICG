package client.Controllers;

import client.Models.LocalTasks;
import client.WorkWithServer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import java.io.IOException;

public class LevelMenuController {

    @FXML
    private Button buttonLevel1;

    @FXML
    void buttonLevel1Action(ActionEvent event) throws IOException {
        String nameTask = ((Button)event.getSource()).getText().split("[\\[\\]]+")[1];
        if (LocalTasks.checkNameInTaskList(nameTask)) {
            LevelController.setTask(LocalTasks.getTaskFromLocal(nameTask));
        }
        else {
            LevelController.setTask(WorkWithServer.getTaskFromBd(nameTask));
        }
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Models/LevelFrame.fxml"));
        buttonLevel1.getScene().setRoot(root);
    }

    @FXML
    void initialize() {
    }

}
