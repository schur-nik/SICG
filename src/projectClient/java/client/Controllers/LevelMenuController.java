package client.Controllers;

import client.Models.LocalTasks;
import client.Models.Task;
import client.Models.User;
import client.WorkWithServer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Map;

public class LevelMenuController {

    private void disableCompletedTask(String keyTask, Button buttonCheck) {
        if (User.getUserName() != null)
            if (User.getListCompletedTasks().containsKey(keyTask))
                buttonCheck.setDisable(User.getListCompletedTasks().get(keyTask));
    }

    private void setActionOnButton(AnchorPane ancPane) {
        for (Node button : ancPane.getChildren()) {
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
                    ancPane.getScene().setRoot(root);
                }
            });
        }
    }

    private void addButtonOnPane(AnchorPane ancPane, Map<String, Task> listTask) {
        double gapForButton = 20.0;
        for (Map.Entry<String, Task> task : listTask.entrySet()) {
            Button buttonForAdd = new Button(task.getValue().getNameTask() + " [" + task.getKey() + "]");
            buttonForAdd.getStylesheets().add((getClass().getClassLoader().getResource("TaskRes/Styles/ButtonStyles.css")).toExternalForm());
            buttonForAdd.setId("buttonLevelMenuStyle");
            AnchorPane.setLeftAnchor(buttonForAdd, 35.0);
            AnchorPane.setTopAnchor(buttonForAdd, gapForButton);
            disableCompletedTask(task.getKey(), buttonForAdd);
            ancPane.getChildren().add(buttonForAdd);
            gapForButton += 70;
        }
    }

    @FXML
    private AnchorPane anchorPaneLocalTasks;

    @FXML
    private AnchorPane anchorPaneBdTasks;

    @FXML
    private Button buttonBack;

    @FXML
    void buttonBackAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Models/MenuFrame.fxml"));
        buttonBack.getScene().setRoot(root);
    }

    @FXML
    void initialize() {
        addButtonOnPane(anchorPaneBdTasks, WorkWithServer.getListTasksFromBd());
        addButtonOnPane(anchorPaneLocalTasks, LocalTasks.getListTask());
        setActionOnButton(anchorPaneBdTasks);
        setActionOnButton(anchorPaneLocalTasks);
    }

}
