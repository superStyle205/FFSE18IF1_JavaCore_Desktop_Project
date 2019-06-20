package students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectPeople;

public class HoSoHSDao {
	public boolean Login(String Id_HocSinh, String Age) {
		String sql = "SELECT * FROM hosohocsinh WHERE Id_HocSinh = ? and Age = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, Id_HocSinh);
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

	public List<HoSo_Student> getAllUser() {
		String sql = "SELECT * FROM hosohocsinh";

		List<HoSo_Student> listHoSoHocSinh = new ArrayList<HoSo_Student>();

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			HoSo_Student hosoHocSinh;
			while (result.next()) {
				hosoHocSinh = new HoSo_Student();
				hosoHocSinh.setId_HocSinh(result.getString("Id_HocSinh"));
				hosoHocSinh.setFirstName(result.getString("FirstName"));
				hosoHocSinh.setLastName(result.getString("LastName"));
				hosoHocSinh.setAge(result.getInt("Age"));
				hosoHocSinh.setAddress(result.getString("Address"));
				hosoHocSinh.setSex(result.getString("Sex"));
				hosoHocSinh.setBirth(result.getString("Birth"));
				hosoHocSinh.setPrimarySchool(result.getString("PrimarySchool"));
				hosoHocSinh.setJuniorHighSchool(result.getString("JuniorHighSchool"));
				hosoHocSinh.setHighSchool(result.getString("HighSchool"));
				hosoHocSinh.setStudyCapacity(result.getString("StudyCapacity"));
				hosoHocSinh.setConduct(result.getString("Conduct"));

				listHoSoHocSinh.add(hosoHocSinh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
		return listHoSoHocSinh;
	}

	public void addUser(HoSo_Student hosoHocSinh) {
		String sql = "INSERT INTO hosohocsinh(Id_HocSinh,FirstName,LastName,Age,Address,Sex,Birth,PrimarySchool,JuniorHighSchool,HighSchool,StudyCapacity,Conduct) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, hosoHocSinh.getId_HocSinh());
			statement.setString(2, hosoHocSinh.getFirstName());
			statement.setString(3, hosoHocSinh.getLastName());
			statement.setInt(4, hosoHocSinh.getAge());
			statement.setString(5, hosoHocSinh.getAddress());
			statement.setString(6, hosoHocSinh.getSex());
			statement.setString(7, hosoHocSinh.getBirth());
			statement.setString(8, hosoHocSinh.getPrimarySchool());
			statement.setString(9, hosoHocSinh.getJuniorHighSchool());
			statement.setString(10, hosoHocSinh.getHighSchool());
			statement.setString(11, hosoHocSinh.getStudyCapacity());
			statement.setString(12, hosoHocSinh.getConduct());

			statement.executeUpdate();// executeUpdate đối với câu lệnh INSERT
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void updateUser(HoSo_Student hosoHocSinh) {
		String sql = "UPDATE hosohocsinh SET FirstName = ?, LastName = ?, Age = ?, Address = ?, Sex = ?, Birth = ?, PrimarySchool = ?, JuniorHighSchool = ?, HighSchool = ?, StudyCapacity = ?, Conduct = ? WHERE Id_HocSinh = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, hosoHocSinh.getFirstName());
			statement.setString(2, hosoHocSinh.getLastName());
			statement.setInt(3, hosoHocSinh.getAge());
			statement.setString(4, hosoHocSinh.getAddress());
			statement.setString(5, hosoHocSinh.getSex());
			statement.setString(6, hosoHocSinh.getBirth());
			statement.setString(7, hosoHocSinh.getPrimarySchool());
			statement.setString(8, hosoHocSinh.getJuniorHighSchool());
			statement.setString(9, hosoHocSinh.getHighSchool());
			statement.setString(10, hosoHocSinh.getStudyCapacity());
			statement.setString(11, hosoHocSinh.getConduct());
			statement.setString(12, hosoHocSinh.getId_HocSinh());

			statement.executeUpdate();// executeUpdate đối với câu lệnh Update

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}

	public void deleteUser(String Id) {
		String sql = "DELETE FROM hosohocsinh WHERE Id_HocSinh = ?";

		ConnectPeople connectPeople = new ConnectPeople();
		Connection conn = connectPeople.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(sql);// �?ối tượng đại diện cho 1 câu lệnh SQL
			statement.setString(1, Id);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectPeople.disconnect(conn);
		}
	}
}
