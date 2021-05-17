package client.Controllers;

import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Mesh;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

public class LevelMenuController {

    private static final String MESH_FILENAME =
            "/Users/Shyr_NS/IdeaProjects/SECG/src/projectClient/resources/Besenhalter_325mm.stl";

    private static final double MODEL_SCALE_FACTOR = 5;
    private static final double MODEL_X_OFFSET = 0; // standard
    private static final double MODEL_Y_OFFSET = 0; // standard

    private static final int VIEWPORT_SIZE = 800;
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
            meshViews[i].setTranslateX(VIEWPORT_SIZE / 2 + MODEL_X_OFFSET);
            meshViews[i].setTranslateY(VIEWPORT_SIZE / 2 + MODEL_Y_OFFSET);
            meshViews[i].setTranslateZ(VIEWPORT_SIZE / 2);
            meshViews[i].setScaleX(MODEL_SCALE_FACTOR);
            meshViews[i].setScaleY(MODEL_SCALE_FACTOR);
            meshViews[i].setScaleZ(MODEL_SCALE_FACTOR);
            meshViews[i].getTransforms().setAll(new Rotate(0, Rotate.X_AXIS),
                                                new Rotate(0, Rotate.Y_AXIS),
                                                new Rotate(0, Rotate.Z_AXIS));
        }
        root = new Group(meshViews);
        return root;
    }

    private PerspectiveCamera addCamera(Scene scene) {
        PerspectiveCamera perspectiveCamera = new PerspectiveCamera();
        scene.setCamera(perspectiveCamera);
        return perspectiveCamera;
    }

    private PerspectiveCamera addCamera(SubScene scene) {
        PerspectiveCamera perspectiveCamera = new PerspectiveCamera();
        scene.setCamera(perspectiveCamera);
        return perspectiveCamera;
    }

    @FXML
    private Button backButton;

    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MenuFrame.fxml"));
        newStage.setTitle("SECG");
        newStage.setScene(new Scene(root, 440, 670));
        newStage.show();
        backButton.getScene().getWindow().hide();
    }

    @FXML
    private AnchorPane testScene;

    @FXML
    private Button backButton1;

    @FXML
    private Button plusX;

    @FXML
    private Button plusY;

    @FXML
    private Button plusZ;

    @FXML
    private SubScene subsceneOne;

    double ang1 = 0, ang2 = 0, ang3 = 0;

    @FXML
    void initialize() {
        Group group = buildScene();
        plusX.setOnMouseClicked( new EventHandler<MouseEvent>() {
            @Override
            public void handle( MouseEvent event ) {
                ang1 += 10;
                group.getTransforms().setAll(new Rotate(ang1, Rotate.X_AXIS), new Rotate(ang2, Rotate.Y_AXIS), new Rotate(ang3, Rotate.Z_AXIS));
            }
        } );
        plusY.setOnMouseClicked( new EventHandler<MouseEvent>() {
            @Override
            public void handle( MouseEvent event ) {
                ang2 += 10;
                group.getTransforms().setAll(new Rotate(ang1, Rotate.X_AXIS), new Rotate(ang2, Rotate.Y_AXIS), new Rotate(ang3, Rotate.Z_AXIS));
            }
        } );
        plusZ.setOnMouseClicked( new EventHandler<MouseEvent>() {
            @Override
            public void handle( MouseEvent event ) {
                ang3 += 10;
                group.getTransforms().setAll(new Rotate(ang1, Rotate.X_AXIS), new Rotate(ang2, Rotate.Y_AXIS), new Rotate(ang3, Rotate.Z_AXIS));
            }
        } );
/*        group.setOnMousePressed((MouseEvent me) -> {
            mouseOldX = me.getSceneX();
            mouseOldY = me.getSceneY();
        });*/
/*        group.setOnMouseDragged((MouseEvent me) -> {
        });*/
        //Scene scene = new Scene(group, VIEWPORT_SIZE, VIEWPORT_SIZE, true);
        //subsceneOne = new SubScene(group, VIEWPORT_SIZE, VIEWPORT_SIZE);
        subsceneOne.setRoot(group);
        subsceneOne.setFill(Color.rgb(10, 10, 40));
        addCamera(subsceneOne);
/*        addCamera(scene);*/
/*        Stage stg = new Stage();
        stg.setScene(scene);
        stg.show();*/
    }
/*    Double x, y;
    Double mouseOldX = 0.0;
    Double mouseOldY = 0.0;
    Double mouseNewX = 0.0;
    Double mouseNewY = 0.0;
    Double mouseDeltaX = 0.0;
    Double mouseDeltaY = 0.0;*/
}
