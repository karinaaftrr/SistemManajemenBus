package Customers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Register_CustomerController {

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    private static final Map<String, String> users = new HashMap<>();
    static {
        users.put("admin123", "123456");
        users.put("bus2024", "654321");
        users.put("customer01", "111222");
    }

    @FXML
    private void handleRegister(ActionEvent event) {
        String name = txtName.getText().trim();
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();

        if (name.isEmpty() || username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Register Gagal", "Semua field harus diisi!");
            return;
        }

        if (!isValidUsername(username)) {
            showAlert(Alert.AlertType.ERROR, "Register Gagal", "Username harus mengandung huruf dan angka!");
            return;
        }

        if (!isValidPassword(password)) {
            showAlert(Alert.AlertType.ERROR, "Register Gagal", "Password harus 6 digit angka!");
            return;
        }

        if (isUsernameExists(username)) {
            showAlert(Alert.AlertType.ERROR, "Register Gagal", "Username sudah digunakan!");
            return;
        }

        users.put(username, password);
        showAlert(Alert.AlertType.INFORMATION, "Register Berhasil", "Akun berhasil dibuat! Silakan login.");
        loadLoginPage();
    }

    @FXML
    private void handleBack(ActionEvent event) {
        loadLoginPage();
    }

    private boolean isValidUsername(String username) {
        return Pattern.matches("^(?=.*[a-zA-Z])(?=.*\\d).+$", username);
    }

    private boolean isValidPassword(String password) {
        return password.matches("\\d{6}");
    }

    private boolean isUsernameExists(String username) {
        return users.containsKey(username);
    }

    public static boolean checkLogin(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    private void loadLoginPage() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/logincustomer.fxml"));
            Stage stage = (Stage) txtName.getScene().getWindow();
            stage.setScene(new Scene(root, 750, 490));
            stage.show();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Gagal membuka halaman login!");
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
