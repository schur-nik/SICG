package client.Controllers;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.SubScene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.layout.AnchorPane;

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
    void initialize() {}

}

