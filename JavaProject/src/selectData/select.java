package selectData;
import javafx.beans.property.SimpleStringProperty;

public  class select {

    SimpleStringProperty id, systolic, diastolic, peripulseod, historypressure_date;

    public select(String id, String systolic, String diastolic, String peripulseod, String historypressure_date) {
        this.id = new SimpleStringProperty(id);
        this.systolic = new SimpleStringProperty(systolic);
        this.diastolic = new SimpleStringProperty(diastolic);
        this.peripulseod = new SimpleStringProperty(peripulseod);
        this.historypressure_date = new SimpleStringProperty(historypressure_date);

    }

    public String getId() {
        return id.get();
    }

    public String getSystolic() {
        return systolic.get();
    }

    public String getDiastolic() {
        return diastolic.get();
    }

    public String getPeripulseod() {
        return peripulseod.get();
    }

    public String getHistorypressure_date() {
        return historypressure_date.get();
    }


}
