package client.Controllers;

import client.Models.Task;
import client.Models.TaskLevelModel;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.shape.Mesh;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import java.io.File;
import java.util.*;

public class LevelController {

    private static Task task = null;
    private static Map<Integer, Boolean> mapTrueAnswerOnLevels = new HashMap<Integer, Boolean>();
    private static Map<Integer, Integer> mapAnswerInLevels = new HashMap<Integer, Integer>();
    private Integer numberLevelOfTask = 0;
    private Integer trueAnswer = 0;
    private Integer typeAnswer = 0;
    private static Integer numberOfLevels = 0;

    private static final String MESH_FILENAME =
            "/Users/Shyr_NS/IdeaProjects/SECG/src/projectClient/resources/TaskRes/3dModels/Besenhalter_325mm.stl";

    private static final double MODEL_SCALE_FACTOR = 3;
    private static final double MODEL_X_OFFSET = 0; // standard
    private static final double MODEL_Y_OFFSET = 0; // standard

    private static final int VIEWPORT_SIZE = 600;
    MeshView[] meshViews;
    private Group root;

    static MeshView[] loadMeshViews() {
        File file = new File(MESH_FILENAME);
        StlMeshImporter importer = new StlMeshImporter();
        importer.read(file);
        Mesh mesh = importer.getImport();

        return new MeshView[] { new MeshView(mesh) };
    }

    private Group buildScene() {
        meshViews = loadMeshViews();
        for (int i = 0; i < meshViews.length; i++) {
            meshViews[i].setScaleX(MODEL_SCALE_FACTOR);
            meshViews[i].setScaleY(MODEL_SCALE_FACTOR);
            meshViews[i].setScaleZ(MODEL_SCALE_FACTOR);
            meshViews[i].setTranslateX(VIEWPORT_SIZE / 2 + MODEL_X_OFFSET);
            meshViews[i].setTranslateY(VIEWPORT_SIZE / 2 + MODEL_Y_OFFSET);
            meshViews[i].setTranslateZ(VIEWPORT_SIZE / 2);
            meshViews[i].getTransforms().setAll(new Rotate(0, Rotate.X_AXIS),
                    new Rotate(0, Rotate.Y_AXIS),
                    new Rotate(0, Rotate.Z_AXIS));
        }
        root = new Group(meshViews);
        return root;
    }

    private PerspectiveCamera addCamera(SubScene scene) {
        PerspectiveCamera perspectiveCamera = new PerspectiveCamera();
        scene.setCamera(perspectiveCamera);
        return perspectiveCamera;
    }

    public static void setTask(Task task) {
        LevelController.task = task;
        numberOfLevels = task.getListLevelsOfTask().size();
    }

    @FXML
    private ProgressBar progressBarTime;

    @FXML
    private AnchorPane anchorPaneAnswers;

    @FXML
    private AnchorPane anchorPaneImage;

    @FXML
    private RadioButton buttonImageAnswer1;

    @FXML
    private RadioButton buttonImageAnswer2;

    @FXML
    private RadioButton buttonImageAnswer3;

    @FXML
    private RadioButton buttonImageAnswer4;

    @FXML
    private RadioButton buttonImageAnswer5;

    @FXML
    private RadioButton buttonImageAnswer6;

    @FXML
    private RadioButton buttonImageAnswer7;

    @FXML
    private RadioButton buttonImageAnswer8;

    @FXML
    private RadioButton buttonImageAnswer9;

    @FXML
    private AnchorPane anchorPaneText;

    @FXML
    private RadioButton buttonTextAnswer1;

    @FXML
    private RadioButton buttonTextAnswer2;

    @FXML
    private RadioButton buttonTextAnswer3;

    @FXML
    private RadioButton buttonTextAnswer4;

    @FXML
    private RadioButton buttonTextAnswer5;

    @FXML
    private RadioButton buttonTextAnswer6;

    @FXML
    private RadioButton buttonTextAnswer7;

    @FXML
    private SubScene subsceneOne;

    @FXML
    private Label labelTopic;

    @FXML
    private Button buttonEnd;

    @FXML
    private Button buttonNext;

    @FXML
    private Button buttonPrev;

    @FXML
    private Label labelCounter;

    @FXML
    private TextArea textAreaTask;

    @FXML
    private Label labelTime;

    private void setLevel(Integer numberLevel) {
        TaskLevelModel level = task.getListLevelsOfTask().get(numberLevel-1);
        resetLevel();
        typeAnswer = level.getTypeAnswer();
        loadLevel();
        labelCounter.setText((numberLevel)+"/"+numberOfLevels);
        labelTopic.setText(level.getTopicTask());
        textAreaTask.setText(level.getTextTask());
        setAnswers(level.getNumberAnswer());
        trueAnswer = level.getTrueAnswer();
    }

    private void loadLevel() {
        if (typeAnswer == 1) {
            if (mapAnswerInLevels.containsKey(numberLevelOfTask)) {
                ((RadioButton) anchorPaneText.getChildren().get(mapAnswerInLevels.get(numberLevelOfTask) - 1)).setSelected(true);
            }
        }
        else if (typeAnswer == 2) {
            if (mapAnswerInLevels.containsKey(numberLevelOfTask)) {
                ((RadioButton) anchorPaneImage.getChildren().get(mapAnswerInLevels.get(numberLevelOfTask) - 1)).setSelected(true);
            }
        }
    }

