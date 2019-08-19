package ru.kiselev;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.File;
import java.io.IOException;

public class FXApplication extends Application {
    public static void main(String[] args) {

        launch(args);
    }
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(new File("src/main/resources/sample.fxml").toURL());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Application");
        stage.setWidth(315);
        stage.setHeight(170);
        stage.show();
    }
}
