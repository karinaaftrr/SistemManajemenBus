package Customers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Register_CustomerController {

    @FXML
    private void handleRegister(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Register");
        alert.setHeaderText(null);
        alert.setContentText("Tombol REGISTER ditekan!");
        alert.showAndWait();
    }

    @FXML
    private void handleBack(ActionEvent event) {
        try {
<<<<<<< HEAD
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/userchoice.fxml"));
=======
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/UserChoice.fxml"));
>>>>>>> 43899cc (first commit)
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Pilih Akun");
            stage.setScene(new Scene(root, 750, 490));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println("Gagal kembali ke Choice: " + e.getMessage());
        }
    }
}
