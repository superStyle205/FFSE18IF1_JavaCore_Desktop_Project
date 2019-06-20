import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ketnoisql {
	public Connection connect() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/duan", "root", "");
			//System.out.println("connect ok");
		}
		catch (SQLException e){
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
