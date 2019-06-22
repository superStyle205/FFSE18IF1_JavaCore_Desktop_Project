package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectPeople {
	public Connection connect() {
		Connection conn = null;//một kết nối với một cơ sở dữ liệu cụ thể,các câu lệnh SQL được thực thi và kết quả đưoowc trả về
		String url = "jdbc:mysql://localhost/quanlytruonghoc?characterEncoding = UTF-8";

		try {
			conn = DriverManager.getConnection(url, "root", "");//DM là trình quản lý bộ điều khiểu JDBC(Java DataBase Connectivity)
		} catch (SQLException e) {
			System.out.println("connect error");
		}
		return conn;
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

