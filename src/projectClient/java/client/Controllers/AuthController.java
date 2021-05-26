package client.Controllers;

import client.WorkWithServer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.lang.reflect.Field;

public class AuthController {

    @FXML
    private Button buttonAuthExit;

    @FXML
    private Button buttonLogin;

    @FXML
    private Button buttonReg;

    @FXML
    private TextField fieldLogin;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private Label labelGreeting;

    @FXML
    void buttonAuthExitAction(ActionEvent event) {
        ((Stage)buttonAuthExit.getScene().getWindow()).close();
    }

    @FXML
    void buttonLoginAction(ActionEvent event) {
        if (fieldLogin.getText().length() == 0)
            fieldLogin.setStyle("-fx-border-color: RED; -fx-border-width: 2");
        else
            fieldLogin.setStyle("-fx-border-color: NULL; -fx-border-width: 0");
        if (fieldPassword.getText().length() < 5)
            fieldPassword.setStyle("-fx-border-color: RED; -fx-border-width: 2");
        else
            fieldPassword.setStyle("-fx-border-color: NULL; -fx-border-width: 0");
        if (fieldLogin.getText().length() != 0 && fieldPassword.getText().length() >= 5) {
            Integer answerServerOnAuth = 0;
            try {
                answerServerOnAuth = WorkWithServer.auth(fieldLogin.getText(), fieldPassword.getText());
            }
            catch (NullPointerException e) {System.out.println("ERROR: Server is offline");}
            if (answerServerOnAuth == 1) {

            }
            else if (answerServerOnAuth == 2) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("LOGIN FAILED");
                alert.setHeaderText("Ошибка авторизации");
                alert.setContentText("Неправильно введен логин или пароль. Введите верные данные.");
                alert.setOnHidden(e -> {fieldPassword.setText("");});
                alert.showAndWait();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("LOGIN FAILED");
                alert.setHeaderText("Ошибка подключения к серверу");
                alert.setContentText("Сервер отключен или не отвечает. Обратитесь к администратору.");
                alert.setOnHidden(e -> {fieldPassword.setText("");});
                alert.showAndWait();
            }
        }
    }

    @FXML
    void buttonRegAction(ActionEvent event) {

    }

}



