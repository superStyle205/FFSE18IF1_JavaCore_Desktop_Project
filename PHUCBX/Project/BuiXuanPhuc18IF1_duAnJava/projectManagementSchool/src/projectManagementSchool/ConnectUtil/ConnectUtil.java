package projectManagementSchool.ConnectUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectUtil {

	public static Connection getConnect(String strServer, String strDatabase,
			String strUser, String strPwd) {	
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + ":3306/" + strDatabase;
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		pro.put("serverTimezone", "UTC");
		pro.put("characterEncoding", "UTF-8");
		try {
			// com.mysql.jdbc.Driver driver = new Driver();
			// conn = driver.connect(strConnect,pro);
			conn = DriverManager.getConnection(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return conn;
	};
	
	public void disconnect(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch(SQLException ex) {
				System.out.println("disconnect error");
			}
		}
	}
	
	public static void main(String[] args) {
		Connection conn1 = getConnect("localhost", "quanly", "root", "");
		if (conn1 != null) {
			System.out.println("ket noi MYSQL thanh cong");
		} else {
			System.out.println("Ket noi MYSQL that bai");
		}
	}
	
}