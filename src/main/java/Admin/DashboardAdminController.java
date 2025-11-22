package Admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class DashboardAdminController implements Initializable {

    // ========== SIDEBAR BUTTONS ==========
    @FXML
    private Button dashboardBtn;

    @FXML
    private Button jadwalBtn;

    @FXML
    private Button pengaduanBtn;

    @FXML
    private Button supirBtn;

    @FXML
    private Button pengaturanBtn;

    @FXML
    private Button signOutBtn;

    // ========== PANEL BAWAH ==========
    @FXML
    private Pane bottomPanel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Dashboard Admin berhasil dibuka ✅");
    }

    // ========== ACTION METHODS ==========

    @FXML
    private void dashboardAction() {
        System.out.println("Tombol Dashboard diklik");
    }

    @FXML
    private void jadwalAction() {
        System.out.println("Tombol Monitoring Jadwal diklik");
    }

    @FXML
    private void pengaduanAction() {
        System.out.println("Tombol Pengaduan Customers diklik");
    }

    @FXML
    private void supirAction() {
        System.out.println("Tombol Data Supir diklik");
    }

    @FXML
    private void pengaturanAction() {
        System.out.println("Tombol Pengaturan diklik");
    }

    @FXML
    private void signOutAction() {
        System.out.println("Sign Out diklik");
        System.exit(0);
    }
}
