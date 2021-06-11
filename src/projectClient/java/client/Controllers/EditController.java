package client.Controllers;

import client.Models.AnswerModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EditController {
    ArrayList<AnswerModel> listAnswer = new ArrayList<AnswerModel>();
    ArrayList<Integer> listLevels = new ArrayList<Integer>();

    @FXML
    private Button buttonBack;

    @FXML
    private TextField fieldTopic;

    @FXML
    private TextArea fieldTask;

    @FXML
    private Button buttonPathTask;

    @FXML
    private AnchorPane paneAnswer;

    @FXML
    private Button buttonTextAnswer;

    @FXML
    private Button buttonImageAnswer;

    @FXML
    private AnchorPane paneAnswer1;

    @FXML
    private TableView<Integer> tableLevels;

    @FXML
    private TableColumn<Integer, Integer> columnLevel;

    @FXML
    private Button buttonAddLevel;

    @FXML
    private Button buttonDeleteLevel;

    @FXML
    private TextField fieldPathTask;

    @FXML
    private Button buttonOK;

    @FXML
    private Button buttonAddAnswer;

    @FXML
    private Button buttonDeleteAnswer;

    @FXML
    private TableView<AnswerModel> tableAnswer;

    @FXML
    private TableColumn<AnswerModel, Integer> columnNumberAnswer;

    @FXML
    private TableColumn<AnswerModel, String> columnAnswer;


    @FXML
    void buttonAddAnswerAction(ActionEvent event) {
        //if (((listLevels.size()+1) <= 7 && buttonTextAnswer.isDisable()) || ((listLevels.size()+1) <= 9 && buttonImageAnswer.isDisable())) {
    }

    @FXML
    void buttonDeleteAnswerAction(ActionEvent event) {

    }

    @FXML
    void buttonAddLevelAction(ActionEvent event) {
        listLevels.add(listLevels.get(listLevels.size()-1)+1);
        tableLevels.setItems(FXCollections.observableArrayList(listLevels));
    }

    @FXML
    void buttonDeleteLevelAction(ActionEvent event) {
        if (listLevels.size()-1 > 0) {
            listLevels.remove(listLevels.get(listLevels.size() - 1));
            tableLevels.setItems(FXCollections.observableArrayList(listLevels));
        }
    }

    @FXML
    void buttonOKAction(ActionEvent event) {

    }

    @FXML
    void buttonPathTaskAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        List<File> files = fileChooser.showOpenMultipleDialog(new Stage());
        printLog(fieldTask, files);
    }

    private void printLog(TextArea textArea, List<File> files) {
        if (files == null || files.isEmpty()) {
            return;
        }
        for (File file : files) {
            textArea.appendText(file.getAbsolutePath() + "\n");
        }
    }

    @FXML
    void typeAnswerAction(ActionEvent event) {
        if (buttonTextAnswer.isDisable()) {
            buttonImageAnswer.setDisable(true);
            buttonTextAnswer.setDisable(false);
        }
        else {
            buttonTextAnswer.setDisable(true);
            buttonImageAnswer.setDisable(false);
        }
    }

    @FXML
    void buttonBackAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Models/MenuFrame.fxml"));
        buttonBack.getScene().setRoot(root);
    }

    @FXML
    void initialize() {
        columnNumberAnswer.setCellValueFactory(new PropertyValueFactory<AnswerModel, Integer>("numberAnswer"));
        columnAnswer.setCellValueFactory(new PropertyValueFactory<AnswerModel, String>("answer"));

        columnLevel.setCellValueFactory(col -> new ReadOnlyObjectWrapper<>(col.getValue()));

        tableAnswer.setItems(FXCollections.observableArrayList(listAnswer));
        tableLevels.setItems(FXCollections.observableArrayList(listLevels));
    }

}

