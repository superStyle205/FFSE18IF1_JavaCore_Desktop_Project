package account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectPeople;
import teacher.GiaoVien;

public class TaiKhoanDao {
	public void LoginUser(TaiKhoan taiKhoan) {
		String sql = "SELECT * FROM user WHERE UserName = ? AND Password = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, taiKhoan.getUserName());
			statement.setString(2, taiKhoan.getPassword());

			ResultSet result = statement.executeQuery();
			TaiKhoan taiKhoan1;
			while (result.next()) {
				taiKhoan1 = new TaiKhoan();
				taiKhoan1.setUserName(result.getString("UserName"));
				taiKhoan1.setPassword(result.getString("Password"));
			}
//			return;
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connectPeople.disconnect(conn);
		}
		return;
	}

	public List<TaiKhoan> getAllUser() {
		String sql = "SELECT * FROM user";

		List<TaiKhoan> listTaiKhoan = new ArrayList<TaiKhoan>();

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			TaiKhoan taiKhoan;
			while (result.next()) {
				taiKhoan = new TaiKhoan();
				taiKhoan.setUserName(result.getString("UserName"));
				taiKhoan.setPassword(result.getString("Password"));
				taiKhoan.setId_Rule(result.getString("id_role"));
				
				listTaiKhoan.add(taiKhoan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
		return listTaiKhoan;
	}

	public void addUser(TaiKhoan taiKhoan) {
		String sql = "INSERT INTO user(UserName,Password,id_rule) VALUES (?,?,?)";
		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, taiKhoan.getUserName());
			statement.setString(2, taiKhoan.getPassword());
			statement.setString(3, taiKhoan.getId_Rule());

			statement.executeUpdate();// executeUpdate đối với câu lệnh INSERT
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void updateUser(TaiKhoan taiKhoan) {
		String sql = "UPDATE user SET UserName = ?, Password = ? WHERE  id_role = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, taiKhoan.getUserName());
			statement.setString(2, taiKhoan.getPassword());
			statement.setString(3, taiKhoan.getId_Rule());

			statement.executeUpdate();// executeUpdate đối với câu lệnh Update

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void deleteUser(String id_rule) {
		String sql = "DELETE FROM tai_khoan_nguoi_dung WHERE id_role = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);// �?ối tượng đại diện cho 1 câu lệnh SQL
			statement.setString(1, id_rule);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}
}
