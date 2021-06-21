package client.Controllers;

import client.Models.AnswerModel;
import client.Models.TaskStatModel;
import client.Models.User;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class StatController {
    private ArrayList<TaskStatModel> listStatModel = new ArrayList<>();

    @FXML
    private AnchorPane paneTableStat;

    @FXML
    private TableView<TaskStatModel> tableStat;

    @FXML
    private TableColumn<TaskStatModel, String> colKeyStat;

    @FXML
    private TableColumn<TaskStatModel, String> colNameStat;

    @FXML
    private TableColumn<TaskStatModel, String> colCompletStat;

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
    private ImageView buttonSearch;

    @FXML
    private TextField fieldSearch;

    @FXML
    void buttonBackAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Models/MenuFrame.fxml"));
        buttonBack.getScene().setRoot(root);
    }

    @FXML
    void buttonSearchAction(MouseEvent event) throws IOException {
        ArrayList<TaskStatModel> tempList = new ArrayList<>();
        for (TaskStatModel statModel : listStatModel) {
            if (statModel.getNameTask().contains(fieldSearch.getText())) {
                tempList.add(statModel);
            }
        }
        tableStat.setItems(FXCollections.observableArrayList(tempList));
    }

    @FXML
    void initialize() {
        buttonSearch.setOnMouseClicked(event -> {
            try {
                buttonSearchAction(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fieldLogin.setStyle("-fx-background-color: linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border),\n" +
                "        linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background);");
        fieldName.setStyle("-fx-background-color: linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border),\n" +
                "        linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background);");
        fieldSurname.setStyle("-fx-background-color: linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border),\n" +
                "        linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background);");
        fieldLogin.setText(User.getUserName());
        fieldName.setText("Никита");
        fieldSurname.setText("Щур");
        labelAvgRating.setText("7.5");
        labelNumberCompleted.setText(Integer.toString(User.getListCompletedTasks().size()));

        colKeyStat.setCellValueFactory(new PropertyValueFactory<TaskStatModel, String>("keyTask"));
        colNameStat.setCellValueFactory(new PropertyValueFactory<TaskStatModel, String>("nameTask"));
        colCompletStat.setCellValueFactory(new PropertyValueFactory<TaskStatModel, String>("ratingTask"));

        getListTasks();
        tableStat.setItems(FXCollections.observableArrayList(listStatModel));

        ContextMenu cm = new ContextMenu();
        MenuItem mi1 = new MenuItem("Удалить оценку");
        mi1.setOnAction(event -> {
            TaskStatModel temp = tableStat.getSelectionModel().getSelectedItem();
            temp.setRatingTask("Не завершено");
            listStatModel.set(tableStat.getSelectionModel().getSelectedIndex(), temp);
            tableStat.setItems(FXCollections.observableArrayList(listStatModel));
        });
        cm.getItems().add(mi1);

        tableStat.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                if(t.getButton() == MouseButton.SECONDARY) {
                    cm.show(tableStat, t.getScreenX(), t.getScreenY());
                }
            }
        });
    }

    private void getListTasks() {
        listStatModel.add(new TaskStatModel("KR1", "Контрольная работа #1. Пересчение плоскостей", "7"));
        listStatModel.add(new TaskStatModel("KR2", "Контрольная работа #2. Кривая в пространстве", "9"));
        listStatModel.add(new TaskStatModel("TR1", "Тест #1", "Не завершено"));
        listStatModel.add(new TaskStatModel("TR2", "Тест #2", "Не завершено"));
    }


}
