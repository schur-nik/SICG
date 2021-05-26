package client.Controllers;

import client.Models.LocalTasks;
import client.WorkWithServer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LevelMenuController {

    @FXML
    private AnchorPane anchorPaneLocalTasks;

    @FXML
    private Button buttonBack;

    @FXML
    void buttonBackAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Models/MenuFrame.fxml"));
        buttonBack.getScene().setRoot(root);
    }

    @FXML
    void initialize() {
        for (Node button : anchorPaneLocalTasks.getChildren()) {
            ((Button) button).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String nameTask = ((Button)event.getSource()).getText().split("[\\[\\]]+")[1];
                    if (LocalTasks.checkNameInTaskList(nameTask)) {
                        LevelController.setTask(LocalTasks.getTaskFromLocal(nameTask));
                    }
                    else {
                        LevelController.setTask(WorkWithServer.getTaskFromBd(nameTask));
                    }
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getClassLoader().getResource("Models/LevelFrame.fxml"));
                    } catch (IOException e) {
                        System.out.println("Error: Level not found");
                    }
                    anchorPaneLocalTasks.getScene().setRoot(root);
                }
            });
        }
    }

}
