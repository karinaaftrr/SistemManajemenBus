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
import javafx.scene.control.Label;

public class dashboardd_admincontroller implements Initializable {

<<<<<<< HEAD
    // =========================================
    //           TOMBOL SIDEBAR
    // =========================================
    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnAvailableBuses;

    @FXML
    private Button btnBookingTicket;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnLogout;

    @FXML
    private Label labelAvailableBus;

    @FXML
    private Label labelIncomeToday;

    @FXML
    private Label labelTotalIncome;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Data dummy (sementara belum database)
=======
    @FXML private Button btnDashboard;
    @FXML private Button btnAvailableBuses;
    @FXML private Button btnBookingTicket;
    @FXML private Button btnCustomers;
    @FXML private Button btnLogout;

    @FXML private Label labelAvailableBus;
    @FXML private Label labelIncomeToday;
    @FXML private Label labelTotalIncome;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
>>>>>>> 43899cc (first commit)
        updateAvailableBus();
        updateIncome();
    }

    private void updateAvailableBus() {
        int total = getTotalAvailableBus();
        labelAvailableBus.setText(String.valueOf(total));
    }

    private int getTotalAvailableBus() {
<<<<<<< HEAD
        // sementara, anggap ada 12 bus available
=======
>>>>>>> 43899cc (first commit)
        return 12;
    }

    private void updateIncome() {
        long today = getIncomeToday();
        long total = getTotalIncome();

        labelIncomeToday.setText("Rp. " + today);
        labelTotalIncome.setText("Rp. " + total);
    }

    private long getIncomeToday() {
<<<<<<< HEAD
        // dummy: today's income = 350.000
=======
>>>>>>> 43899cc (first commit)
        return 350000;
    }

    private long getTotalIncome() {
<<<<<<< HEAD
        // dummy: total income = 15.500.000
=======
>>>>>>> 43899cc (first commit)
        return 15500000;
    }

    @FXML
    private void openDashboard(ActionEvent event) throws IOException {
<<<<<<< HEAD
        openPage("Dashboard_Admin.fxml", event);
=======
        openPage("/fxml/dashboardd_admin.fxml", event);
>>>>>>> 43899cc (first commit)
    }

    @FXML
    private void openAvailableBuses(ActionEvent event) throws IOException {
<<<<<<< HEAD
        openPage("Available_Buses.fxml", event);
=======
        openPage("/fxml/availablebuss.fxml", event);
>>>>>>> 43899cc (first commit)
    }

    @FXML
    private void openBookingTicket(ActionEvent event) throws IOException {
<<<<<<< HEAD
        openPage("Booking_Ticket.fxml", event);
=======
        openPage("/fxml/BookingTicket.fxml", event);
>>>>>>> 43899cc (first commit)
    }

    @FXML
    private void openCustomers(ActionEvent event) throws IOException {
<<<<<<< HEAD
        openPage("Customers.fxml", event);
=======
        openPage("/fxml/Customers.fxml", event);
>>>>>>> 43899cc (first commit)
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
<<<<<<< HEAD
        openPage("Login.fxml", event);
    }
    
    private void openPage(String fxml, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(root);
=======
        openPage("/fxml/logincustomer.fxml", event);
    }

    private void openPage(String fxml, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
>>>>>>> 43899cc (first commit)

        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();
<<<<<<< HEAD
        
        stage.setScene(new Scene(root, 750, 490));
=======

        // Hanya buat sekali
        Scene scene = new Scene(root, 750, 490);
        stage.setScene(scene);
>>>>>>> 43899cc (first commit)
        stage.show();
    }
}
