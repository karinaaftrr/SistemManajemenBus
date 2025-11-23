package Admin;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;
import javafx.stage.Stage;

public class LoginadminController {

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

        String user = username.getText();
        String pass = password.getText();

        System.out.println("Username: " + user);
        System.out.println("Password: " + pass);

        // (Optional) validasi sederhana
        if (user.equals("admin") && pass.equals("123")) {

            try {
                // Panggil Dashboard
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/Dashboard_Admin.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Dashboard Admin");
                stage.setScene(new Scene(root));
                stage.show();

                // Tutup window login
                ((Stage)((Node)event.getSource()).getScene().getWindow()).close();

            } catch (IOException e) {
            }

        } else {
            System.out.println("Login gagal!");
        }
    }
}
