package client.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button startButton;

    @FXML
    void startButtonAction(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Models/LevelsFrame.fxml"));
        newStage.setTitle("Levels");
        newStage.setScene(new Scene(root, 440, 670));
        newStage.show();
        startButton.getScene().getWindow().hide();
    }

    @FXML
    void initialize() {}

}
