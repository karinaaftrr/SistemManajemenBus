module com.mycompany.systemmanagemenbus {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome5;
    requires java.base;

    opens com.mycompany.systemmanagemenbus to javafx.fxml;
    opens Customers to javafx.fxml;
    opens Admin to javafx.fxml;

    exports com.mycompany.systemmanagemenbus;
}
