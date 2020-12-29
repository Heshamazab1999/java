package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connection  {
    public Connection con;

    public Connection getconnection() {
        Statement statement;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/patient", "root", "");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
