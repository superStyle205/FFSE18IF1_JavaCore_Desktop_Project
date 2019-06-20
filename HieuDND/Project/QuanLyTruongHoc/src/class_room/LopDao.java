package class_room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectPeople;

public class LopDao {
	public boolean Login(String Id_Lop, String ClassName) {
		String sql = "SELECT * FROM lop WHERE Id_Lop = ? and ClassName = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, Id_Lop);
			statement.setString(2, ClassName);

			ResultSet result = statement.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			connectPeople.disconnect(conn);
		}
		return false;
	}

	public List<Lop> getAllUser() {
		String sql = "SELECT * FROM lop";

		List<Lop> listLop = new ArrayList<Lop>();

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			Lop lop;
			while (result.next()) {
				lop = new Lop();
				lop.setId_Lop(result.getString("Id_Lop"));
				lop.setClassName(result.getString("ClassName"));
				lop.setId_NienKhoa(result.getString("Id_NienKhoa"));
				
				listLop.add(lop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
		return listLop;
	}

	public void addUser(Lop lop) {
		String sql = "INSERT INTO lop(Id_Lop,ClassName,Id_NienKhoa) VALUES (?,?,?)";
		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, lop.getId_Lop());
			statement.setString(2, lop.getClassName());
			statement.setString(3, lop.getId_NienKhoa());
			
			statement.executeUpdate();//executeUpdate đối với câu lệnh INSERT
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void updateUser(Lop lop) {
		String sql = "UPDATE lop SET ClassName = ?, Id_NienKhoa = ? WHERE Id_Lop = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, lop.getClassName());
			statement.setString(2, lop.getId_NienKhoa());
			statement.setString(3, lop.getId_Lop());

			statement.executeUpdate();//executeUpdate đối với câu lệnh Update

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void deleteUser(String Id_Lop) {
		String sql = "DELETE FROM lop WHERE Id_Lop = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);//Đối tượng đại diện cho 1 câu lệnh SQL 
			statement.setString(1, Id_Lop);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}
}

