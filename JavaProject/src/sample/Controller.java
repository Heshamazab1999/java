package sample;

import connectivity.connection;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private TableView<selectweight> weight_table;

    @FXML
    private TableColumn<selectweight, String> historyweight_date;

    @FXML
    private TableColumn<selectweight, String> WeightHistory;

    @FXML
    private TableColumn<selectweight, String> height;

    @FXML
    private TableColumn<selectweight, String> weight_state;
    @FXML


    private TableView<selectdata> glucose_table;

    @FXML
    private TableColumn<selectdata, String> number;

    @FXML
    private TableColumn<selectdata, String> value;

    @FXML
    private TableColumn<selectdata, String> meal;

    @FXML
    private TableColumn<selectdata, String> period;

    @FXML
    private TableColumn<selectdata, String> historical_date;
    @FXML
    private Button home;

    @FXML
    private Button history;

    @FXML
    private Button graphs;

    @FXML
    private Button medicine;

    @FXML
    private Button weight;

    @FXML
    private Button note;

    @FXML
    private Pane pane8;

    @FXML
    private TextField glucose_txt;

    @FXML
    private ComboBox<String> combo1;

    @FXML
    private ComboBox<String> combo2;

    @FXML
    private DatePicker glucose_date;

    @FXML
    private Button Glucose_submit;

    @FXML
    private Pane pane7;

    @FXML
    private TextField blood_txt2;

    @FXML
    private TextField Blood_txt1;

    @FXML
    private TextField heart_txt;

    @FXML
    private Button blood_submit;

    @FXML
    private DatePicker blood_date;

    @FXML
    private Pane pane6;

    @FXML
    private TextArea note_txt;

    @FXML
    private Button note_save;

    @FXML
    private Pane pane5;

    @FXML
    private TextField weight_txt;

    @FXML
    private Button weight_submit;

    @FXML
    private DatePicker weight_date;

    @FXML
    private TextField Height_txt;

    @FXML
    private Pane pane4;

    @FXML
    private Button medicine_save;

    @FXML
    private TextArea medicine_txt;

    @FXML
    private AnchorPane pane3;

    @FXML
    private Pane pane3_3;

    @FXML
    private LineChart<?, ?> weight_linechart;

    @FXML
    private Button prev2_2;

    @FXML
    private Pane pane3_2;

    @FXML
    private Button next2_2;

    @FXML
    private Button prev2_1;

    @FXML
    private ComboBox<String> combo;

    @FXML
    private LineChart<?, ?> glucose_linechart;

    @FXML
    private Pane pane3_1;

    @FXML
    private Button next2_1;

    @FXML
    private LineChart<?, ?> blood_linechart;

    @FXML
    private AnchorPane pane2;

    @FXML
    private Pane pane2_5;

    @FXML
    private TableView<selectMedicine> medicine_table;

    @FXML
    private TableColumn<selectMedicine, String> MedicineHistory;

    @FXML
    private Button medicinesupdate_btn;

    @FXML
    private Button medicinesdelete_btn;

    @FXML
    private Button prev4;

    @FXML
    private Pane pane2_4;

    @FXML
    private TableView<SelectNotes> notes_table;

    @FXML
    private TableColumn<SelectNotes, String> NotesHistory;

    @FXML
    private Button notesupdate_btn;

    @FXML
    private Button notesdelete_btn;

    @FXML
    private Button next4;

    @FXML
    private Button prev3;

    @FXML
    private Pane pane2_3;


    @FXML
    private TextField weightsearch_txt;

    @FXML
    private Button weightsearch_btn;

    @FXML
    private Button weightupdate_btn;

    @FXML
    private Button weightdelete_btn;

    @FXML
    private Button prev2;

    @FXML
    private Button next3;

    @FXML
    private Pane pane2_2;


    @FXML
    private TextField glucosesearch_txt;

    @FXML
    private Button glucosesearch_btn;

    @FXML
    private Button glucoseupdate_btn;

    @FXML
    private Button glucosedelete_btn;

    @FXML
    private Button next2;

    @FXML
    private Button prev1;

    @FXML
    private Pane pane2_1;

    @FXML
    private TableView<select> pressure_table;

    @FXML
    private TableColumn<select, String> id;

    @FXML
    private TableColumn<select, String> systolic;

    @FXML
    private TableColumn<select, String> diastolic;

    @FXML
    private TableColumn<select, String> pulse;

    @FXML
    private TableColumn<select, String> historypressure_date;

    @FXML
    public TextField pressuresearch_txt;

    @FXML
    private Button pressuresearch_btn;

    @FXML
    private Button pressureupdate_btn;

    @FXML
    private Button pressuredelete_btn;

    @FXML
    private Button next1;

    @FXML
    private Pane pane1;

    @FXML
    private Button blood;

    @FXML
    private Button glucose;
