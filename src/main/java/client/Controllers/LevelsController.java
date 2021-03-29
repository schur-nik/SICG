package client.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LevelsController {

    @FXML
    private Button backButton;

    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MenuFrame.fxml"));
        newStage.setTitle("SICG");
        newStage.setScene(new Scene(root, 440, 670));
        newStage.show();
        backButton.getScene().getWindow().hide();
    }

    @FXML
    void initialize() {}

}
