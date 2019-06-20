package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectUtil {
	public Connection connect() {
		Connection connection = null;
		try {
			Properties properties = new Properties();
			properties.put("user", "root");
			properties.put("password", "");
			properties.put("serverTimezone", "UTC");
			properties.put("characterEncoding", "UTF-8");
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement", properties);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("connect error ");
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
