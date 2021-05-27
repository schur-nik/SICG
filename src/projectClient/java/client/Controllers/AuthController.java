package client.Controllers;

import client.Models.User;
import client.WorkWithServer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Map;

import static javafx.stage.Modality.APPLICATION_MODAL;

public class AuthController {
    private double xOffset;
    private double yOffset;

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
                answerServerOnAuth = WorkWithServer.auth(Integer.toString(fieldLogin.getText().hashCode()) + Integer.toString(fieldPassword.getText().hashCode()));
            }
            catch (NullPointerException e) {System.out.println("ERROR: Server is offline");}
            if (answerServerOnAuth == 1) {
                Object[] masUserData = WorkWithServer.getUserData(User.getToken());
                User.setUserData((String)masUserData[0], (Integer)masUserData[1], (Map<String, Boolean>) masUserData[2]);
                ((Stage)fieldLogin.getScene().getWindow()).close();
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
    void buttonRegAction(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Models/RegFrame.fxml"));
            Stage regStage = (Stage)buttonReg.getScene().getWindow();
            regStage.setTitle("Registration");
            Scene regScene = new Scene(root);
            regScene.setFill(Color.TRANSPARENT);
            regScene.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = regStage.getX() - event.getScreenX();
                    yOffset = regStage.getY() - event.getScreenY();
                }
            });
            regScene.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    regStage.setX(event.getScreenX() + xOffset);
                    regStage.setY(event.getScreenY() + yOffset);
                }
            });
            regStage.setScene(regScene);
    }

}



