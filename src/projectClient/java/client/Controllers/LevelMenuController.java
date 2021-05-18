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

    @FXML
    private Button buttonLevel1;

    @FXML
    void buttonLevel1Action(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Models/LevelFrame.fxml"));
        buttonLevel1.getScene().setRoot(root);
    }

    @FXML
    private SubScene subsceneOne;

    @FXML
    void initialize() {
    }

}
