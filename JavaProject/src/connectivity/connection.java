package connectivity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Controller;

import javax.swing.*;
import java.sql.*;

public class connection {
    public static Connection con;

    public static Connection getconnection() {
        Statement statement;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/patient", "root", "");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return con;
    }

    
    public static ObservableList<Controller.select> getDatausers() {
        Connection conn = getconnection();
        ObservableList<Controller.select> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from pressure");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Controller.select(rs.getString("id"),
                        rs.getString("systolic"),
                        rs.getString("diastolic"),
                        rs.getString("heartrate"),
                        rs.getString("date")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    } public static ObservableList<Controller.selectdata> getData() {
        Connection conn = getconnection();
        ObservableList<Controller.selectdata> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from diabetes");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Controller.selectdata(rs.getString("id"),
                        rs.getString("value"),
                        rs.getString("meal"),
                        rs.getString("period"),
                        rs.getString("date")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public static ObservableList<Controller.selectweight> getDataweight() {
        Connection conn = getconnection();
        ObservableList<Controller.selectweight> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from weight");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Controller.selectweight(rs.getString("id"),
                        rs.getString("height"),
                        rs.getString("weight"),
                        rs.getString("date")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }public static ObservableList<Controller.selectMedicine> getmedicine() {
        Connection conn = getconnection();
        ObservableList<Controller.selectMedicine> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from medicine");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Controller.selectMedicine(rs.getString("medicine")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }


    public static ObservableList<Controller.SelectNotes> getnotes() {
        Connection conn = getconnection();
        ObservableList<Controller.SelectNotes> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from notes");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Controller.SelectNotes(rs.getString("notes")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
