package client.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegController {

    @FXML
    private Button buttonRegExit;

    @FXML
    private Button buttonRegBack;

    @FXML
    private Button buttonRegDone;

    @FXML
    private TextField fieldLogin;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private Label labelGreeting;

    @FXML
    private PasswordField fieldPasswordCheck;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldSurname;

    @FXML
    void buttonRegDoneAction(ActionEvent event) {

    }

    @FXML
    void buttonRegExitAction(ActionEvent event) throws IOException {
        ((Stage)buttonRegExit.getScene().getWindow()).close();
    }

    @FXML
    void buttonRegBackAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Models/AuthFrame.fxml"));
        Stage regStage = (Stage)buttonRegBack.getScene().getWindow();
        regStage.setTitle("Registration");
        regStage.getScene().setRoot(root);
    }

}
