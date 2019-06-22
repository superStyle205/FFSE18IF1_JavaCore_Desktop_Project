package ft.coffee.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectUtil {

	public static Connection getConnect() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tfcafe", "root", "");
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}

		return connection;
	}

	public static void closeConnect(Connection connection) throws SQLException {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new SQLException(e.getMessage());
			}
		}
	}

	public static void closeStatement(Statement statement) throws SQLException {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new SQLException(e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet result) throws SQLException {
		if (result != null) {
			try {
				result.close();
			} catch (SQLException e) {
				throw new SQLException(e.getMessage());
			}
		}
	}

	public static boolean isConnectDatabase() {
		Connection connection = null;
		try {
			connection = getConnect();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}
