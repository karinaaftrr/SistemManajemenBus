package Customers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginCustomerController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private void login(ActionEvent event) {
        String user = username.getText().trim();
        String pass = password.getText().trim();

        if (Register_CustomerController.checkLogin(user, pass)) {
            showAlert(Alert.AlertType.INFORMATION, "Login Berhasil", "Selamat datang, " + user + "!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Gagal", "Username atau password salah!");
        }
    }

    @FXML
    private void Close(ActionEvent event) {
        Stage stage = (Stage) username.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void goToRegister(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/register_customer.fxml"));
            Stage stage = (Stage) username.getScene().getWindow();
            stage.setScene(new Scene(root, 750, 490)); // ukuran fix
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Gagal membuka halaman register!");
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
