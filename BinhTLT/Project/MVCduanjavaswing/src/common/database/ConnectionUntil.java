package common.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ConnectionUntil {
	public Connection connect() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlquanlisinhvien?characterEncoding=UTF-8", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
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
