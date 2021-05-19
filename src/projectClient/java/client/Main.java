package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Main extends Application {
    public static ObjectOutputStream coos;
    public static ObjectInputStream cois;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Models/MenuFrame.fxml"));
        primaryStage.setTitle("SECG");
        primaryStage.setScene(new Scene(root, 1250, 750));
        primaryStage.show();
    }

    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("127.0.0.1", 1006);
            coos = new ObjectOutputStream(clientSocket.getOutputStream());
            cois = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        launch(args);
    }
}
