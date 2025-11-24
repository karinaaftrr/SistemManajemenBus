package Customers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Choice_AccountController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Tidak ada yang perlu diinisialisasi dulu
    }    
    
    @FXML
    private void Register(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/register_customer.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Register Customer");

            // Paksa scene dengan ukuran 750x490 dan stage tidak bisa di-resize
            Scene scene = new Scene(root, 750, 490);
            stage.setScene(scene);
            stage.setResizable(false); // opsional, supaya ukuran fix
            stage.show();
        } catch (IOException e) {
            System.out.println("Gagal membuka halaman Register: " + e.getMessage());
        }
    }

    @FXML
    private void Login(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/logincustomer.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Login Customer");

            Scene scene = new Scene(root, 750, 490);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println("Gagal membuka halaman Login: " + e.getMessage());
        }
    }
}
