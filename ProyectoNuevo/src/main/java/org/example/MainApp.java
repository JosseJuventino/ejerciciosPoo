package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        var root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        stage.setTitle("Gestor de Cuerpos Celestes");
        stage.setScene(new Scene((Parent) root, 600, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
