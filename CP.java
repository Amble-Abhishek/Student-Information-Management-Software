package Student;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
    static Connection con;

    public static Connection create() {
        //load the driver
        try {
           // Class.forName("com.mysql.jdbc.Driver");

            // establish connection
            String user = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:3306/studentmg";
            con = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

    return con;
    }
}

