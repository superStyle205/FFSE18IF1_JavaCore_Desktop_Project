package coffemanagermvc.model.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectUtil {
    private final String className = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/db_coffeemanager?characterEncoding=UTF-8";
    private final String user = "root";
    private final String pass = "";
    private Connection connection;


    public Connection connect() {
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (SQLException e) {
            System.out.println("Error connection!");
        }

        return connection;
    }

    public void disconnect(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("disconnect error");
            }
        }
    }
}
