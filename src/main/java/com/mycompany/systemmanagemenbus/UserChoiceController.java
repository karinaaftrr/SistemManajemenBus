package com.mycompany.systemmanagemenbus;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class UserChoiceController {

    @FXML
    private void loginAdmin(ActionEvent event) {
        try {
            // Pastikan nama file dan folder FXML sesuai (case-sensitive)
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginAdmin.fxml"));
            
            // Ambil stage yang sama dari tombol
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Login Admin");
            stage.setScene(new Scene(root, 700, 500));
            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace(); // Supaya error terlihat di console
        }
    }

    @FXML
    private void loginMahasiswa(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginMahasiswa.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Login Mahasiswa");
            stage.setScene(new Scene(root, 700, 500));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
