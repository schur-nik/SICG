package client.Controllers;

import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Mesh;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

import java.io.File;

public class LevelController {

    private static final String MESH_FILENAME =
            "/Users/Shyr_NS/IdeaProjects/SECG/src/projectClient/resources/Tasks/3dModels/Besenhalter_325mm.stl";

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

    @FXML
    private ProgressBar progressBarTime;

    @FXML
    private AnchorPane acnhorPaneButtons;

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

    @FXML
    void buttonEndAction(ActionEvent event) {

    }
    double anchorX, anchorY, anchorAngle;
    @FXML
    void buttonNextAction(ActionEvent event) {
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
             /*   if (event.getButton().equals(MouseButton.SECONDARY)) {
                    group.setRotationAxis(Rotate.Y_AXIS);
                    group.setRotate(anchorAngle + anchorX - event.getSceneX());
                }
                else {
                    group.setRotationAxis(Rotate.X_AXIS);
                    group.setRotate(anchorAngle + anchorY - event.getSceneY());
                }*/
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    group.getTransforms().setAll(new Rotate(anchorAngle + anchorX - event.getSceneX(), Rotate.Y_AXIS),
                            new Rotate(anchorAngle + anchorY - event.getSceneY(), Rotate.X_AXIS));
                }
                else {
                    group.setLayoutX(group.getLayoutX() + anchorX - event.getSceneX());
                    group.setLayoutY(group.getLayoutY() + anchorY - event.getSceneY());
                }
            }
        });
        addCamera(subsceneOne);
    }

    @FXML
    void buttonPrevAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
    }

}
