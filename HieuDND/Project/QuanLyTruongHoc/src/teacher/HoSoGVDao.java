package teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectPeople;


public class HoSoGVDao {
	public boolean Login(String Id_GiaoVien, String Age) {
		String sql = "SELECT * FROM hosogiaovien WHERE Id_GiaoVien = ? and Age = ?";

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

	public List<HoSo_Teacher> getAllUser() {
		String sql = "SELECT * FROM hosogiaovien";

		List<HoSo_Teacher> listHoSoGV = new ArrayList<HoSo_Teacher>();

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			HoSo_Teacher hosoGV;
			while (result.next()) {
				hosoGV = new HoSo_Teacher();
				hosoGV.setid_GiaoVien(result.getString("Id_GiaoVien"));
				hosoGV.setFirstName(result.getString("FirstName"));
				hosoGV.setLastName(result.getString("LastName"));
				hosoGV.setAge(result.getInt("Age"));
				hosoGV.setAddress(result.getString("Address"));
				hosoGV.setSex(result.getString("Sex"));
				hosoGV.setBirth(result.getString("Birth"));
				hosoGV.setNumberPhone(result.getString("NumberPhone"));
				hosoGV.setEmail(result.getString("Email"));
				hosoGV.setUniversity(result.getString("University"));
				hosoGV.setExperience(result.getString("Experience"));

				listHoSoGV.add(hosoGV);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
		return listHoSoGV;
	}

	public void addUser(HoSo_Teacher hosoGV) {
		String sql = "INSERT INTO hosogiaovien(Id_GiaoVien,FirstName,LastName,Age,Address,Sex,Birth,NumberPhone,Email,University,Experience) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, hosoGV.getId_GiaoVien());
			statement.setString(2, hosoGV.getFirstName());
			statement.setString(3, hosoGV.getLastName());
			statement.setInt(4, hosoGV.getAge());
			statement.setString(5, hosoGV.getAddress());
			statement.setString(6, hosoGV.getSex());
			statement.setString(7, hosoGV.getBirth());
			statement.setString(8, hosoGV.getNumberPhone());
			statement.setString(9, hosoGV.getEmail());
			statement.setString(10, hosoGV.getUniversity());
			statement.setString(11, hosoGV.getExperience());
			
			statement.executeUpdate();//executeUpdate đối với câu lệnh INSERT
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void updateUser(HoSo_Teacher hosoGV) {
		String sql = "UPDATE hosogiaovien SET FirstName = ?, LastName = ?, Age = ?, Address = ?, Sex = ?, Birth = ?, NumberPhone = ?, Email = ?, University = ?, Experience = ?  WHERE  Id_GiaoVien = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, hosoGV.getFirstName());
			statement.setString(2, hosoGV.getLastName());
			statement.setInt(3, hosoGV.getAge());
			statement.setString(4, hosoGV.getAddress());
			statement.setString(5, hosoGV.getSex());
			statement.setString(6, hosoGV.getBirth());
			statement.setString(7, hosoGV.getNumberPhone());
			statement.setString(8, hosoGV.getEmail());
			statement.setString(9, hosoGV.getUniversity());
			statement.setString(10, hosoGV.getExperience());
			statement.setString(11, hosoGV.getId_GiaoVien());

			statement.executeUpdate();//executeUpdate đối với câu lệnh Update

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void deleteUser(String Id_GiaoVien) {
		String sql = "DELETE FROM hosogiaovien WHERE Id_GiaoVien = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);//�?ối tượng đại diện cho 1 câu lệnh SQL 
			statement.setString(1, Id_GiaoVien);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}
}
