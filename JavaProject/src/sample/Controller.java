package sample;

import connectivity.connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class Controller implements Initializable {

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
    private Pane pane5;

    @FXML
    private TextField weight_txt;

    @FXML
    private Button weight_submit;

    @FXML
    private DatePicker weight_date;

    @FXML
    private Pane pane4;

    @FXML
    private AnchorPane pane3;

    @FXML
    private Pane pane3_3;

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
    private Pane pane3_1;

    @FXML
    private Button next2_1;

    @FXML
    private AnchorPane pane2;

    @FXML
    private Pane pane2_3;

    @FXML
    private Button prev2;

    @FXML
    private Pane pane2_2;

    @FXML
    private Button next2;

    @FXML
    private Button prev1;

    @FXML
    private Pane pane2_1;

    @FXML
    private Button next1;

    @FXML
    private Pane pane1;

    @FXML
    private Button blood;

    @FXML
    private Button glucose;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list1 = FXCollections.observableArrayList("Breakfast", "Lunch", "Dinner");
        ObservableList<String> list2 = FXCollections.observableArrayList("After", "Before");
        combo.setItems(list1);
        combo1.setItems(list1);
        combo2.setItems(list2);
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

        }else if(event.getSource()==blood_submit){
            connection con = new connection();
            Connection connection = con.getconnection();
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO category (id ,c_name,directory,icon) VALUES ('12','" + Blood_txt1.getText() + "','" + blood_txt2.getText() + "','" + heart_txt.getText() + "')";
            statement.executeUpdate(sql);        }
    }

}
