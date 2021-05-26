package client.Controllers;

        import com.aspose.cad.internal.N.G;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.geometry.Insets;
        import javafx.scene.Group;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.SubScene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.*;
        import javafx.scene.paint.Color;
        import javafx.scene.transform.Scale;
        import javafx.stage.Stage;
        import javafx.stage.StageStyle;

        import java.io.IOException;

public class MenuController {
    private double xOffset;
    private double yOffset;

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
    void buttonAuthAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Models/AuthFrame.fxml"));
        Stage authStage = new Stage();
        authStage.initStyle(StageStyle.UNDECORATED);
        authStage.initStyle(StageStyle.TRANSPARENT);
        authStage.setTitle("Authentication");
        Scene authScene = new Scene(root);
        authScene.setFill(Color.TRANSPARENT);
        authScene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = authStage.getX() - event.getScreenX();
                yOffset = authStage.getY() - event.getScreenY();
            }
        });
        authScene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                authStage.setX(event.getScreenX() + xOffset);
                authStage.setY(event.getScreenY() + yOffset);
            }
        });
        authStage.setScene(authScene);
        authStage.setResizable(false);
        authStage.show();
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
        pane.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0), CornerRadii.EMPTY, Insets.EMPTY)));
        pane.setCenter(new ImageView(new Image("TaskRes/Images/MenuImages/40iG.gif", 745, 560, true, false)));
        subsceneOne.setRoot(pane);
    }

}

