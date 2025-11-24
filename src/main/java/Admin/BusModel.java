package Admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.time.LocalDate;

public class BusModel {

    private final StringProperty busID;
    private final StringProperty location;
    private final StringProperty status;
    private final StringProperty price;
    private final StringProperty date;

    public BusModel(String busID, String location, String status, String price, LocalDate date) {
        this.busID = new SimpleStringProperty(busID);
        this.location = new SimpleStringProperty(location);
        this.status = new SimpleStringProperty(status);
        this.price = new SimpleStringProperty(price);
        this.date = new SimpleStringProperty(date != null ? date.toString() : "");
    }

    public String getBusID() { return busID.get(); }
    public void setBusID(String v) { busID.set(v); }
    public StringProperty busIDProperty() { return busID; }

    public String getLocation() { return location.get(); }
    public void setLocation(String v) { location.set(v); }
    public StringProperty locationProperty() { return location; }

    public String getStatus() { return status.get(); }
    public void setStatus(String v) { status.set(v); }
    public StringProperty statusProperty() { return status; }

    public String getPrice() { return price.get(); }
    public void setPrice(String v) { price.set(v); }
    public StringProperty priceProperty() { return price; }

    public String getDate() { return date.get(); }
    public void setDate(LocalDate d) { date.set(d.toString()); }
    public StringProperty dateProperty() { return date; }

    public LocalDate getDateAsLocalDate() {
        try {
            return LocalDate.parse(date.get());
        } catch (Exception e) {
            return null;
        }
    }
}
