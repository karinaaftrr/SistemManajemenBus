package com.mycompany.systemmanagemenbus;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        try {
            // Load scene awal: UserChoice.fxml
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/UserChoice.fxml"));

            stage.setTitle("Pilih User"); 
            stage.setScene(new Scene(root, 700, 500)); 
            stage.setResizable(false); 
            stage.show();
        } catch (IOException e) {
            System.err.println("Gagal load UserChoice.fxml");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
