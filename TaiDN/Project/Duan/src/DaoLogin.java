import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoLogin {
	public boolean LoginJframe(String UserId, String Password){
		boolean flag = false;
		String sql = " SELECT * FROM dangnhap WHERE UserId = ? AND password = ?";
		
		Ketnoisql connection = new Ketnoisql();
		Connection sc = connection.connect();

		try {
			PreparedStatement statement = sc.prepareStatement(sql);

			statement.setString(1, UserId);
			statement.setString(2, Password);
			ResultSet result = statement.executeQuery();
			if(result.next() == true){
				flag = true;
			}
			else{
				flag = false;
			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			connection.disconnect(sc);
		}
		
		return flag;
		
	}
}