//---------------------------to take list from model database ---------------------------------------//
    ObservableList<select> listM;
    ObservableList<selectdata> listdata;
    ObservableList<selectweight> listdataweight;
    ObservableList<selectMedicine> listdatamedicine;
    ObservableList<SelectNotes> listnotes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list1 = FXCollections.observableArrayList("Breakfast", "Lunch", "Dinner");
        ObservableList<String> list2 = FXCollections.observableArrayList("After", "Before");
        combo1.setItems(list1);
        combo2.setItems(list2);
        //----------------------intialize presser---------------------//
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        systolic.setCellValueFactory(new PropertyValueFactory<>("systolic"));
        diastolic.setCellValueFactory(new PropertyValueFactory<>("diastolic"));
        pulse.setCellValueFactory(new PropertyValueFactory<>("peripulseod"));
        historypressure_date.setCellValueFactory(new PropertyValueFactory<>("historypressure_date"));
        listM = connection.getDatausers();
        pressure_table.setItems(listM);
//----------------------------------insert glucose table------------------------------//
        number.setCellValueFactory(new PropertyValueFactory<>("id"));
        value.setCellValueFactory(new PropertyValueFactory<>("systolic"));
        meal.setCellValueFactory(new PropertyValueFactory<>("diastolic"));
        period.setCellValueFactory(new PropertyValueFactory<>("peripulseod"));
        historical_date.setCellValueFactory(new PropertyValueFactory<>("historypressure_date"));
        listdata = connection.getData();
        glucose_table.setItems(listdata);
        //-----------------------------------insert weight table----------------------------------------------//
        weight_state.setCellValueFactory(new PropertyValueFactory<>("id"));
        WeightHistory.setCellValueFactory(new PropertyValueFactory<>("systolic"));
        height.setCellValueFactory(new PropertyValueFactory<>("diastolic"));
        historyweight_date.setCellValueFactory(new PropertyValueFactory<>("historypressure_date"));
        listdataweight = connection.getDataweight();
        weight_table.setItems(listdataweight);
        //-------------------------------- insert medicine table----------------------------------------//
        MedicineHistory.setCellValueFactory(new  PropertyValueFactory<>("id"));
        listdatamedicine = connection.getmedicine();
        medicine_table.setItems(listdatamedicine);
        //--------------------------------insert notes table---------------------------------------------------------//
        NotesHistory.setCellValueFactory(new  PropertyValueFactory<>("id"));
        listnotes = connection.getnotes();
        notes_table.setItems(listnotes);


    }


    public static class select {

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
    public static class selectMedicine {

        SimpleStringProperty id;

        public selectMedicine(String id) {
            this.id = new SimpleStringProperty(id);

        }

        public String getId() {
            return id.get();
        }

    }
    public static class selectweight {

        SimpleStringProperty id, systolic, diastolic, historypressure_date;

        public selectweight(String id, String systolic, String diastolic, String historypressure_date) {
            this.id = new SimpleStringProperty(id);
            this.systolic = new SimpleStringProperty(systolic);
            this.diastolic = new SimpleStringProperty(diastolic);
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

        public String getHistorypressure_date() {
            return historypressure_date.get();
        }


    }
    public static class selectdata {

        SimpleStringProperty id, systolic, diastolic, peripulseod, historypressure_date;

        public selectdata(String id, String systolic, String diastolic, String peripulseod, String historypressure_date) {
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
    public static class SelectNotes {

        SimpleStringProperty id;

        public SelectNotes(String id) {
            this.id = new SimpleStringProperty(id);
        }

        public String getId() {
            return id.get();
        }
    }



    @FXML
    void click(ActionEvent event) throws SQLException {
        if (event.getSource() == home) {
            pane1.toFront();
        } else if (event.getSource() == history) {
            pane2.toFront();
        } else if (event.getSource() == next1) {
            pane2_2.toFront();
        } else if (event.getSource() == next2) {
            pane2_3.toFront();
        } else if (event.getSource() == prev1) {
            pane2_1.toFront();
        } else if (event.getSource() == prev2) {
            pane2_2.toFront();
        } else if (event.getSource() == next3) {
            pane2_4.toFront();
        } else if (event.getSource() == next4) {
            pane2_5.toFront();
        } else if (event.getSource() == prev3) {
            pane2_3.toFront();
        } else if (event.getSource() == prev4) {
            pane2_4.toFront();
        } else if (event.getSource() == graphs) {
            pane3.toFront();
        } else if (event.getSource() == next2_1) {
            pane3_2.toFront();
        } else if (event.getSource() == next2_2) {
            pane3_3.toFront();
        } else if (event.getSource() == prev2_1) {
            pane3_1.toFront();
        } else if (event.getSource() == prev2_2) {
            pane3_2.toFront();
        } else if (event.getSource() == medicine) {
            pane4.toFront();

        } else if (event.getSource() == weight) {
            pane5.toFront();

        } else if (event.getSource() == note) {
            pane6.toFront();

        } else if (event.getSource() == blood) {
            pane7.toFront();

        } else if (event.getSource() == glucose) {
            pane8.toFront();

        }


        //-------------------------------------------------to insert blood------------------------------------------------------------------//
        else if (event.getSource() == blood_submit) {
            LocalDate value = blood_date.getValue();
            connection con = new connection();
            Connection connection = con.getconnection();
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO  pressure (id ,systolic,diastolic,heartrate,date) VALUES ('80','" + Blood_txt1.getText() + "','" + blood_txt2.getText() + "','" + heart_txt.getText() + "','" + value + "')";
            statement.executeUpdate(sql);
        }


        //------------------------------------------------------to insert glucose-------------------------------------------------------//
        else if (event.getSource() == Glucose_submit) {
            LocalDate value = glucose_date.getValue();
            connection con = new connection();
            Connection connection = con.getconnection();
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO  diabetes (id ,value,meal,period,date) VALUES ('30','" + glucose_txt.getText() + "','" + combo1.getValue() + "','" + combo2.getValue() +
                    "','" + value + "')";
            statement.executeUpdate(sql);
        }

        //----------------------------------------------------------------toinsertweight----------------------------------------------------//
        else if (event.getSource() == weight_submit) {
            LocalDate value = weight_date.getValue();
            connection con = new connection();
            Connection connection = con.getconnection();
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO  weight (id ,weight,height,date) VALUES ('20','" + weight_txt.getText() + "','" + Height_txt.getText() + "','" + value + "')";
            statement.executeUpdate(sql);

        }


        //-----------------------------------------tosearch blood-----------------------------------------------------------------------//
        else if (event.getSource() == pressuresearch_btn) {
            connection con = new connection();
            Connection connection = con.getconnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * from pressure where systolic IN ('" + pressuresearch_txt.getText() + "')";
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                System.out.println("id :" + set.getInt("systolic"));

            }


//------------------------------to delete blood--------------------------------------------------//
        } else if (event.getSource() == pressuredelete_btn) {
            connection con = new connection();
            Connection connection = con.getconnection();
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM pressure  WHERE id IN ('" + pressuresearch_txt.getText() + "')";
            statement.executeUpdate(sql);
        }

        //---------------------------------------to search glocus-----------------------------------//

        else if (event.getSource() == glucosesearch_btn) {
            connection con = new connection();
            Connection connection = con.getconnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM diabetes  WHERE id IN ('" + glucosesearch_txt.getText() + "')";
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                System.out.println("id :" + set.getString("meal"));
            }
        }
        //---------------------------------------------------to delete glucous---------------------------------------//
        else if (event.getSource() == glucosedelete_btn) {
            connection con = new connection();
            Connection connection = con.getconnection();
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM diabetes  WHERE id IN ('" + glucosesearch_txt.getText() + "')";
            statement.executeUpdate(sql);
        }
        //----------------------------------------to search weight-----------------------------------//
        else if (event.getSource() == weightsearch_btn) {
            connection con = new connection();
            Connection connection = con.getconnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM weight  WHERE id IN ('" + weightsearch_txt.getText() + "')";
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                System.out.println("id :" + set.getDate("date"));
            }

        } else if (event.getSource() == weightdelete_btn) {
            connection con = new connection();
            Connection connection = con.getconnection();
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM weight  WHERE id IN ('" + weightsearch_txt.getText() + "')";
            statement.executeUpdate(sql);
        }


        //-------------------------------------------------------------medicine_save----------------------------//


        else if (event.getSource() == medicine_save) {
            connection con = new connection();
            Connection connection = con.getconnection();
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO medicine(medicine) VALUES ('" + medicine_txt.getText() + "')";
            statement.executeUpdate(sql);
        }


        //-----------------------------------------note_save-----------------------------------//
        else if (event.getSource() == note_save) {
            connection con = new connection();
            Connection connection = con.getconnection();
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO notes(notes) VALUES ('" + note_txt.getText() + "')";
            statement.executeUpdate(sql);
        }
        //------------------------------------------to delete medicine--------------//
        else if (event.getSource() == medicinesdelete_btn) {
            connection con = new connection();
            Connection connection = con.getconnection();
            Statement statement = connection.createStatement();
            String sql = "delete from medicine order by medicine asc limit 1" ;
            statement.executeUpdate(sql);
        }
        //------------------------------------to delete notes----------------------//
        else if (event.getSource() == notesdelete_btn) {
            connection con = new connection();
            Connection connection = con.getconnection();
            Statement statement = connection.createStatement();
            String sql = "delete from notes order by notes asc limit 1" ;
            statement.executeUpdate(sql);
        }

    }

    @FXML
    void glucose(ActionEvent event) {

    }

    @FXML
    void medicine(ActionEvent event) {

    }

    @FXML
    void notes(ActionEvent event) {

    }

    @FXML
    void pressure(ActionEvent event) {

    }

    @FXML
    void weight(ActionEvent event) {

    }

    public void clic(MouseEvent mouseEvent) {


    }
}

