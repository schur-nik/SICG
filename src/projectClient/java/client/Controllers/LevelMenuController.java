package client.Controllers;

import client.Models.TaskModel;
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
        LevelController.setTasks(WorkWithServer.getTasksForLevel(1));
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Models/LevelFrame.fxml"));
        buttonLevel1.getScene().setRoot(root);
    }

    @FXML
    private SubScene subsceneOne;

    @FXML
    void initialize() {
    }

}
