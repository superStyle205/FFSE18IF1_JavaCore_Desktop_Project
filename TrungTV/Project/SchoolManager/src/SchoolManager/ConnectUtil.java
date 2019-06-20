package SchoolManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectUtil {
	public Connection connect() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanager?characterEncoding=UTF-8", "root", "");
		} catch (SQLException e) {
			System.out.println("Connect Error !!!");
		} 
		return connection;
	}
	
	public void disconnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Disconnection Error !!!");
			}
		}
	}
}
