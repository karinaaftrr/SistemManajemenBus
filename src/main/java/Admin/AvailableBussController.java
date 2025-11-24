package Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class AvailableBussController implements Initializable {

    // ============= LEFT MENU ============ 
    @FXML private Button btnDashboard;
    @FXML private Button btnAvailableBuses;
    @FXML private Button btnBookingTicket;
    @FXML private Button btnCustomers;
    @FXML private Button btnLogout;

    // ============= FORM INPUT ============ 
    @FXML private TextField txtBusID;
    @FXML private TextField txtLocation;
    @FXML private ComboBox<String> cbStatus;
    @FXML private TextField txtPrice;
    @FXML private DatePicker datePicker;

    // Buttons
    @FXML private Button btnAdd;
    @FXML private Button btnUpdate;
    @FXML private Button btnReset;
    @FXML private Button btnDelete;

    // ============= TABLE ============ 
    @FXML private TableView<BusModel> tableBus;
    @FXML private TableColumn<BusModel, String> colBusID;
    @FXML private TableColumn<BusModel, String> colLocation;
    @FXML private TableColumn<BusModel, String> colStatus;
    @FXML private TableColumn<BusModel, String> colPrice;
    @FXML private TableColumn<BusModel, String> colDate;

    @FXML private TextField txtSearch;

    private final ObservableList<BusModel> busList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Isi ComboBox status
        cbStatus.getItems().addAll("Available", "Unavailable", "Maintenance");

        // Binding kolom tabel
        colBusID.setCellValueFactory(data -> data.getValue().busIDProperty());
        colLocation.setCellValueFactory(data -> data.getValue().locationProperty());
        colStatus.setCellValueFactory(data -> data.getValue().statusProperty());
        colPrice.setCellValueFactory(data -> data.getValue().priceProperty());
        colDate.setCellValueFactory(data -> data.getValue().dateProperty());

        tableBus.setItems(busList);

        // Klik tabel -> tampil ke form
        tableBus.setOnMouseClicked(event -> {
            BusModel selected = tableBus.getSelectionModel().getSelectedItem();
            if (selected != null) {
                txtBusID.setText(selected.getBusID());
                txtLocation.setText(selected.getLocation());
                cbStatus.setValue(selected.getStatus());
                txtPrice.setText(selected.getPrice());
                datePicker.setValue(selected.getDateAsLocalDate());
            }
        });

        // Search/filter realtime
        txtSearch.textProperty().addListener((obs, oldV, newV) -> filterTable(newV));
    }

    // ========================= CRUD INTERNAL =========================

    private boolean validateForm() {
        if (txtBusID.getText().isEmpty() ||
            txtLocation.getText().isEmpty() ||
            cbStatus.getValue() == null ||
            txtPrice.getText().isEmpty() ||
            datePicker.getValue() == null) {

            showAlert("Form tidak boleh kosong!");
            return false;
        }
        return true;
    }

    private void doAddBus() {
        if (!validateForm()) return;

        BusModel b = new BusModel(
                txtBusID.getText(),
                txtLocation.getText(),
                cbStatus.getValue(),
                txtPrice.getText(),
                datePicker.getValue()
        );

        busList.add(b);
        doResetForm();
    }

    private void doUpdateBus() {
        BusModel selected = tableBus.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        if (!validateForm()) return;

        selected.setBusID(txtBusID.getText());
        selected.setLocation(txtLocation.getText());
        selected.setStatus(cbStatus.getValue());
        selected.setPrice(txtPrice.getText());
        selected.setDate(datePicker.getValue());

        tableBus.refresh();
    }

    private void doDeleteBus() {
        BusModel selected = tableBus.getSelectionModel().getSelectedItem();
        if (selected != null) busList.remove(selected);
    }

    private void doResetForm() {
        txtBusID.clear();
        txtLocation.clear();
        cbStatus.setValue(null);
        txtPrice.clear();
        datePicker.setValue(null);
        tableBus.getSelectionModel().clearSelection();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    // ========================= HANDLER (DIPANGGIL FXML) =========================

    @FXML
    private void addBus(ActionEvent e) { doAddBus(); }

    @FXML
    private void updateBus(ActionEvent e) { doUpdateBus(); }

    @FXML
    private void deleteBus(ActionEvent e) { doDeleteBus(); }

    @FXML
    private void resetForm(ActionEvent e) { doResetForm(); }

    // ================== FILTER SEARCH ==================
    private void filterTable(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            tableBus.setItems(busList);
            return;
        }

        ObservableList<BusModel> filtered = FXCollections.observableArrayList();
        for (BusModel b : busList) {
            if (b.getBusID().toLowerCase().contains(keyword.toLowerCase()) ||
                b.getLocation().toLowerCase().contains(keyword.toLowerCase())) {
                filtered.add(b);
            }
        }
        tableBus.setItems(filtered);
    }

    // ========================= PAGE NAVIGATION =========================

    private void openPage(String fxmlName) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlName));
            Stage stage = (Stage) btnDashboard.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
        }
    }

    @FXML private void openDashboard() { openPage("/fxml/dashboardd_admin.fxml"); }
    @FXML private void openAvailableBuses() { openPage("/fxml/availablebuss.fxml"); }
    @FXML private void openBookingTicket() { openPage("/fxml/BookingTicket.fxml"); }
    @FXML private void openCustomers() { openPage("/fxml/Customers.fxml"); }
    @FXML private void logout() { openPage("/fxml/logincustomer.fxml"); }

}
