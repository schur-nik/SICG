package client;

import client.Models.LocalTasks;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Models/MenuFrame.fxml"));
        primaryStage.setTitle("SECG");
        primaryStage.setScene(new Scene(root, 1250, 750));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        new LocalTasks().start();
        launch(args);
    }
}
