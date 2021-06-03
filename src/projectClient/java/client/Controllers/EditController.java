package client.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;

public class EditController {

    @FXML
    private Button buttonBack;

    @FXML
    void buttonBackAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Models/MenuFrame.fxml"));
        buttonBack.getScene().setRoot(root);
    }

}

