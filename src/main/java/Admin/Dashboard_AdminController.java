package Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Dashboard_AdminController implements Initializable {
    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnMonitoring;

    @FXML
    private Button btnJadwal;

    @FXML
    private Button btnKapasitas;

    @FXML
    private Button btnPengaduan;

    @FXML
    private Button btnPengaturan;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnDetailTotalBus;

    @FXML
    private Button btnDetailStatusBus;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inisialisasi jika dibutuhkan
    }

    @FXML
    private void openDashboard(ActionEvent event) throws IOException {
        openPage("Dashboard_Admin.fxml", event);
    }

    @FXML
    private void openMonitoring(ActionEvent event) throws IOException {
        openPage("Monitoring_Lokasi_Tayo.fxml", event);
    }

    @FXML
    private void openJadwal(ActionEvent event) throws IOException {
        openPage("Jadwal_Tayo.fxml", event);
    }

    @FXML
    private void openKapasitas(ActionEvent event) throws IOException {
        openPage("Kapasitas_Tayo.fxml", event);
    }

    @FXML
    private void openPengaduan(ActionEvent event) throws IOException {
        openPage("Informasi_Pengaduan.fxml", event);
    }

    @FXML
    private void openPengaturan(ActionEvent event) throws IOException {
        openPage("Pengaturan.fxml", event);
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        openPage("Login.fxml", event);
    }


    // ==============================
    //        DETAIL BUTTON
    // ==============================

    @FXML
    private void detailTotalBus(ActionEvent event) throws IOException {
        openPage("Detail_TotalBus.fxml", event);
    }

    @FXML
    private void detailStatusBus(ActionEvent event) throws IOException {
        openPage("Detail_StatusBus.fxml", event);
    }


    // ==============================
    //  FUNGSI UNTUK GANTI HALAMAN
    // ==============================

    private void openPage(String fxml, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
