package teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectPeople;

public class GiaoVienDao {
	public boolean Login(String Id_GiaoVien, String Age) {
		String sql = "SELECT * FROM giaovien WHERE Id_GiaoVien = ? and Age = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, Id_GiaoVien);
			statement.setString(2, Age);

			ResultSet result = statement.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			connectPeople.disconnect(conn);
		}
		return false;
	}

	public List<GiaoVien> getAllUser() {
		String sql = "SELECT * FROM giaovien";

		List<GiaoVien> listGiaoVien = new ArrayList<GiaoVien>();

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			GiaoVien gv;
			while (result.next()) {
				gv = new GiaoVien();
				gv.setId_GiaoVien(result.getString("Id_GiaoVien"));
				gv.setFirstName(result.getString("FirstName"));
				gv.setLastName(result.getString("LastName"));
				gv.setAge(result.getInt("Age"));
				gv.setAddress(result.getString("Address"));
				gv.setSex(result.getString("Sex"));
				gv.setBirth(result.getString("Birth"));
				gv.setNumberPhone(result.getString("NumberPhone"));
				gv.setEmail(result.getString("Email"));
				gv.setPosition(result.getString("Position"));

				listGiaoVien.add(gv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
		return listGiaoVien;
	}

	public void addUser(GiaoVien gv) {
		String sql = "INSERT INTO giaovien(Id_GiaoVien,FirstName,LastName,Age,Address,Sex,Birth,NumberPhone,Email,Position) VALUES (?,?,?,?,?,?,?,?,?,?)";
		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, gv.getId_GiaoVien());
			statement.setString(2, gv.getFirstName());
			statement.setString(3, gv.getLastName());
			statement.setInt(4, gv.getAge());
			statement.setString(5, gv.getAddress());
			statement.setString(6, gv.getSex());
			statement.setString(7, gv.getBirth());
			statement.setString(8, gv.getNumberPhone());
			statement.setString(9, gv.getEmail());
			statement.setString(10, gv.getPosition());


			statement.executeUpdate();// executeUpdate đối với câu lệnh INSERT
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void updateUser(GiaoVien gv) {
		String sql = "UPDATE giaovien SET FirstName = ?, LastName = ?, Age = ?, Address = ?, Sex = ?, Birth = ?, NumberPhone = ?, Email = ?, Position = ? WHERE  Id_GiaoVien = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, gv.getFirstName());
			statement.setString(2, gv.getLastName());
			statement.setInt(3, gv.getAge());
			statement.setString(4, gv.getAddress());
			statement.setString(5, gv.getSex());
			statement.setString(6, gv.getBirth());
			statement.setString(7, gv.getNumberPhone());
			statement.setString(8, gv.getEmail());
			statement.setString(9, gv.getPosition());
			statement.setString(10, gv.getId_GiaoVien());
			

			statement.executeUpdate();// executeUpdate đối với câu lệnh Update

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void deleteUser(String Id_GiaoVien) {
		String sql = "DELETE FROM giaovien WHERE Id_GiaoVien = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);// �?ối tượng đại diện cho 1 câu lệnh SQL
			statement.setString(1, Id_GiaoVien);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}
}
