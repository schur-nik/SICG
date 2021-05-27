package client.Controllers;

import client.Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class StatController {

    @FXML
    private AnchorPane paneTableStat;

    @FXML
    private TableView<?> tableStat;

    @FXML
    private TableColumn<?, ?> colKeyStat;

    @FXML
    private TableColumn<?, ?> colNameStat;

    @FXML
    private TableColumn<?, ?> colCompletStat;

    @FXML
    private TextField fieldLogin;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldSurname;

    @FXML
    private Label labelNumberCompleted;

    @FXML
    private Label labelAvgRating;

    @FXML
    private Button buttonBack;

    @FXML
    void buttonBackAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Models/MenuFrame.fxml"));
        buttonBack.getScene().setRoot(root);
    }

    @FXML
    void initialize() {
        fieldLogin.setStyle("-fx-background-color: linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border),\n" +
                "        linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background);");
        fieldName.setStyle("-fx-background-color: linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border),\n" +
                "        linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background);");
        fieldSurname.setStyle("-fx-background-color: linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border),\n" +
                "        linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background);");
        fieldLogin.setText(User.getUserName());
        fieldName.setText(User.getUserName());
        fieldSurname.setText(User.getUserName());
        labelAvgRating.setText("7.5");
        labelNumberCompleted.setText(Integer.toString(User.getListCompletedTasks().size()));
    }
}
