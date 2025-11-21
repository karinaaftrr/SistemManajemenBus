package Mahasiswa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginMahasiswaController {

    @FXML
    private Button Close;

    @FXML
    private AnchorPane close;

    @FXML
    private Button login;

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    void Close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void login(ActionEvent event) {
        System.out.println("Username: " + username.getText());
        System.out.println("Password: " + password.getText());
    }
}