    private void resetLevel() {
        anchorPaneText.setVisible(false);
        anchorPaneImage.setVisible(false);
        typeAnswer = 0;
        for (Node radioButton : anchorPaneText.getChildren()) {
            radioButton.setVisible(false);
            ((RadioButton) radioButton).setSelected(false);
        }
        for (Node radioButton : anchorPaneImage.getChildren()) {
            radioButton.setVisible(false);
            ((RadioButton) radioButton).setSelected(false);
            ((RadioButton) radioButton).setBackground(null);
        }
    }

    private void setAnswers(Integer answerCount) {
        ObservableList<Node> buttons = null;
        if (typeAnswer == 1) {
            anchorPaneText.setVisible(true);
            if (answerCount <= 5) {
                anchorPaneAnswers.setMaxHeight(360);
                anchorPaneAnswers.setMinHeight(360);
            } else {
                anchorPaneAnswers.setMaxHeight(542);
                anchorPaneAnswers.setMinHeight(542);
            }
            buttons = anchorPaneText.getChildren();
            for (int i = 0; i < answerCount; i++) {
                RadioButton tempButton = (RadioButton) buttons.get(i);
                tempButton.setVisible(true);
                if (task.getListLevelsOfTask().get(numberLevelOfTask - 1).getMasTextAnswer() != null) {
                    tempButton.setText(task.getListLevelsOfTask().get(numberLevelOfTask - 1).getMasTextAnswer()[i]);
                }
            }
        }
        else if (typeAnswer == 2) {
            anchorPaneImage.setVisible(true);
            if (answerCount <= 6) {
                anchorPaneAnswers.setMaxHeight(360);
                anchorPaneAnswers.setMinHeight(360);
            } else {
                anchorPaneAnswers.setMaxHeight(542);
                anchorPaneAnswers.setMinHeight(542);
            }
            buttons = anchorPaneImage.getChildren();
            for (int i = 0; i < answerCount; i++) {
                RadioButton tempButton = (RadioButton) buttons.get(i);
                tempButton.setVisible(true);
                if (task.getListLevelsOfTask().get(numberLevelOfTask - 1).getMasImageAnswer() != null) {
                    tempButton.setBackground(new Background
                            (new BackgroundImage(task.getListLevelsOfTask().get(numberLevelOfTask - 1).getMasImageAnswer()[i].getImage(),
                                    BackgroundRepeat.NO_REPEAT,
                                    BackgroundRepeat.NO_REPEAT,
                                    BackgroundPosition.CENTER,
                                    BackgroundSize.DEFAULT)
                            )
                    );
                }
            }
        }
    }

    @FXML
    void buttonEndAction(ActionEvent event) {

    }

    double anchorX, anchorY, anchorAngle;
    Rotate rotateX = new Rotate(), rotateY = new Rotate();

    @FXML
    void buttonNextAction(ActionEvent event) {
        if (numberLevelOfTask < task.getListLevelsOfTask().size()) {
            numberLevelOfTask++;
            setLevel(numberLevelOfTask);
        }
        else {}
    }

    @FXML
    void buttonPrevAction(ActionEvent event) {
        if (numberLevelOfTask-1 > 0) {
            numberLevelOfTask--;
            setLevel(numberLevelOfTask);
        }
        else {}
/*        Group group = buildScene();
        subsceneOne.setRoot(group);
        subsceneOne.setFill(Color.rgb(10, 10, 40));
        subsceneOne.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                anchorX = event.getSceneX();
                anchorY = event.getSceneY();
                anchorAngle = group.getRotate();
            }
        });
        subsceneOne.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    rotateY = new Rotate(rotateY.getAngle() + (anchorX - event.getSceneX())/10, Rotate.Y_AXIS);
                    rotateX = new Rotate(rotateX.getAngle() + (anchorY - event.getSceneY())/10, Rotate.X_AXIS);
                    group.getTransforms().setAll(rotateY, rotateX);
                }
                else {
                    group.setLayoutX(group.getLayoutX() + (anchorX - event.getSceneX())/5);
                    group.setLayoutY(group.getLayoutY() + (anchorY - event.getSceneY())/5);
                }
            }
        });
        addCamera(subsceneOne);*/
    }

    @FXML
    void initialize() {
        for (Node tempAncPane : anchorPaneAnswers.getChildren()) {
            for (Node radioButton : ((AnchorPane)tempAncPane).getChildren()) {
                ((RadioButton) radioButton).setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        int idButton = Integer.parseInt(((RadioButton) event.getSource()).getId().replaceAll("[^0-9]", ""));
                        for (Node tempAncPane : anchorPaneAnswers.getChildren()) {
                            for (Node tempButton : ((AnchorPane)tempAncPane).getChildren()) {
                                ((RadioButton) tempButton).setSelected(false);
                            }
                        }
                        ((RadioButton) event.getSource()).setSelected(true);
                        //TODO: перенести валидацию ответов в завершение задания и получение результатов
                        if (idButton == trueAnswer) {
                            mapTrueAnswerOnLevels.put(numberLevelOfTask, true);
                        } else {
                            mapTrueAnswerOnLevels.put(numberLevelOfTask, false);
                        }
                        mapAnswerInLevels.put(numberLevelOfTask, idButton);
                    }
                });
            }
        }
        numberLevelOfTask = 1;
        setLevel(numberLevelOfTask);
    }

}
