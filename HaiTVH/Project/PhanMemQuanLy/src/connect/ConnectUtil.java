package connect;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectUtil {
	public Connection connect() {
		Connection connection = null;
		try {
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8", "root", "");
		} catch (SQLException e) {
			System.out.println("connect error");
			
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

