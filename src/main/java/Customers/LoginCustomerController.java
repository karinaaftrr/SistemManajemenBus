package Customers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
