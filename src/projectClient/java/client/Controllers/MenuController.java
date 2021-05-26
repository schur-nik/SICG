package client.Controllers;

        import com.aspose.cad.internal.N.G;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.geometry.Insets;
        import javafx.scene.Group;
        import javafx.scene.Parent;
        import javafx.scene.SubScene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.*;
        import javafx.scene.paint.Color;
        import javafx.scene.transform.Scale;

        import java.io.IOException;

public class MenuController {

    @FXML
    private Label l1menu;

    @FXML
    private AnchorPane anchorPaneMenu;

    @FXML
    private Button buttonStart;

    @FXML
    private Button buttonAuth;

    @FXML
    private Button buttonEdit;

    @FXML
    private Button buttonExit;

    @FXML
    private AnchorPane anchorPaneSubscene;

    @FXML
    private SubScene subsceneOne;

    @FXML
    void buttonAuthAction(ActionEvent event) {

    }

    @FXML
    void buttonEditAction(ActionEvent event) {

    }

    @FXML
    void buttonExitAction(ActionEvent event) {

    }

    @FXML
    void buttonStartAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Models/LevelMenuFrame.fxml"));
        buttonStart.getScene().setRoot(root);
    }

    @FXML
    void initialize() {
        BorderPane pane = new BorderPane();
        //pane.setPrefSize(745, 560);
        pane.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0), CornerRadii.EMPTY, Insets.EMPTY)));
        pane.setCenter(new ImageView(new Image("TaskRes/Images/MenuImages/40iG.gif", 745, 560, true, false)));
        subsceneOne.setRoot(pane);

    }

}

