package client.Controllers;

import client.Models.Task;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Mesh;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import java.io.File;
import java.util.ArrayList;

public class LevelController {

    private static Task task = null;
    private Integer numberLevelOfTask = 0;
    private Integer trueAnswer = 0;

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
    }

    @FXML
    private ProgressBar progressBarTime;

    @FXML
    private AnchorPane anchorPaneButtons;

    @FXML
    private RadioButton buttonAnswer1;

    @FXML
    private RadioButton buttonAnswer2;

    @FXML
    private RadioButton buttonAnswer3;

    @FXML
    private RadioButton buttonAnswer4;

    @FXML
    private RadioButton buttonAnswer5;

    @FXML
    private RadioButton buttonAnswer6;

    @FXML
    private RadioButton buttonAnswer7;

    @FXML
    private RadioButton buttonAnswer8;

    @FXML
    private RadioButton buttonAnswer9;

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
        labelCounter.setText((numberLevelOfTask)+"/"+task.getTask().size());
        labelTopic.setText(task.getTask().get(numberLevelOfTask-1).getStringTopic());
        textAreaTask.setText(task.getTask().get(numberLevelOfTask-1).getStringTask());
        setAnswers(task.getTask().get(numberLevelOfTask-1).getIntegerNumberAnswer());
        trueAnswer = task.getTask().get(numberLevelOfTask-1).getIntegerTrueAnswer();
    }

    private void setAnswers(Integer answerCount) {
        if (answerCount <=3) {
            anchorPaneButtons.setMaxHeight(180);
        }
        else if (answerCount > 3 && answerCount <=6) {
            anchorPaneButtons.setMaxHeight(360);
        }
        else {
            anchorPaneButtons.setMaxHeight(542);
        }
        ObservableList<Node> buttons = anchorPaneButtons.getChildren();
        for (int i=0;i<answerCount;i++) {
            Button tempButton = (Button) buttons.get(i);
            tempButton.setVisible(true);
            tempButton.setBackground(new Background
                                                     (new BackgroundImage(task.getTask().get(numberLevelOfTask-1).getMasImageViewAnswer()[i].getImage(),
                                                                          BackgroundRepeat.NO_REPEAT,
                                                                          BackgroundRepeat.NO_REPEAT,
                                                                          BackgroundPosition.DEFAULT,
                                                                          BackgroundSize.DEFAULT)
                                                     )
                                    );
        }
    }
    @FXML
    void buttonEndAction(ActionEvent event) {

    }
    double anchorX, anchorY, anchorAngle;
    Rotate rotateX = new Rotate(), rotateY = new Rotate();
    @FXML
    void buttonNextAction(ActionEvent event) {
        numberLevelOfTask++;
        if (numberLevelOfTask-1 < task.getTask().size()) {
            setLevel(numberLevelOfTask);
        }
        else {}
    }

    @FXML
    void buttonPrevAction(ActionEvent event) {
        Group group = buildScene();
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
        addCamera(subsceneOne);
    }

    @FXML
    void initialize() {
        numberLevelOfTask = 1;
        setLevel(numberLevelOfTask);
    }

}
