package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectPeople;

public class LoginDao {
	public boolean Login(String UserName , String Password) {
		String sql = "SELECT * FROM user WHERE UserName = ? AND Password = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, UserName);
			statement.setString(2, Password);

			ResultSet result = statement.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			connectPeople.disconnect(conn);
		}
		return false;
	}
}
